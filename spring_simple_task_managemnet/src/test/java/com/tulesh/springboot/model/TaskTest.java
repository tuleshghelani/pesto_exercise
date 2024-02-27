package com.tulesh.springboot.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import com.tulesh.springboot.enun.TaskStatus;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TaskTest {
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new Task()).canEqual("Other"));
  }

  @Test
  void testCanEqual2() {
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

    User createdBy2 = new User();
    createdBy2.setEmail("templName.tempfName@example.org");
    createdBy2.setEnabled(true);
    createdBy2.setFirstName("templName");
    createdBy2.setId(1L);
    createdBy2.setLastName("tempfName");
    createdBy2.setPassword("password");
    createdBy2.setPhone("6625550144");
    createdBy2.setProfile("Profile");
    createdBy2.setUsername("templNametempfName");

    Task task2 = new Task();
    task2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    task2.setCreatedBy(createdBy2);
    task2.setDescription("The characteristics of someone or something");
    task2.setDueDate(LocalDate.of(1970, 1, 1));
    task2.setId(1L);
    task2.setStatus(TaskStatus.ToDo);
    task2.setTitle("Dr");
    task2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    assertTrue(task.canEqual(task2));
  }

  @Test
  void testCanEqual3() {
        Task task = new Task();

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

    Task task2 = new Task();
    task2.setCreatedAt(mock(java.sql.Date.class));
    task2.setCreatedBy(createdBy);
    task2.setDescription("The characteristics of someone or something");
    task2.setDueDate(LocalDate.of(1970, 1, 1));
    task2.setId(1L);
    task2.setStatus(TaskStatus.ToDo);
    task2.setTitle("Dr");
    task2.setUpdatedAt(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    assertTrue(task.canEqual(task2));
  }

  @Test
  void testEquals() {
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

    assertNotEquals(task, null);
  }

  @Test
  void testEquals2() {
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

    assertNotEquals(task, "Different type to Task");
  }

  @Test
  void testEquals3() {
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
    task.setCreatedAt(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    task.setCreatedBy(createdBy);
    task.setDescription("The characteristics of someone or something");
    task.setDueDate(LocalDate.of(1970, 1, 1));
    task.setId(1L);
    task.setStatus(TaskStatus.ToDo);
    task.setTitle("Dr");
    task.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    User createdBy2 = new User();
    createdBy2.setEmail("templName.tempfName@example.org");
    createdBy2.setEnabled(true);
    createdBy2.setFirstName("templName");
    createdBy2.setId(1L);
    createdBy2.setLastName("tempfName");
    createdBy2.setPassword("password");
    createdBy2.setPhone("6625550144");
    createdBy2.setProfile("Profile");
    createdBy2.setUsername("templNametempfName");

    Task task2 = new Task();
    task2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    task2.setCreatedBy(createdBy2);
    task2.setDescription("The characteristics of someone or something");
    task2.setDueDate(LocalDate.of(1970, 1, 1));
    task2.setId(1L);
    task2.setStatus(TaskStatus.ToDo);
    task2.setTitle("Dr");
    task2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    assertNotEquals(task, task2);
  }

  @Test
  void testEquals4() {
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
    task.setCreatedAt(null);
    task.setCreatedBy(createdBy);
    task.setDescription("The characteristics of someone or something");
    task.setDueDate(LocalDate.of(1970, 1, 1));
    task.setId(1L);
    task.setStatus(TaskStatus.ToDo);
    task.setTitle("Dr");
    task.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    User createdBy2 = new User();
    createdBy2.setEmail("templName.tempfName@example.org");
    createdBy2.setEnabled(true);
    createdBy2.setFirstName("templName");
    createdBy2.setId(1L);
    createdBy2.setLastName("tempfName");
    createdBy2.setPassword("password");
    createdBy2.setPhone("6625550144");
    createdBy2.setProfile("Profile");
    createdBy2.setUsername("templNametempfName");

    Task task2 = new Task();
    task2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    task2.setCreatedBy(createdBy2);
    task2.setDescription("The characteristics of someone or something");
    task2.setDueDate(LocalDate.of(1970, 1, 1));
    task2.setId(1L);
    task2.setStatus(TaskStatus.ToDo);
    task2.setTitle("Dr");
    task2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    assertNotEquals(task, task2);
  }

  /**
   * Method under test: {@link Task#equals(Object)}
   */
  @Test
  void testEquals5() {
        User createdBy = mock(User.class);
    doNothing().when(createdBy).setEmail(Mockito.<String>any());
    doNothing().when(createdBy).setEnabled(anyBoolean());
    doNothing().when(createdBy).setFirstName(Mockito.<String>any());
    doNothing().when(createdBy).setId(Mockito.<Long>any());
    doNothing().when(createdBy).setLastName(Mockito.<String>any());
    doNothing().when(createdBy).setPassword(Mockito.<String>any());
    doNothing().when(createdBy).setPhone(Mockito.<String>any());
    doNothing().when(createdBy).setProfile(Mockito.<String>any());
    doNothing().when(createdBy).setUsername(Mockito.<String>any());
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

    User createdBy2 = new User();
    createdBy2.setEmail("templName.tempfName@example.org");
    createdBy2.setEnabled(true);
    createdBy2.setFirstName("templName");
    createdBy2.setId(1L);
    createdBy2.setLastName("tempfName");
    createdBy2.setPassword("password");
    createdBy2.setPhone("6625550144");
    createdBy2.setProfile("Profile");
    createdBy2.setUsername("templNametempfName");

    Task task2 = new Task();
    task2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    task2.setCreatedBy(createdBy2);
    task2.setDescription("The characteristics of someone or something");
    task2.setDueDate(LocalDate.of(1970, 1, 1));
    task2.setId(1L);
    task2.setStatus(TaskStatus.ToDo);
    task2.setTitle("Dr");
    task2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    assertNotEquals(task, task2);
  }

  /**
   * Method under test: {@link Task#equals(Object)}
   */
  @Test
  void testEquals6() {
        User createdBy = mock(User.class);
    doNothing().when(createdBy).setEmail(Mockito.<String>any());
    doNothing().when(createdBy).setEnabled(anyBoolean());
    doNothing().when(createdBy).setFirstName(Mockito.<String>any());
    doNothing().when(createdBy).setId(Mockito.<Long>any());
    doNothing().when(createdBy).setLastName(Mockito.<String>any());
    doNothing().when(createdBy).setPassword(Mockito.<String>any());
    doNothing().when(createdBy).setPhone(Mockito.<String>any());
    doNothing().when(createdBy).setProfile(Mockito.<String>any());
    doNothing().when(createdBy).setUsername(Mockito.<String>any());
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
    task.setDescription("Dr");
    task.setDueDate(LocalDate.of(1970, 1, 1));
    task.setId(1L);
    task.setStatus(TaskStatus.ToDo);
    task.setTitle("Dr");
    task.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    User createdBy2 = new User();
    createdBy2.setEmail("templName.tempfName@example.org");
    createdBy2.setEnabled(true);
    createdBy2.setFirstName("templName");
    createdBy2.setId(1L);
    createdBy2.setLastName("tempfName");
    createdBy2.setPassword("password");
    createdBy2.setPhone("6625550144");
    createdBy2.setProfile("Profile");
    createdBy2.setUsername("templNametempfName");

    Task task2 = new Task();
    task2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    task2.setCreatedBy(createdBy2);
    task2.setDescription("The characteristics of someone or something");
    task2.setDueDate(LocalDate.of(1970, 1, 1));
    task2.setId(1L);
    task2.setStatus(TaskStatus.ToDo);
    task2.setTitle("Dr");
    task2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    assertNotEquals(task, task2);
  }

  /**
   * Method under test: {@link Task#equals(Object)}
   */
  @Test
  void testEquals7() {
        User createdBy = mock(User.class);
    doNothing().when(createdBy).setEmail(Mockito.<String>any());
    doNothing().when(createdBy).setEnabled(anyBoolean());
    doNothing().when(createdBy).setFirstName(Mockito.<String>any());
    doNothing().when(createdBy).setId(Mockito.<Long>any());
    doNothing().when(createdBy).setLastName(Mockito.<String>any());
    doNothing().when(createdBy).setPassword(Mockito.<String>any());
    doNothing().when(createdBy).setPhone(Mockito.<String>any());
    doNothing().when(createdBy).setProfile(Mockito.<String>any());
    doNothing().when(createdBy).setUsername(Mockito.<String>any());
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
    task.setDescription(null);
    task.setDueDate(LocalDate.of(1970, 1, 1));
    task.setId(1L);
    task.setStatus(TaskStatus.ToDo);
    task.setTitle("Dr");
    task.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    User createdBy2 = new User();
    createdBy2.setEmail("templName.tempfName@example.org");
    createdBy2.setEnabled(true);
    createdBy2.setFirstName("templName");
    createdBy2.setId(1L);
    createdBy2.setLastName("tempfName");
    createdBy2.setPassword("password");
    createdBy2.setPhone("6625550144");
    createdBy2.setProfile("Profile");
    createdBy2.setUsername("templNametempfName");

    Task task2 = new Task();
    task2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    task2.setCreatedBy(createdBy2);
    task2.setDescription("The characteristics of someone or something");
    task2.setDueDate(LocalDate.of(1970, 1, 1));
    task2.setId(1L);
    task2.setStatus(TaskStatus.ToDo);
    task2.setTitle("Dr");
    task2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    assertNotEquals(task, task2);
  }

  /**
   * Method under test: {@link Task#equals(Object)}
   */
  @Test
  void testEquals8() {
        User createdBy = mock(User.class);
    doNothing().when(createdBy).setEmail(Mockito.<String>any());
    doNothing().when(createdBy).setEnabled(anyBoolean());
    doNothing().when(createdBy).setFirstName(Mockito.<String>any());
    doNothing().when(createdBy).setId(Mockito.<Long>any());
    doNothing().when(createdBy).setLastName(Mockito.<String>any());
    doNothing().when(createdBy).setPassword(Mockito.<String>any());
    doNothing().when(createdBy).setPhone(Mockito.<String>any());
    doNothing().when(createdBy).setProfile(Mockito.<String>any());
    doNothing().when(createdBy).setUsername(Mockito.<String>any());
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
    task.setDueDate(LocalDate.now());
    task.setId(1L);
    task.setStatus(TaskStatus.ToDo);
    task.setTitle("Dr");
    task.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    User createdBy2 = new User();
    createdBy2.setEmail("templName.tempfName@example.org");
    createdBy2.setEnabled(true);
    createdBy2.setFirstName("templName");
    createdBy2.setId(1L);
    createdBy2.setLastName("tempfName");
    createdBy2.setPassword("password");
    createdBy2.setPhone("6625550144");
    createdBy2.setProfile("Profile");
    createdBy2.setUsername("templNametempfName");

    Task task2 = new Task();
    task2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    task2.setCreatedBy(createdBy2);
    task2.setDescription("The characteristics of someone or something");
    task2.setDueDate(LocalDate.of(1970, 1, 1));
    task2.setId(1L);
    task2.setStatus(TaskStatus.ToDo);
    task2.setTitle("Dr");
    task2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    assertNotEquals(task, task2);
  }

  @Test
  void testEquals9() {
        User createdBy = mock(User.class);
    doNothing().when(createdBy).setEmail(Mockito.<String>any());
    doNothing().when(createdBy).setEnabled(anyBoolean());
    doNothing().when(createdBy).setFirstName(Mockito.<String>any());
    doNothing().when(createdBy).setId(Mockito.<Long>any());
    doNothing().when(createdBy).setLastName(Mockito.<String>any());
    doNothing().when(createdBy).setPassword(Mockito.<String>any());
    doNothing().when(createdBy).setPhone(Mockito.<String>any());
    doNothing().when(createdBy).setProfile(Mockito.<String>any());
    doNothing().when(createdBy).setUsername(Mockito.<String>any());
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
    task.setDueDate(null);
    task.setId(1L);
    task.setStatus(TaskStatus.ToDo);
    task.setTitle("Dr");
    task.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    User createdBy2 = new User();
    createdBy2.setEmail("templName.tempfName@example.org");
    createdBy2.setEnabled(true);
    createdBy2.setFirstName("templName");
    createdBy2.setId(1L);
    createdBy2.setLastName("tempfName");
    createdBy2.setPassword("password");
    createdBy2.setPhone("6625550144");
    createdBy2.setProfile("Profile");
    createdBy2.setUsername("templNametempfName");

    Task task2 = new Task();
    task2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    task2.setCreatedBy(createdBy2);
    task2.setDescription("The characteristics of someone or something");
    task2.setDueDate(LocalDate.of(1970, 1, 1));
    task2.setId(1L);
    task2.setStatus(TaskStatus.ToDo);
    task2.setTitle("Dr");
    task2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    assertNotEquals(task, task2);
  }

  @Test
  void testEquals10() {
        User createdBy = mock(User.class);
    doNothing().when(createdBy).setEmail(Mockito.<String>any());
    doNothing().when(createdBy).setEnabled(anyBoolean());
    doNothing().when(createdBy).setFirstName(Mockito.<String>any());
    doNothing().when(createdBy).setId(Mockito.<Long>any());
    doNothing().when(createdBy).setLastName(Mockito.<String>any());
    doNothing().when(createdBy).setPassword(Mockito.<String>any());
    doNothing().when(createdBy).setPhone(Mockito.<String>any());
    doNothing().when(createdBy).setProfile(Mockito.<String>any());
    doNothing().when(createdBy).setUsername(Mockito.<String>any());
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
    task.setId(2L);
    task.setStatus(TaskStatus.ToDo);
    task.setTitle("Dr");
    task.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    User createdBy2 = new User();
    createdBy2.setEmail("templName.tempfName@example.org");
    createdBy2.setEnabled(true);
    createdBy2.setFirstName("templName");
    createdBy2.setId(1L);
    createdBy2.setLastName("tempfName");
    createdBy2.setPassword("password");
    createdBy2.setPhone("6625550144");
    createdBy2.setProfile("Profile");
    createdBy2.setUsername("templNametempfName");

    Task task2 = new Task();
    task2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    task2.setCreatedBy(createdBy2);
    task2.setDescription("The characteristics of someone or something");
    task2.setDueDate(LocalDate.of(1970, 1, 1));
    task2.setId(1L);
    task2.setStatus(TaskStatus.ToDo);
    task2.setTitle("Dr");
    task2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    assertNotEquals(task, task2);
  }

  @Test
  void testEquals11() {
        User createdBy = mock(User.class);
    doNothing().when(createdBy).setEmail(Mockito.<String>any());
    doNothing().when(createdBy).setEnabled(anyBoolean());
    doNothing().when(createdBy).setFirstName(Mockito.<String>any());
    doNothing().when(createdBy).setId(Mockito.<Long>any());
    doNothing().when(createdBy).setLastName(Mockito.<String>any());
    doNothing().when(createdBy).setPassword(Mockito.<String>any());
    doNothing().when(createdBy).setPhone(Mockito.<String>any());
    doNothing().when(createdBy).setProfile(Mockito.<String>any());
    doNothing().when(createdBy).setUsername(Mockito.<String>any());
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
    task.setId(null);
    task.setStatus(TaskStatus.ToDo);
    task.setTitle("Dr");
    task.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    User createdBy2 = new User();
    createdBy2.setEmail("templName.tempfName@example.org");
    createdBy2.setEnabled(true);
    createdBy2.setFirstName("templName");
    createdBy2.setId(1L);
    createdBy2.setLastName("tempfName");
    createdBy2.setPassword("password");
    createdBy2.setPhone("6625550144");
    createdBy2.setProfile("Profile");
    createdBy2.setUsername("templNametempfName");

    Task task2 = new Task();
    task2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    task2.setCreatedBy(createdBy2);
    task2.setDescription("The characteristics of someone or something");
    task2.setDueDate(LocalDate.of(1970, 1, 1));
    task2.setId(1L);
    task2.setStatus(TaskStatus.ToDo);
    task2.setTitle("Dr");
    task2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    assertNotEquals(task, task2);
  }

  @Test
  void testEquals12() {
        User createdBy = mock(User.class);
    doNothing().when(createdBy).setEmail(Mockito.<String>any());
    doNothing().when(createdBy).setEnabled(anyBoolean());
    doNothing().when(createdBy).setFirstName(Mockito.<String>any());
    doNothing().when(createdBy).setId(Mockito.<Long>any());
    doNothing().when(createdBy).setLastName(Mockito.<String>any());
    doNothing().when(createdBy).setPassword(Mockito.<String>any());
    doNothing().when(createdBy).setPhone(Mockito.<String>any());
    doNothing().when(createdBy).setProfile(Mockito.<String>any());
    doNothing().when(createdBy).setUsername(Mockito.<String>any());
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
    task.setStatus(null);
    task.setTitle("Dr");
    task.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    User createdBy2 = new User();
    createdBy2.setEmail("templName.tempfName@example.org");
    createdBy2.setEnabled(true);
    createdBy2.setFirstName("templName");
    createdBy2.setId(1L);
    createdBy2.setLastName("tempfName");
    createdBy2.setPassword("password");
    createdBy2.setPhone("6625550144");
    createdBy2.setProfile("Profile");
    createdBy2.setUsername("templNametempfName");

    Task task2 = new Task();
    task2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    task2.setCreatedBy(createdBy2);
    task2.setDescription("The characteristics of someone or something");
    task2.setDueDate(LocalDate.of(1970, 1, 1));
    task2.setId(1L);
    task2.setStatus(TaskStatus.ToDo);
    task2.setTitle("Dr");
    task2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    assertNotEquals(task, task2);
  }

  @Test
  void testEquals13() {
        User createdBy = mock(User.class);
    doNothing().when(createdBy).setEmail(Mockito.<String>any());
    doNothing().when(createdBy).setEnabled(anyBoolean());
    doNothing().when(createdBy).setFirstName(Mockito.<String>any());
    doNothing().when(createdBy).setId(Mockito.<Long>any());
    doNothing().when(createdBy).setLastName(Mockito.<String>any());
    doNothing().when(createdBy).setPassword(Mockito.<String>any());
    doNothing().when(createdBy).setPhone(Mockito.<String>any());
    doNothing().when(createdBy).setProfile(Mockito.<String>any());
    doNothing().when(createdBy).setUsername(Mockito.<String>any());
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
    task.setStatus(TaskStatus.InProgress);
    task.setTitle("Dr");
    task.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    User createdBy2 = new User();
    createdBy2.setEmail("templName.tempfName@example.org");
    createdBy2.setEnabled(true);
    createdBy2.setFirstName("templName");
    createdBy2.setId(1L);
    createdBy2.setLastName("tempfName");
    createdBy2.setPassword("password");
    createdBy2.setPhone("6625550144");
    createdBy2.setProfile("Profile");
    createdBy2.setUsername("templNametempfName");

    Task task2 = new Task();
    task2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    task2.setCreatedBy(createdBy2);
    task2.setDescription("The characteristics of someone or something");
    task2.setDueDate(LocalDate.of(1970, 1, 1));
    task2.setId(1L);
    task2.setStatus(TaskStatus.ToDo);
    task2.setTitle("Dr");
    task2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    assertNotEquals(task, task2);
  }

  @Test
  void testEquals14() {
        User createdBy = mock(User.class);
    doNothing().when(createdBy).setEmail(Mockito.<String>any());
    doNothing().when(createdBy).setEnabled(anyBoolean());
    doNothing().when(createdBy).setFirstName(Mockito.<String>any());
    doNothing().when(createdBy).setId(Mockito.<Long>any());
    doNothing().when(createdBy).setLastName(Mockito.<String>any());
    doNothing().when(createdBy).setPassword(Mockito.<String>any());
    doNothing().when(createdBy).setPhone(Mockito.<String>any());
    doNothing().when(createdBy).setProfile(Mockito.<String>any());
    doNothing().when(createdBy).setUsername(Mockito.<String>any());
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
    task.setTitle("Mr");
    task.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    User createdBy2 = new User();
    createdBy2.setEmail("templName.tempfName@example.org");
    createdBy2.setEnabled(true);
    createdBy2.setFirstName("templName");
    createdBy2.setId(1L);
    createdBy2.setLastName("tempfName");
    createdBy2.setPassword("password");
    createdBy2.setPhone("6625550144");
    createdBy2.setProfile("Profile");
    createdBy2.setUsername("templNametempfName");

    Task task2 = new Task();
    task2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    task2.setCreatedBy(createdBy2);
    task2.setDescription("The characteristics of someone or something");
    task2.setDueDate(LocalDate.of(1970, 1, 1));
    task2.setId(1L);
    task2.setStatus(TaskStatus.ToDo);
    task2.setTitle("Dr");
    task2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    assertNotEquals(task, task2);
  }

  @Test
  void testEquals15() {
        User createdBy = mock(User.class);
    doNothing().when(createdBy).setEmail(Mockito.<String>any());
    doNothing().when(createdBy).setEnabled(anyBoolean());
    doNothing().when(createdBy).setFirstName(Mockito.<String>any());
    doNothing().when(createdBy).setId(Mockito.<Long>any());
    doNothing().when(createdBy).setLastName(Mockito.<String>any());
    doNothing().when(createdBy).setPassword(Mockito.<String>any());
    doNothing().when(createdBy).setPhone(Mockito.<String>any());
    doNothing().when(createdBy).setProfile(Mockito.<String>any());
    doNothing().when(createdBy).setUsername(Mockito.<String>any());
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
    task.setTitle(null);
    task.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    User createdBy2 = new User();
    createdBy2.setEmail("templName.tempfName@example.org");
    createdBy2.setEnabled(true);
    createdBy2.setFirstName("templName");
    createdBy2.setId(1L);
    createdBy2.setLastName("tempfName");
    createdBy2.setPassword("password");
    createdBy2.setPhone("6625550144");
    createdBy2.setProfile("Profile");
    createdBy2.setUsername("templNametempfName");

    Task task2 = new Task();
    task2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    task2.setCreatedBy(createdBy2);
    task2.setDescription("The characteristics of someone or something");
    task2.setDueDate(LocalDate.of(1970, 1, 1));
    task2.setId(1L);
    task2.setStatus(TaskStatus.ToDo);
    task2.setTitle("Dr");
    task2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    assertNotEquals(task, task2);
  }

  @Test
  void testEquals16() {
        User createdBy = mock(User.class);
    doNothing().when(createdBy).setEmail(Mockito.<String>any());
    doNothing().when(createdBy).setEnabled(anyBoolean());
    doNothing().when(createdBy).setFirstName(Mockito.<String>any());
    doNothing().when(createdBy).setId(Mockito.<Long>any());
    doNothing().when(createdBy).setLastName(Mockito.<String>any());
    doNothing().when(createdBy).setPassword(Mockito.<String>any());
    doNothing().when(createdBy).setPhone(Mockito.<String>any());
    doNothing().when(createdBy).setProfile(Mockito.<String>any());
    doNothing().when(createdBy).setUsername(Mockito.<String>any());
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
    task.setUpdatedAt(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    User createdBy2 = new User();
    createdBy2.setEmail("templName.tempfName@example.org");
    createdBy2.setEnabled(true);
    createdBy2.setFirstName("templName");
    createdBy2.setId(1L);
    createdBy2.setLastName("tempfName");
    createdBy2.setPassword("password");
    createdBy2.setPhone("6625550144");
    createdBy2.setProfile("Profile");
    createdBy2.setUsername("templNametempfName");

    Task task2 = new Task();
    task2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    task2.setCreatedBy(createdBy2);
    task2.setDescription("The characteristics of someone or something");
    task2.setDueDate(LocalDate.of(1970, 1, 1));
    task2.setId(1L);
    task2.setStatus(TaskStatus.ToDo);
    task2.setTitle("Dr");
    task2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    assertNotEquals(task, task2);
  }

  @Test
  void testEquals17() {
        User createdBy = mock(User.class);
    doNothing().when(createdBy).setEmail(Mockito.<String>any());
    doNothing().when(createdBy).setEnabled(anyBoolean());
    doNothing().when(createdBy).setFirstName(Mockito.<String>any());
    doNothing().when(createdBy).setId(Mockito.<Long>any());
    doNothing().when(createdBy).setLastName(Mockito.<String>any());
    doNothing().when(createdBy).setPassword(Mockito.<String>any());
    doNothing().when(createdBy).setPhone(Mockito.<String>any());
    doNothing().when(createdBy).setProfile(Mockito.<String>any());
    doNothing().when(createdBy).setUsername(Mockito.<String>any());
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
    task.setUpdatedAt(null);

    User createdBy2 = new User();
    createdBy2.setEmail("templName.tempfName@example.org");
    createdBy2.setEnabled(true);
    createdBy2.setFirstName("templName");
    createdBy2.setId(1L);
    createdBy2.setLastName("tempfName");
    createdBy2.setPassword("password");
    createdBy2.setPhone("6625550144");
    createdBy2.setProfile("Profile");
    createdBy2.setUsername("templNametempfName");

    Task task2 = new Task();
    task2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    task2.setCreatedBy(createdBy2);
    task2.setDescription("The characteristics of someone or something");
    task2.setDueDate(LocalDate.of(1970, 1, 1));
    task2.setId(1L);
    task2.setStatus(TaskStatus.ToDo);
    task2.setTitle("Dr");
    task2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    assertNotEquals(task, task2);
  }

  @Test
  void testEqualsAndHashCode() {
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

    assertEquals(task, task);
    int expectedHashCodeResult = task.hashCode();
    assertEquals(expectedHashCodeResult, task.hashCode());
  }

  @Test
  void testEqualsAndHashCode2() {
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

    User createdBy2 = new User();
    createdBy2.setEmail("templName.tempfName@example.org");
    createdBy2.setEnabled(true);
    createdBy2.setFirstName("templName");
    createdBy2.setId(1L);
    createdBy2.setLastName("tempfName");
    createdBy2.setPassword("password");
    createdBy2.setPhone("6625550144");
    createdBy2.setProfile("Profile");
    createdBy2.setUsername("templNametempfName");

    Task task2 = new Task();
    task2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    task2.setCreatedBy(createdBy2);
    task2.setDescription("The characteristics of someone or something");
    task2.setDueDate(LocalDate.of(1970, 1, 1));
    task2.setId(1L);
    task2.setStatus(TaskStatus.ToDo);
    task2.setTitle("Dr");
    task2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    assertEquals(task, task2);
    int expectedHashCodeResult = task.hashCode();
    assertEquals(expectedHashCodeResult, task2.hashCode());
  }

  @Test
  void testGettersAndSetters() {
        Task task = new Task();
    Date createdAt = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    task.setCreatedAt(createdAt);
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
    LocalDate dueDate = LocalDate.of(1970, 1, 1);
    task.setDueDate(dueDate);
    task.setId(1L);
    task.setStatus(TaskStatus.ToDo);
    task.setTitle("Dr");
    Date updatedAt = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    task.setUpdatedAt(updatedAt);
    task.toString();
    Date actualCreatedAt = task.getCreatedAt();
    User actualCreatedBy = task.getCreatedBy();
    String actualDescription = task.getDescription();
    LocalDate actualDueDate = task.getDueDate();
    Long actualId = task.getId();
    TaskStatus actualStatus = task.getStatus();
    String actualTitle = task.getTitle();
    Date actualUpdatedAt = task.getUpdatedAt();

    // Assert that nothing has changed
    assertEquals("Dr", actualTitle);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(1L, actualId.longValue());
    assertEquals(TaskStatus.ToDo, actualStatus);
    assertSame(createdBy, actualCreatedBy);
    assertSame(dueDate, actualDueDate);
    assertSame(createdAt, actualCreatedAt);
    assertSame(updatedAt, actualUpdatedAt);
  }

  @Test
  void testNewTask() {
    // Arrange, Act and Assert
    assertEquals(TaskStatus.ToDo, (new Task()).getStatus());
  }
}
