package com.tulesh.springboot.controller;

import com.tulesh.springboot.DTO.TaskDTO;
import com.tulesh.springboot.DTO.response.ResponseDTO;
import com.tulesh.springboot.exception.CustomException;
import com.tulesh.springboot.model.Task;
import com.tulesh.springboot.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/task")
@CrossOrigin("*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/createTask")
    public ResponseDTO<Task> createTask(@RequestBody TaskDTO taskDTO) throws CustomException {
        ResponseDTO<Task> responseDto = new ResponseDTO<Task>("Created task successfully!!!", this.taskService.createOrUpdateTask(taskDTO, true));
        return responseDto;
    }

    @PutMapping("/updateTask")
    public ResponseDTO<Task> updateTask(@RequestBody TaskDTO taskDTO) throws CustomException {
        ResponseDTO<Task> responseDto = new ResponseDTO<Task>("Updated task successfully!!!", this.taskService.createOrUpdateTask(taskDTO, false));
        return responseDto;
    }

    @DeleteMapping("/deleteTask")
    public ResponseDTO<Task> deleteTask(@RequestParam Long taskId) throws CustomException {
        Task deletedTask = this.taskService.deleteTask(taskId);
        if (deletedTask == null) {
            return new ResponseDTO<Task>("error", "Invalid taskId");
        }
        return new ResponseDTO<>("Delete task successfully!!!", deletedTask);
    }

    @GetMapping("/getAllTask")
    public ResponseDTO<List<TaskDTO>> getAllTask() {
        return new ResponseDTO<>("Task fetched successfully!!!", taskService.getAllTask());
    }

    @GetMapping("/getUserTask")
    public ResponseDTO<List<TaskDTO>> getUserTask() {
        return new ResponseDTO<>("Task fetched successfully!!!", taskService.getUserTask());
    }

    @GetMapping("/{taskId}")
    public ResponseDTO<TaskDTO> getTaskById(@PathVariable("taskId") Long taskId) {
        return new ResponseDTO<>("Task fetched successfully!!!", taskService.taskById(taskId));
    }
}
