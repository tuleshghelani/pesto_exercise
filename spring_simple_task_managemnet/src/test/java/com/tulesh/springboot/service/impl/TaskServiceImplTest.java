package com.tulesh.springboot.service.impl;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.tulesh.springboot.DAO.TaskDAO;
import com.tulesh.springboot.DTO.TaskDTO;
import com.tulesh.springboot.enun.TaskStatus;
import com.tulesh.springboot.exception.CustomException;
import com.tulesh.springboot.model.Task;
import com.tulesh.springboot.model.User;
import com.tulesh.springboot.repository.TaskRepository;
import com.tulesh.springboot.repository.UserRepository;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TaskServiceImpl.class})
@ExtendWith(SpringExtension.class)
class TaskServiceImplTest {
    @MockBean
    private TaskDAO taskDAO;

    @MockBean
    private TaskRepository taskRepository;

    @Autowired
    private TaskServiceImpl taskServiceImpl;

    @MockBean
    private UserRepository userRepository;

    @Test
    void testCreateOrUpdateTask() throws CustomException {
        // Arrange, Act and Assert
        assertThrows(CustomException.class, () -> taskServiceImpl.createOrUpdateTask(new TaskDTO(), true));
        assertThrows(CustomException.class, () -> taskServiceImpl.createOrUpdateTask(new TaskDTO(1L, "Dr"), true));
    }

    @Test
    void testCreateOrUpdateTask2() throws CustomException {
        // Arrange
        TaskDTO taskDTO = mock(TaskDTO.class);
        when(taskDTO.getDescription()).thenReturn("The characteristics of someone or something");
        when(taskDTO.getTitle()).thenReturn("Dr");
        when(taskDTO.getDueDate()).thenReturn(LocalDate.of(1970, 1, 1));
        when(taskDTO.getStatus()).thenReturn("To Do");

        // Act and Assert
        assertThrows(CustomException.class, () -> taskServiceImpl.createOrUpdateTask(taskDTO, true));
        verify(taskDTO).getDescription();
        verify(taskDTO).getDueDate();
        verify(taskDTO, atLeast(1)).getStatus();
        verify(taskDTO).getTitle();
    }


    @Test
    void testCreateOrUpdateTask3() throws CustomException {
        // Arrange
        User createdBy = new User();
        createdBy.setEmail("templName.tempfName@example.org");
        createdBy.setEnabled(true);
        createdBy.setFirstName("templName");
        createdBy.setId(1L);
        createdBy.setLastName("tempfName");
        createdBy.setPassword("password");
        createdBy.setPhone("123456");
        createdBy.setProfile("Profile");
        createdBy.setUsername("templNametempfName");

        Task task = new Task();
        task.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        task.setCreatedBy(createdBy);
        task.setDescription("The characteristics of someone or something");
        task.setDueDate(LocalDate.of(1970, 1, 1));
        task.setId(1L);
        task.setStatus(TaskStatus.ToDo);
        task.setTitle("Dr");
        task.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        Optional<Task> ofResult = Optional.of(task);
        when(taskRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        TaskDTO taskDTO = mock(TaskDTO.class);
        when(taskDTO.getId()).thenReturn(1L);
        when(taskDTO.getStatus()).thenReturn("To Do");

        // Act and Assert
        assertThrows(CustomException.class, () -> taskServiceImpl.createOrUpdateTask(taskDTO, false));
        verify(taskDTO, atLeast(1)).getId();
        verify(taskDTO).getStatus();
        verify(taskRepository).findById(Mockito.<Long>any());
    }

    @Test
    void testCreateOrUpdateTask4() throws CustomException {
        // Arrange
        when(taskRepository.findById(Mockito.<Long>any())).thenReturn(null);
        TaskDTO taskDTO = mock(TaskDTO.class);
        when(taskDTO.getId()).thenReturn(1L);
        when(taskDTO.getStatus()).thenReturn("To Do");

        // Act and Assert
        assertThrows(CustomException.class, () -> taskServiceImpl.createOrUpdateTask(taskDTO, false));
        verify(taskDTO, atLeast(1)).getId();
        verify(taskDTO).getStatus();
        verify(taskRepository).findById(Mockito.<Long>any());
    }

    @Test
    void testCreateOrUpdateTask5() throws CustomException {
        // Arrange
        TaskDTO taskDTO = mock(TaskDTO.class);
        when(taskDTO.getId()).thenReturn(null);
        when(taskDTO.getStatus()).thenReturn("To Do");

        // Act and Assert
        assertThrows(CustomException.class, () -> taskServiceImpl.createOrUpdateTask(taskDTO, false));
        verify(taskDTO).getId();
        verify(taskDTO).getStatus();
    }

    @Test
    void testDeleteTask() throws CustomException {
        // Arrange
        Optional<Task> emptyResult = Optional.empty();
        when(taskRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);

        // Act
        Task actualDeleteTaskResult = taskServiceImpl.deleteTask(1L);

        // Assert
        verify(taskRepository).findById(Mockito.<Long>any());
        assertNull(actualDeleteTaskResult);
    }

    @Test
    void testGetAllTask() {
        // Arrange
        ArrayList<TaskDTO> taskDTOList = new ArrayList<>();
        when(taskDAO.getAllTask()).thenReturn(taskDTOList);

        // Act
        List<TaskDTO> actualAllTask = taskServiceImpl.getAllTask();

        // Assert
        verify(taskDAO).getAllTask();
        assertTrue(actualAllTask.isEmpty());
        assertSame(taskDTOList, actualAllTask);
    }

    @Test
    @Disabled("TODO: Test case")
    void testGetUserTask() {
        // Arrange and Act
        taskServiceImpl.getUserTask();
    }

    @Test
    void testTaskById() {
        // Arrange
        TaskDTO taskDTO = new TaskDTO();
        when(taskDAO.findById(Mockito.<Long>any())).thenReturn(taskDTO);

        // Act
        TaskDTO actualTaskByIdResult = taskServiceImpl.taskById(1L);

        // Assert
        verify(taskDAO).findById(Mockito.<Long>any());
        assertSame(taskDTO, actualTaskByIdResult);
    }

    @Test
    @Disabled("TODO: Test case")
    void testIsAuthorizeToDeleteOrUpdateTask() throws CustomException {

        // Arrange
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

        Task task = new Task();
        task.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        task.setCreatedBy(createdBy);
        task.setDescription("The characteristics of someone or something");
        task.setDueDate(LocalDate.of(1970, 1, 1));
        task.setId(1L);
        task.setStatus(TaskStatus.ToDo);
        task.setTitle("Dr");
        task.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

        // Act
        taskServiceImpl.isAuthorizeToDeleteOrUpdateTask(task);
    }
}
