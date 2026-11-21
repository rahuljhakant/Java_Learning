package com.tutorial.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TaskServiceTest {
    @Test
    void createsTrimmedTaskAndReturnsItInIdOrder() {
        TaskService service = new TaskService();

        TaskService.Task first = service.create("  Learn HTTP  ");
        TaskService.Task second = service.create("Learn JSON");

        assertEquals("Learn HTTP", first.title());
        assertEquals(1, first.id());
        assertEquals(java.util.List.of(first, second), service.findAll());
    }

    @Test
    void rejectsBlankTitlesWithoutCreatingTasks() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> service.create("  "));
        assertTrue(service.findAll().isEmpty());
    }
}
