package com.tulesh.springboot.service.impl;

import com.tulesh.springboot.DAO.TaskDAO;
import com.tulesh.springboot.DTO.TaskDTO;
import com.tulesh.springboot.enun.TaskStatus;
import com.tulesh.springboot.exception.CustomException;
import com.tulesh.springboot.model.Task;
import com.tulesh.springboot.model.User;
import com.tulesh.springboot.repository.TaskRepository;
import com.tulesh.springboot.repository.UserRepository;
import com.tulesh.springboot.service.TaskService;
import com.tulesh.springboot.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskDAO taskDAO;

    @Override
    public Task createOrUpdateTask(TaskDTO taskDTO, Boolean isNew) throws CustomException {
        TaskStatus taskStatus = TaskStatus.getTaskEnum(taskDTO.getStatus());
        if (taskStatus == null) {
            throw new CustomException("Invalid task status ", HttpStatus.valueOf(404));
        }
        try {
            Task task = new Task();
            if (!isNew) {
                if(Objects.equals(taskDTO.getId(), null)) {
                    throw new CustomException("Please provide details to update task ", HttpStatus.valueOf(200));
                }
                task = taskRepository.findById(taskDTO.getId()).get();
                isAuthorizeToDeleteOrUpdateTask(task);
                task.setUpdatedAt(new Date());
            } else {
                task.setCreatedAt(new Date());
            }
            task.setTitle(taskDTO.getTitle());
            task.setDescription(taskDTO.getDescription());
            task.setDueDate(taskDTO.getDueDate());
            task.setStatus(TaskStatus.getTaskEnum(taskDTO.getStatus()));
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = userRepository.findByUsername(authentication.getName());
            task.setCreatedBy(user);
            taskRepository.save(task);
            return task;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public Task deleteTask(Long taskId) throws CustomException {
        Optional<Task> deletableTask = taskRepository.findById(taskId);
        if (deletableTask.isPresent()) {
            isAuthorizeToDeleteOrUpdateTask(deletableTask.get());
            Task task = deletableTask.get();
            taskRepository.delete(task);
            return task;
        } else {
            return null; // Indicates that taskId is not available
        }
    }

    @Override
    public List<TaskDTO> getAllTask() {
        List<TaskDTO> allTask = taskDAO.getAllTask();
        return allTask;
    }

    @Override
    public List<TaskDTO> getUserTask() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(authentication.getName());
        List<TaskDTO> allUserTask = taskDAO.getUserTask(user.getId());
        return allUserTask;
    }

    @Override
    public TaskDTO taskById(Long taskId) {
        return taskDAO.findById(taskId);
    }

    public void isAuthorizeToDeleteOrUpdateTask(Task task) throws CustomException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(authentication.getName());
        if (!Objects.equals(task.getCreatedBy(), user)) {
            throw new CustomException("You are not authorized to delete the task");
        }
    }


}
