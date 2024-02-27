package com.tulesh.springboot.enun;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class TaskStatusTest {
    @Test
    void testGetAllAnsTypeValue() {
        List<String> actualAllAnsTypeValue = TaskStatus.getAllAnsTypeValue();

        assertEquals(3, actualAllAnsTypeValue.size());
        assertNull(actualAllAnsTypeValue.get(0));
        assertNull(actualAllAnsTypeValue.get(1));
        assertNull(actualAllAnsTypeValue.get(2));
    }

    @Test
    void testGetDisplayValueFromString() {
        // Arrange, Act and Assert
        assertNull(TaskStatus.getDisplayValueFromString("Status"));
        assertEquals("Done", TaskStatus.getDisplayValueFromString("Done"));
    }

    @Test
    @Disabled("TODO: Test case")
    void testGetEnumByString() {
        TaskStatus.getEnumByString("Code");
    }

    @Test
    void testGetTaskEnum() {
        assertNull(TaskStatus.getTaskEnum("42"));
        assertEquals(TaskStatus.ToDo, TaskStatus.getTaskEnum("To Do"));
        assertEquals(TaskStatus.InProgress, TaskStatus.getTaskEnum("In Progress"));
        assertEquals(TaskStatus.Done, TaskStatus.getTaskEnum("Done"));
    }
}
