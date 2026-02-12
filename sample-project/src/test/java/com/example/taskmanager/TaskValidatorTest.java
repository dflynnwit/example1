package com.example.taskmanager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for TaskValidator.
 * 
 * Following TDD principles to ensure all validation rules are covered.
 */
class TaskValidatorTest {
    
    // Title validation tests
    
    @Test
    void testValidateValidTitle() {
        // Should not throw exception
        assertDoesNotThrow(() -> {
            TaskValidator.validateTitle("Valid title");
        });
    }
    
    @Test
    void testValidateTitleNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            TaskValidator.validateTitle(null);
        });
    }
    
    @Test
    void testValidateTitleEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            TaskValidator.validateTitle("");
        });
    }
    
    @Test
    void testValidateTitleWhitespace() {
        assertThrows(IllegalArgumentException.class, () -> {
            TaskValidator.validateTitle("   ");
        });
    }
    
    @Test
    void testValidateTitleTooLong() {
        // Create a title that exceeds 100 characters
        String longTitle = "a".repeat(101);
        
        assertThrows(IllegalArgumentException.class, () -> {
            TaskValidator.validateTitle(longTitle);
        });
    }
    
    @Test
    void testValidateTitleExactlyMaxLength() {
        // Create a title that is exactly 100 characters
        String maxTitle = "a".repeat(100);
        
        assertDoesNotThrow(() -> {
            TaskValidator.validateTitle(maxTitle);
        });
    }
    
    // Description validation tests
    
    @Test
    void testValidateValidDescription() {
        assertDoesNotThrow(() -> {
            TaskValidator.validateDescription("Valid description");
        });
    }
    
    @Test
    void testValidateDescriptionNull() {
        // Null description should be allowed
        assertDoesNotThrow(() -> {
            TaskValidator.validateDescription(null);
        });
    }
    
    @Test
    void testValidateDescriptionEmpty() {
        // Empty description should be allowed
        assertDoesNotThrow(() -> {
            TaskValidator.validateDescription("");
        });
    }
    
    @Test
    void testValidateDescriptionTooLong() {
        // Create a description that exceeds 500 characters
        String longDesc = "a".repeat(501);
        
        assertThrows(IllegalArgumentException.class, () -> {
            TaskValidator.validateDescription(longDesc);
        });
    }
    
    @Test
    void testValidateDescriptionExactlyMaxLength() {
        // Create a description that is exactly 500 characters
        String maxDesc = "a".repeat(500);
        
        assertDoesNotThrow(() -> {
            TaskValidator.validateDescription(maxDesc);
        });
    }
    
    // ID validation tests
    
    @Test
    void testValidateValidId() {
        assertDoesNotThrow(() -> {
            TaskValidator.validateId("TASK-123");
        });
    }
    
    @Test
    void testValidateIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            TaskValidator.validateId(null);
        });
    }
    
    @Test
    void testValidateIdEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            TaskValidator.validateId("");
        });
    }
    
    @Test
    void testValidateIdWhitespace() {
        assertThrows(IllegalArgumentException.class, () -> {
            TaskValidator.validateId("   ");
        });
    }
}
