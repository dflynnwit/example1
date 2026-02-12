package com.example.taskmanager;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class for managing tasks.
 * 
 * Implements CRUD operations for tasks following Agile user stories.
 * Developed incrementally across Sprint 2.
 */
public class TaskManager {
    
    private final Map<String, Task> tasks;
    private int nextId;
    
    public TaskManager() {
        this.tasks = new HashMap<>();
        this.nextId = 1;
    }
    
    /**
     * Creates a new task.
     * 
     * User Story: US-007 - As a logged-in user, I want to create a new task,
     * so that I can track things I need to do.
     * 
     * @param title Task title (required)
     * @param description Task description (optional)
     * @return The created task
     * @throws IllegalArgumentException if title is invalid
     */
    public Task createTask(String title, String description) {
        TaskValidator.validateTitle(title);
        TaskValidator.validateDescription(description);
        
        String id = generateId();
        Task task = new Task(id, title, description);
        tasks.put(id, task);
        
        return task;
    }
    
    /**
     * Retrieves a task by its ID.
     * 
     * User Story: US-008 - As a logged-in user, I want to view all my tasks,
     * so that I can see what I need to do.
     * 
     * @param id Task identifier
     * @return The task, or null if not found
     */
    public Task getTask(String id) {
        return tasks.get(id);
    }
    
    /**
     * Retrieves all tasks.
     * 
     * User Story: US-008 - View Task List
     * 
     * @return List of all tasks
     */
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }
    
    /**
     * Retrieves tasks filtered by status.
     * 
     * @param status Status to filter by
     * @return List of tasks with the specified status
     */
    public List<Task> getTasksByStatus(TaskStatus status) {
        return tasks.values().stream()
                .filter(task -> task.getStatus() == status)
                .collect(Collectors.toList());
    }
    
    /**
     * Updates an existing task.
     * 
     * User Story: US-009 - As a logged-in user, I want to edit an existing task,
     * so that I can update task details.
     * 
     * @param id Task identifier
     * @param title New title (required)
     * @param description New description (optional)
     * @return The updated task
     * @throws IllegalArgumentException if task not found or validation fails
     */
    public Task updateTask(String id, String title, String description) {
        Task task = tasks.get(id);
        if (task == null) {
            throw new IllegalArgumentException("Task not found: " + id);
        }
        
        TaskValidator.validateTitle(title);
        TaskValidator.validateDescription(description);
        
        task.setTitle(title);
        task.setDescription(description);
        
        return task;
    }
    
    /**
     * Updates the status of a task.
     * 
     * @param id Task identifier
     * @param status New status
     * @return The updated task
     * @throws IllegalArgumentException if task not found or status is invalid
     */
    public Task updateTaskStatus(String id, TaskStatus status) {
        Task task = tasks.get(id);
        if (task == null) {
            throw new IllegalArgumentException("Task not found: " + id);
        }
        
        task.setStatus(status);
        return task;
    }
    
    /**
     * Marks a task as complete.
     * 
     * User Story: US-011 - As a logged-in user, I want to mark a task as complete,
     * so that I can track my progress.
     * 
     * @param id Task identifier
     * @return The completed task
     * @throws IllegalArgumentException if task not found
     */
    public Task markTaskComplete(String id) {
        Task task = tasks.get(id);
        if (task == null) {
            throw new IllegalArgumentException("Task not found: " + id);
        }
        
        task.markComplete();
        return task;
    }
    
    /**
     * Deletes a task.
     * 
     * User Story: US-010 - As a logged-in user, I want to delete a task,
     * so that I can remove tasks I no longer need.
     * 
     * @param id Task identifier
     * @return true if task was deleted, false if not found
     */
    public boolean deleteTask(String id) {
        return tasks.remove(id) != null;
    }
    
    /**
     * Returns the total number of tasks.
     * 
     * @return Task count
     */
    public int getTaskCount() {
        return tasks.size();
    }
    
    /**
     * Clears all tasks (useful for testing).
     */
    public void clearAllTasks() {
        tasks.clear();
    }
    
    /**
     * Generates a unique task ID.
     * 
     * @return Unique ID string
     */
    private String generateId() {
        return "TASK-" + (nextId++);
    }
}
