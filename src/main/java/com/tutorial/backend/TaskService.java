package com.tutorial.backend;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public final class TaskService {
    private final Map<Long, Task> tasks = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public List<Task> findAll() {
        return tasks.values().stream()
                .sorted((left, right) -> Long.compare(left.id(), right.id()))
                .toList();
    }

    public Task findById(long id) {
        return tasks.get(id);
    }

    public Task create(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must not be blank");
        }
        Task task = new Task(nextId.getAndIncrement(), title.trim());
        tasks.put(task.id(), task);
        return task;
    }

    public record Task(long id, String title) {}
}
