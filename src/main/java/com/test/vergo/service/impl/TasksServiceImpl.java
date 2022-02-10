package com.test.vergo.service.impl;

import com.test.vergo.dto.ResponseDTO;
import com.test.vergo.dto.TaskDTO;
import com.test.vergo.repository.TasksRepository;
import com.test.vergo.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TasksServiceImpl implements TasksService {

    @Autowired
    private TasksRepository taskRepository;

    @Transactional(readOnly = true)
    @Override
    public List<TaskDTO> getTask(){
        return taskRepository.getTasks();
    }

    @Transactional(readOnly = true)
    @Override
    public TaskDTO getTaskO(int idTask){
        return taskRepository.getTask(idTask);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public ResponseDTO updateTask(TaskDTO dto, int idTask){
        TaskDTO task = taskRepository.getTask(idTask);
        int taskAssigned = taskRepository.countUserTask(dto.getAssigne());
        ResponseDTO response = new ResponseDTO();
        if(taskAssigned >= 5 && task.getAssigne() != dto.getAssigne()){
            response.setMessage("The number of assignments reached the limit ");
            response.setCode(12);
        }else{
            taskRepository.updateTask(dto, idTask);
            response.setMessage("task updated successfully ");
            response.setCode(00);

        }
        return response;
    }


}
