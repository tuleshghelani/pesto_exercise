package com.tulesh.springboot.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tulesh.springboot.DTO.TaskDTO;
import com.tulesh.springboot.enun.TaskStatus;
import com.tulesh.springboot.model.Task;
import com.tulesh.springboot.model.User;
import com.tulesh.springboot.service.TaskService;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {TaskController.class})
@ExtendWith(SpringExtension.class)
class TaskControllerTest {
    @Autowired
    private TaskController taskController;

    @MockBean
    private TaskService taskService;

    @Test
    @Disabled("TODO: Test cases")
    void testCreateTask() throws Exception {
        // Arrange
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        taskDTO.setCreatedBy(1L);
        taskDTO.setDescription("The characteristics of someone or something");
        taskDTO.setDueDate(LocalDate.of(1970, 1, 1));
        taskDTO.setId(1L);
        taskDTO.setStatus("Status");
        taskDTO.setTitle("Dr");
        taskDTO.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        String content = (new ObjectMapper()).writeValueAsString(taskDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/task/createTask")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        MockMvcBuilders.standaloneSetup(taskController).build().perform(requestBuilder);
    }

    @Test
    @Disabled("TODO: Test cases")
    void testDeleteTask() throws Exception {

        // Arrange
        Task task = new Task();
        task.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        User createdBy = new User();
        createdBy.setEmail("templName.tempfName@example.org");
        createdBy.setEnabled(true);
        createdBy.setFirstName("templName");
        createdBy.setId(1L);
        createdBy.setLastName("tempfName");
        createdBy.setPassword("password");
        createdBy.setPhone("6625550144");
        createdBy.setProfile("Profile");
        createdBy.setUsername("templNametempfName");
        task.setCreatedBy(createdBy);
        task.setDescription("The characteristics of someone or something");
        task.setDueDate(LocalDate.of(1970, 1, 1));
        task.setId(1L);
        task.setStatus(TaskStatus.ToDo);
        task.setTitle("Dr");
        task.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        when(taskService.deleteTask(Mockito.<Long>any())).thenReturn(task);
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/task/deleteTask");
        MockHttpServletRequestBuilder requestBuilder = deleteResult.param("taskId", String.valueOf(1L));

        // Act and Assert
        MockMvcBuilders.standaloneSetup(taskController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"success\",\"message\":\"Delete task successfully!!!\",\"data\":{\"id\":1,\"title\":\"Dr\",\"description\":\"The"
                                        + " characteristics of someone or something\",\"status\":\"ToDo\",\"dueDate\":[1970,1,1],\"createdAt\":0,\"updatedAt"
                                        + "\":0,\"createdBy\":{\"id\":1,\"username\":\"templNametempfName\",\"password\":\"password\",\"firstName\":\"templName\",\"lastName\":\"tempfName"
                                        + "\",\"email\":\"templName.tempfName@example.org\",\"phone\":\"6625550144\",\"profile\":\"Profile\",\"enabled\":true,\"accountNonExpired"
                                        + "\":true,\"accountNonLocked\":true,\"credentialsNonExpired\":true,\"authorities\":[]}},\"currentPage\":0,"
                                        + "\"totalPages\":0,\"pageSize\":0,\"totalRecords\":0,\"lastUpdatedTime\":1708955322000}"));
    }

    @Test
    @Disabled("TODO: Test cases")
    void testGetAllTask() throws Exception {

        // Arrange
        when(taskService.getAllTask()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/task/getAllTask");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(taskController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"success\",\"message\":\"Task fetched successfully!!!\",\"data\":[],\"currentPage\":0,\"totalPages\":0"
                                        + ",\"pageSize\":0,\"totalRecords\":0,\"lastUpdatedTime\":1708955330724}"));
    }

    @Test
    @Disabled("TODO: Test cases")
    void testGetUserTask() throws Exception {

        // Arrange
        when(taskService.getUserTask()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/task/getUserTask");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(taskController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"success\",\"message\":\"Task fetched successfully!!!\",\"data\":[],\"currentPage\":0,\"totalPages\":0"
                                        + ",\"pageSize\":0,\"totalRecords\":0,\"lastUpdatedTime\":1708955344771}"));
    }

    @Test
    @Disabled("TODO: Test cases")
    void testCreateTask2() throws Exception {

        // Arrange
        Task task = new Task();
        task.setCreatedAt(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        User createdBy = new User();
        createdBy.setEmail("templName.tempfName@example.org");
        createdBy.setEnabled(true);
        createdBy.setFirstName("templName");
        createdBy.setId(1L);
        createdBy.setLastName("tempfName");
        createdBy.setPassword("password");
        createdBy.setPhone("6625550144");
        createdBy.setProfile("Profile");
        createdBy.setUsername("templNametempfName");
        task.setCreatedBy(createdBy);
        task.setDescription("The characteristics of someone or something");
        task.setDueDate(LocalDate.of(1970, 1, 1));
        task.setId(1L);
        task.setStatus(TaskStatus.ToDo);
        task.setTitle("Dr");
        task.setUpdatedAt(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        when(taskService.createOrUpdateTask(Mockito.<TaskDTO>any(), Mockito.<Boolean>any())).thenReturn(task);
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/api/task/createTask")
                .contentType(MediaType.APPLICATION_JSON);

        TaskDTO taskDTO = new TaskDTO();
        java.sql.Date createdAt = mock(java.sql.Date.class);
        when(createdAt.getTime()).thenReturn(10L);
        taskDTO.setCreatedAt(createdAt);
        taskDTO.setCreatedBy(1L);
        taskDTO.setDescription("The characteristics of someone or something");
        taskDTO.setDueDate(null);
        taskDTO.setId(1L);
        taskDTO.setStatus("Status");
        taskDTO.setTitle("Dr");
        taskDTO
                .setUpdatedAt(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content((new ObjectMapper()).writeValueAsString(taskDTO));

        // Act and Assert
        MockMvcBuilders.standaloneSetup(taskController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"success\",\"message\":\"Created task successfully!!!\",\"data\":{\"id\":1,\"title\":\"Dr\",\"description\":\"The"
                                        + " characteristics of someone or something\",\"status\":\"ToDo\",\"dueDate\":[1970,1,1],\"createdAt\":0,\"updatedAt"
                                        + "\":0,\"createdBy\":{\"id\":1,\"username\":\"templNametempfName\",\"password\":\"password\",\"firstName\":\"templName\",\"lastName\":\"tempfName"
                                        + "\",\"email\":\"templName.tempfName@example.org\",\"phone\":\"6625550144\",\"profile\":\"Profile\",\"enabled\":true,\"accountNonExpired"
                                        + "\":true,\"accountNonLocked\":true,\"credentialsNonExpired\":true,\"authorities\":[]}},\"currentPage\":0,"
                                        + "\"totalPages\":0,\"pageSize\":0,\"totalRecords\":0,\"lastUpdatedTime\":1708955304949}"));
    }

    @Test
    @Disabled("TODO: Test cases")
    void testGetTaskById() throws Exception {

        // Arrange
        when(taskService.taskById(Mockito.<Long>any())).thenReturn(new TaskDTO());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/task/{taskId}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(taskController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"success\",\"message\":\"Task fetched successfully!!!\",\"data\":{},\"currentPage\":0,\"totalPages\":0"
                                        + ",\"pageSize\":0,\"totalRecords\":0,\"lastUpdatedTime\":1708955338034}"));
    }

    @Test
    @Disabled("TODO: Test cases")
    void testUpdateTask() throws Exception {

        // Arrange
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        taskDTO.setCreatedBy(1L);
        taskDTO.setDescription("The characteristics of someone or something");
        taskDTO.setDueDate(LocalDate.of(1970, 1, 1));
        taskDTO.setId(1L);
        taskDTO.setStatus("Status");
        taskDTO.setTitle("Dr");
        taskDTO.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        String content = (new ObjectMapper()).writeValueAsString(taskDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/task/updateTask")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        MockMvcBuilders.standaloneSetup(taskController).build().perform(requestBuilder);
    }

    /**
     * Method under test: {@link TaskController#updateTask(TaskDTO)}
     */
    @Test
    @Disabled("TODO: Test cases")
    void testUpdateTask2() throws Exception {

        // Arrange
        Task task = new Task();
        task.setCreatedAt(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        User createdBy = new User();
        createdBy.setEmail("templName.tempfName@example.org");
        createdBy.setEnabled(true);
        createdBy.setFirstName("templName");
        createdBy.setId(1L);
        createdBy.setLastName("tempfName");
        createdBy.setPassword("password");
        createdBy.setPhone("6625550144");
        createdBy.setProfile("Profile");
        createdBy.setUsername("templNametempfName");
        task.setCreatedBy(createdBy);
        task.setDescription("The characteristics of someone or something");
        task.setDueDate(LocalDate.of(1970, 1, 1));
        task.setId(1L);
        task.setStatus(TaskStatus.ToDo);
        task.setTitle("Dr");
        task.setUpdatedAt(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        when(taskService.createOrUpdateTask(Mockito.<TaskDTO>any(), Mockito.<Boolean>any())).thenReturn(task);
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.put("/api/task/updateTask")
                .contentType(MediaType.APPLICATION_JSON);

        TaskDTO taskDTO = new TaskDTO();
        java.sql.Date createdAt = mock(java.sql.Date.class);
        when(createdAt.getTime()).thenReturn(10L);
        taskDTO.setCreatedAt(createdAt);
        taskDTO.setCreatedBy(1L);
        taskDTO.setDescription("The characteristics of someone or something");
        taskDTO.setDueDate(null);
        taskDTO.setId(1L);
        taskDTO.setStatus("Status");
        taskDTO.setTitle("Dr");
        taskDTO
                .setUpdatedAt(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content((new ObjectMapper()).writeValueAsString(taskDTO));

        // Act and Assert
        MockMvcBuilders.standaloneSetup(taskController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"success\",\"message\":\"Updated task successfully!!!\",\"data\":{\"id\":1,\"title\":\"Dr\",\"description\":\"The"
                                        + " characteristics of someone or something\",\"status\":\"ToDo\",\"dueDate\":[1970,1,1],\"createdAt\":0,\"updatedAt"
                                        + "\":0,\"createdBy\":{\"id\":1,\"username\":\"templNametempfName\",\"password\":\"password\",\"firstName\":\"templName\",\"lastName\":\"tempfName"
                                        + "\",\"email\":\"templName.tempfName@example.org\",\"phone\":\"6625550144\",\"profile\":\"Profile\",\"enabled\":true,\"accountNonExpired"
                                        + "\":true,\"accountNonLocked\":true,\"credentialsNonExpired\":true,\"authorities\":[]}},\"currentPage\":0,"
                                        + "\"totalPages\":0,\"pageSize\":0,\"totalRecords\":0,\"lastUpdatedTime\":1708955352985}"));
    }
}
