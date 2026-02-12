package com.example.taskmanager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Task entity.
 * 
 * Following Test-Driven Development (TDD) principles:
 * - Tests written before implementation
 * - Red-Green-Refactor cycle
 * - Each test focuses on a single behavior
 */
class TaskTest {
    
    private Task task;
    
    @BeforeEach
    void setUp() {
        task = new Task("TASK-1", "Complete assignment", "Finish the Agile project");
    }
    
    @Test
    void testTaskCreation() {
        // Arrange & Act - done in setUp
        
        // Assert
        assertNotNull(task);
        assertEquals("TASK-1", task.getId());
        assertEquals("Complete assignment", task.getTitle());
        assertEquals("Finish the Agile project", task.getDescription());
        assertEquals(TaskStatus.TODO, task.getStatus());
        assertNotNull(task.getCreatedDate());
        assertNotNull(task.getUpdatedDate());
    }
    
    @Test
    void testTaskCreationWithNullId() {
        // Arrange, Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Title", "Description");
        });
    }
    
    @Test
    void testTaskCreationWithEmptyId() {
        // Arrange, Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("  ", "Title", "Description");
        });
    }
    
    @Test
    void testTaskCreationWithNullTitle() {
        // Arrange, Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("TASK-1", null, "Description");
        });
    }
    
    @Test
    void testTaskCreationWithEmptyTitle() {
        // Arrange, Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("TASK-1", "  ", "Description");
        });
    }
    
    @Test
    void testTaskCreationWithNullDescription() {
        // Arrange & Act
        Task taskWithNullDesc = new Task("TASK-2", "Title", null);
        
        // Assert - should default to empty string
        assertEquals("", taskWithNullDesc.getDescription());
    }
    
    @Test
    void testSetTitle() {
        // Arrange
        String newTitle = "Updated title";
        
        // Act
        task.setTitle(newTitle);
        
        // Assert
        assertEquals(newTitle, task.getTitle());
    }
    
    @Test
    void testSetTitleWithNull() {
        // Arrange, Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            task.setTitle(null);
        });
    }
    
    @Test
    void testSetTitleWithEmpty() {
        // Arrange, Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            task.setTitle("   ");
        });
    }
    
    @Test
    void testSetDescription() {
        // Arrange
        String newDesc = "Updated description";
        
        // Act
        task.setDescription(newDesc);
        
        // Assert
        assertEquals(newDesc, task.getDescription());
    }
    
    @Test
    void testSetDescriptionWithNull() {
        // Arrange & Act
        task.setDescription(null);
        
        // Assert - should default to empty string
        assertEquals("", task.getDescription());
    }
    
    @Test
    void testSetStatus() {
        // Arrange & Act
        task.setStatus(TaskStatus.IN_PROGRESS);
        
        // Assert
        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
    }
    
    @Test
    void testSetStatusWithNull() {
        // Arrange, Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            task.setStatus(null);
        });
    }
    
    @Test
    void testMarkComplete() {
        // Arrange - task starts as TODO
        assertEquals(TaskStatus.TODO, task.getStatus());
        
        // Act
        task.markComplete();
        
        // Assert
        assertEquals(TaskStatus.DONE, task.getStatus());
        assertTrue(task.isComplete());
    }
    
    @Test
    void testIsComplete() {
        // Arrange
        task.setStatus(TaskStatus.TODO);
        assertFalse(task.isComplete());
        
        task.setStatus(TaskStatus.IN_PROGRESS);
        assertFalse(task.isComplete());
        
        // Act
        task.setStatus(TaskStatus.DONE);
        
        // Assert
        assertTrue(task.isComplete());
    }
    
    @Test
    void testTaskEquality() {
        // Arrange
        Task task1 = new Task("TASK-1", "Title1", "Desc1");
        Task task2 = new Task("TASK-1", "Title2", "Desc2");
        Task task3 = new Task("TASK-2", "Title1", "Desc1");
        
        // Assert - equality based on ID only
        assertEquals(task1, task2);
        assertNotEquals(task1, task3);
    }
    
    @Test
    void testTaskHashCode() {
        // Arrange
        Task task1 = new Task("TASK-1", "Title1", "Desc1");
        Task task2 = new Task("TASK-1", "Title2", "Desc2");
        
        // Assert - same ID means same hash code
        assertEquals(task1.hashCode(), task2.hashCode());
    }
    
    @Test
    void testTitleTrimming() {
        // Arrange & Act
        Task taskWithSpaces = new Task("TASK-3", "  Title with spaces  ", "Description");
        
        // Assert
        assertEquals("Title with spaces", taskWithSpaces.getTitle());
    }
    
    @Test
    void testDescriptionTrimming() {
        // Arrange & Act
        Task taskWithSpaces = new Task("TASK-4", "Title", "  Description with spaces  ");
        
        // Assert
        assertEquals("Description with spaces", taskWithSpaces.getDescription());
    }
    
    @Test
    void testToString() {
        // Act
        String str = task.toString();
        
        // Assert
        assertTrue(str.contains("TASK-1"));
        assertTrue(str.contains("Complete assignment"));
        assertTrue(str.contains("TODO"));
    }
}
