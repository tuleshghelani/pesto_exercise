package com.tulesh.springboot.service.impl;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.tulesh.springboot.enun.TaskStatus;
import com.tulesh.springboot.model.Task;
import com.tulesh.springboot.model.User;
import com.tulesh.springboot.repository.TaskRepository;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TaskNotificationServiceimpl.class})
@ExtendWith(SpringExtension.class)
class TaskNotificationServiceimplTest {
    @MockBean
    private JavaMailSender javaMailSender;

    @Autowired
    private TaskNotificationServiceimpl taskNotificationServiceimpl;

    @MockBean
    private TaskRepository taskRepository;

    @Test
    void testSendTaskNotifications() {
        // Arrange
        when(taskRepository.findByDueDateBetween(Mockito.<LocalDate>any(), Mockito.<LocalDate>any()))
                .thenReturn(new ArrayList<>());

        // Act
        taskNotificationServiceimpl.sendTaskNotifications();

        // Assert that nothing has changed
        verify(taskRepository).findByDueDateBetween(Mockito.<LocalDate>any(), Mockito.<LocalDate>any());
    }

    /**
     * Method under test:
     * {@link TaskNotificationServiceimpl#sendTaskNotifications()}
     */
    @Test
    void testSendTaskNotifications2() throws MailException {
        // Arrange
        doNothing().when(javaMailSender).send(Mockito.<SimpleMailMessage>any());

        User createdBy = new User();
        createdBy.setEmail("templName.tempfName@example.org");
        createdBy.setEnabled(true);
        createdBy.setFirstName("templName");
        createdBy.setId(1L);
        createdBy.setLastName("tempfName");
        createdBy.setPassword("password");
        createdBy.setPhone("6625550144");
        createdBy.setProfile("sendTaskNotifications");
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

        ArrayList<Task> taskList = new ArrayList<>();
        taskList.add(task);
        when(taskRepository.findByDueDateBetween(Mockito.<LocalDate>any(), Mockito.<LocalDate>any())).thenReturn(taskList);

        // Act
        taskNotificationServiceimpl.sendTaskNotifications();

        // Assert
        verify(taskRepository).findByDueDateBetween(Mockito.<LocalDate>any(), Mockito.<LocalDate>any());
        verify(javaMailSender).send(Mockito.<SimpleMailMessage>any());
    }

    @Test
    void testSendEmailNotification() throws MailException {
        // Arrange
        doNothing().when(javaMailSender).send(Mockito.<SimpleMailMessage>any());

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
        taskNotificationServiceimpl.sendEmailNotification(task, "Hello from the Dreaming Spires",
                "Not all who wander are lost");

        // Assert
        verify(javaMailSender).send(Mockito.<SimpleMailMessage>any());
    }
}
