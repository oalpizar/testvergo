package com.test.vergo.service;

import com.test.vergo.dto.ResponseDTO;
import com.test.vergo.dto.TaskDTO;

import java.util.List;

public interface TasksService {
    public List<TaskDTO> getTask();
    public TaskDTO getTaskO(int idTask);
    public ResponseDTO updateTask(TaskDTO dto, int idTask);
}
