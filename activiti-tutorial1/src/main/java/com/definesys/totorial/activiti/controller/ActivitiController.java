package com.definesys.totorial.activiti.controller;

import com.definesys.totorial.activiti.dto.TaskRepresentation;
import com.definesys.totorial.activiti.service.ActivitiService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2019/9/5 11:07 AM
 * @history: 1.2019/9/5 created by jianfeng.zheng
 */
@RestController
@RequestMapping(value = "activiti")
public class ActivitiController {

    @Autowired
    private ActivitiService service;

    @RequestMapping(value = "start", method = RequestMethod.GET)
    public String start() {
        return service.start();
    }

    @RequestMapping(value = "task", method = RequestMethod.GET)
    public List<TaskRepresentation> getTask(@RequestParam(value = "uid") String uid) {
        List<Task> tasks = service.getTask(uid);
        List<TaskRepresentation> dtos = new ArrayList<>();
        for (Task task : tasks) {
            dtos.add(new TaskRepresentation(task.getId(), task.getName()));
        }
        return dtos;
    }
}
