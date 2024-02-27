package com.tulesh.springboot.DAO;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class TaskDAOTest {
    @Test
    void testGetUserTask() {
        assertNull((new TaskDAO()).getUserTask(1L));
    }
    @Test
    void testGetAllTask() {
        assertNull((new TaskDAO()).getAllTask());
    }

    @Test
    void testFindById() {
        assertNull((new TaskDAO()).findById(1L));
    }
}
