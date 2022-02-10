package com.test.vergo.controller;

import com.test.vergo.dto.ResponseDTO;
import com.test.vergo.dto.TaskDTO;
import com.test.vergo.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TasksController {

    @Autowired
    private TasksService taskService;

    @GetMapping(value = "/api/tasks", produces = "application/json")
    public List<TaskDTO> getTasks(){
        return taskService.getTask();
    }

    @GetMapping(value = "/api/tasks/{idTask}", produces = "application/json")
    public TaskDTO getTaskO(@PathVariable("idTask") int idTask){
        return taskService.getTaskO(idTask);
    }

    @PostMapping(value = "/api/tasks/{idTask}", produces = "application/json")
    public ResponseDTO updateTask(@RequestBody TaskDTO dto, @PathVariable("idTask") int idTask){
        return taskService.updateTask(dto, idTask);
    }

}
