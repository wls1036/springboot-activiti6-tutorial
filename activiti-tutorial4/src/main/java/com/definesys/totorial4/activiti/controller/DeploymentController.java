package com.definesys.totorial4.activiti.controller;

import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2019/9/19 6:34 PM
 * @history: 1.2019/9/19 created by jianfeng.zheng
 */
@RestController
public class DeploymentController {

    @Autowired
    private DeploymentService service;

    @PostMapping(value = "/deploy")
    public String deploy(@RequestParam("file") MultipartFile file) {
        try {
            return service.deploy(file.getOriginalFilename(), file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("upload failed");
        }
    }

    @PostMapping(value = "/deployBpmn")
    public String deployBpmn(@RequestParam("file") MultipartFile file) {
        try {
            String name = file.getOriginalFilename();
            if (!name.endsWith(".bpmn20.xm") && !name.endsWith(".bpmn")) {
                name = name + ".bpmn";
            }
            return service.noChangeNoDeploy(name, file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("upload failed");
        }
    }
}
