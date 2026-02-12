package com.example.taskmanager;

/**
 * Validator class for task data.
 * 
 * Provides centralized validation logic following the Single Responsibility Principle.
 * Developed using TDD to ensure all edge cases are covered.
 */
public class TaskValidator {
    
    private static final int MAX_TITLE_LENGTH = 100;
    private static final int MAX_DESCRIPTION_LENGTH = 500;
    
    /**
     * Validates a task title.
     * 
     * @param title Title to validate
     * @throws IllegalArgumentException if validation fails
     */
    public static void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Task title cannot be null or empty");
        }
        
        if (title.trim().length() > MAX_TITLE_LENGTH) {
            throw new IllegalArgumentException(
                "Task title cannot exceed " + MAX_TITLE_LENGTH + " characters"
            );
        }
    }
    
    /**
     * Validates a task description.
     * 
     * @param description Description to validate
     * @throws IllegalArgumentException if validation fails
     */
    public static void validateDescription(String description) {
        if (description != null && description.trim().length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException(
                "Task description cannot exceed " + MAX_DESCRIPTION_LENGTH + " characters"
            );
        }
    }
    
    /**
     * Validates a task ID.
     * 
     * @param id ID to validate
     * @throws IllegalArgumentException if validation fails
     */
    public static void validateId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Task ID cannot be null or empty");
        }
    }
}
