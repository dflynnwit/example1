package com.example.taskmanager;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents a task in the task management system.
 * 
 * User Story: US-007 - As a logged-in user, I want to create a new task,
 * so that I can track things I need to do.
 * 
 * Developed using Test-Driven Development (TDD) approach.
 */
public class Task {
    
    private final String id;
    private String title;
    private String description;
    private TaskStatus status;
    private final LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    
    /**
     * Creates a new Task with the specified details.
     * 
     * @param id Unique identifier for the task
     * @param title Title of the task (required)
     * @param description Detailed description (optional)
     */
    public Task(String id, String title, String description) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Task ID cannot be null or empty");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Task title cannot be null or empty");
        }
        
        this.id = id;
        this.title = title.trim();
        this.description = description != null ? description.trim() : "";
        this.status = TaskStatus.TODO;
        this.createdDate = LocalDateTime.now();
        this.updatedDate = this.createdDate;
    }
    
    // Getters
    
    public String getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public TaskStatus getStatus() {
        return status;
    }
    
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
    
    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }
    
    // Setters with validation
    
    /**
     * Updates the task title.
     * 
     * @param title New title (required)
     * @throws IllegalArgumentException if title is null or empty
     */
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Task title cannot be null or empty");
        }
        this.title = title.trim();
        this.updatedDate = LocalDateTime.now();
    }
    
    /**
     * Updates the task description.
     * 
     * @param description New description (optional)
     */
    public void setDescription(String description) {
        this.description = description != null ? description.trim() : "";
        this.updatedDate = LocalDateTime.now();
    }
    
    /**
     * Updates the task status.
     * 
     * @param status New status
     * @throws IllegalArgumentException if status is null
     */
    public void setStatus(TaskStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Task status cannot be null");
        }
        this.status = status;
        this.updatedDate = LocalDateTime.now();
    }
    
    /**
     * Marks the task as complete (status = DONE).
     * 
     * User Story: US-011 - As a logged-in user, I want to mark a task as complete,
     * so that I can track my progress.
     */
    public void markComplete() {
        this.status = TaskStatus.DONE;
        this.updatedDate = LocalDateTime.now();
    }
    
    /**
     * Checks if the task is complete.
     * 
     * @return true if status is DONE, false otherwise
     */
    public boolean isComplete() {
        return this.status == TaskStatus.DONE;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", createdDate=" + createdDate +
                '}';
    }
}
