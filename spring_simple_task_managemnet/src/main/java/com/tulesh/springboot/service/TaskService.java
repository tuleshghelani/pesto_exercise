package com.tulesh.springboot.service;

import com.tulesh.springboot.DTO.TaskDTO;
import com.tulesh.springboot.exception.CustomException;
import com.tulesh.springboot.model.Task;

import java.util.List;
import java.util.Set;

public interface TaskService {
    public Task createOrUpdateTask(TaskDTO taskDTO, Boolean isNew) throws CustomException;

    public Task deleteTask(Long taskId) throws CustomException;

    public List<TaskDTO> getAllTask();

    public List<TaskDTO> getUserTask();

    public TaskDTO taskById(Long taskId);
}
