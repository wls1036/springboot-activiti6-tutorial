package com.definesys.totorial4.activiti.controller;

import com.definesys.totorial4.activiti.util.ActivitiUtil;
import org.activiti.engine.ActivitiObjectNotFoundException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2019/9/20 1:09 AM
 * @history: 1.2019/9/20 created by jianfeng.zheng
 */
@Service
public class DeploymentService {

    @Autowired
    private RepositoryService repositoryService;

    /**
     * deploy resource
     *
     * @param name resource name
     * @param fin  resource inputstream
     * @return
     */
    public String deploy(String name, InputStream fin) {
        String deploymentId = repositoryService.createDeployment()
                .addInputStream(name, fin)
                .name(name)
                .key(name)
                .deploy()
                .getId();
        return deploymentId;
    }

    /**
     * deploy resource
     *
     * @param name resource name
     * @param fin  resource inputstream
     * @return
     */
    public String noChangeNoDeploy(String name, InputStream fin) {
        //获取最新的一次部署
        Deployment latestDeployment = repositoryService.createDeploymentQuery()
                .deploymentName(name)
                .deploymentKey(name)
                .latest()
                .singleResult();
        String sbpmn = ActivitiUtil.text(fin);
        if (latestDeployment != null) {
            //检测是否内容发生变化，只重新部署有修改的流程
            InputStream input = repositoryService.getResourceAsStream(latestDeployment.getId(), name);
            String dbpmn = ActivitiUtil.text(input);
            if (sbpmn.length() == dbpmn.length() && sbpmn.equals(dbpmn)) {
                return latestDeployment.getId();
            }
        }
        String deploymentId = repositoryService.createDeployment()
                .addString(name, sbpmn)
                .name(name)
                .key(name)
                .deploy()
                .getId();
        return deploymentId;
    }

}
