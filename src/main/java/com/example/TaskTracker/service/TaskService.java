package com.example.TaskTracker.service;

import com.example.TaskTracker.pojo.Task;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getAllTasks();

    Optional<Task> getTaskById(String id);

    Task saveTask(Task task);

    void deleteTask(String id);
}