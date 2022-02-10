package com.test.vergo.repository;

import com.test.vergo.dto.TaskDTO;

import java.util.List;

public interface TasksRepository {

    public List<TaskDTO> getTasks();
    public TaskDTO getTask(int idTask);
    public int updateTask(TaskDTO dto, int idTask);
    public int countUserTask(int idUser);
}
