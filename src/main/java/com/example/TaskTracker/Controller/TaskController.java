package com.example.TaskTracker.Controller;

import com.example.TaskTracker.pojo.Task;
import com.example.TaskTracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String getAllTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "task-list";
    }

    @GetMapping("/add")
    public String addTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "add-task";
    }

    @PostMapping("/add")
    public String addTaskSubmit(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks/";
    }

    @GetMapping("/edit/{id}")
    public String editTaskForm(@PathVariable String id, Model model) {
        Optional<Task> task = taskService.getTaskById(id);
        task.ifPresent(t -> model.addAttribute("task", t));
        return "edit-task";
    }

    @PostMapping("/edit/{id}")
    public String editTaskSubmit(@PathVariable String id, @ModelAttribute Task updatedTask) {
        Optional<Task> task = taskService.getTaskById(id);
        if (task.isPresent()) {
            Task existingTask = task.get();
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setPriority(updatedTask.getPriority());
            existingTask.setDueDate(updatedTask.getDueDate());
            taskService.saveTask(existingTask);
        }
        return "redirect:/tasks/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
        return "redirect:/tasks/";
    }
}
