package com.example.TaskTracker.repository;

import com.example.TaskTracker.pojo.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    // You can add custom query methods here if needed
}