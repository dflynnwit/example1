package com.example.taskmanager;

/**
 * Enumeration representing the status of a task.
 * 
 * Part of User Story: US-011 - Task status management
 */
public enum TaskStatus {
    /**
     * Task has not been started yet
     */
    TODO,
    
    /**
     * Task is currently being worked on
     */
    IN_PROGRESS,
    
    /**
     * Task has been completed
     */
    DONE
}
