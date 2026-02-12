package com.example.taskmanager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Test class for TaskManager service.
 * 
 * Demonstrates TDD approach with comprehensive test coverage.
 * Tests correspond to user stories from Sprint 2.
 */
class TaskManagerTest {
    
    private TaskManager taskManager;
    
    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }
    
    // Tests for US-007: Create Task
    
    @Test
    void testCreateTask() {
        // Arrange
        String title = "Write unit tests";
        String description = "Create comprehensive test suite";
        
        // Act
        Task task = taskManager.createTask(title, description);
        
        // Assert
        assertNotNull(task);
        assertNotNull(task.getId());
        assertEquals(title, task.getTitle());
        assertEquals(description, task.getDescription());
        assertEquals(TaskStatus.TODO, task.getStatus());
    }
    
    @Test
    void testCreateTaskWithNullTitle() {
        // Arrange, Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            taskManager.createTask(null, "Description");
        });
    }
    
    @Test
    void testCreateTaskWithEmptyTitle() {
        // Arrange, Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            taskManager.createTask("  ", "Description");
        });
    }
    
    @Test
    void testCreateMultipleTasks() {
        // Act
        Task task1 = taskManager.createTask("Task 1", "Description 1");
        Task task2 = taskManager.createTask("Task 2", "Description 2");
        
        // Assert
        assertNotEquals(task1.getId(), task2.getId());
        assertEquals(2, taskManager.getTaskCount());
    }
    
    // Tests for US-008: View Task List
    
    @Test
    void testGetTask() {
        // Arrange
        Task createdTask = taskManager.createTask("Test Task", "Test Description");
        
        // Act
        Task retrievedTask = taskManager.getTask(createdTask.getId());
        
        // Assert
        assertNotNull(retrievedTask);
        assertEquals(createdTask.getId(), retrievedTask.getId());
        assertEquals(createdTask.getTitle(), retrievedTask.getTitle());
    }
    
    @Test
    void testGetTaskNotFound() {
        // Act
        Task task = taskManager.getTask("NON_EXISTENT");
        
        // Assert
        assertNull(task);
    }
    
    @Test
    void testGetAllTasks() {
        // Arrange
        taskManager.createTask("Task 1", "Desc 1");
        taskManager.createTask("Task 2", "Desc 2");
        taskManager.createTask("Task 3", "Desc 3");
        
        // Act
        List<Task> tasks = taskManager.getAllTasks();
        
        // Assert
        assertEquals(3, tasks.size());
    }
    
    @Test
    void testGetAllTasksEmpty() {
        // Act
        List<Task> tasks = taskManager.getAllTasks();
        
        // Assert
        assertTrue(tasks.isEmpty());
    }
    
    @Test
    void testGetTasksByStatus() {
        // Arrange
        Task task1 = taskManager.createTask("Task 1", "Desc 1");
        Task task2 = taskManager.createTask("Task 2", "Desc 2");
        Task task3 = taskManager.createTask("Task 3", "Desc 3");
        
        taskManager.updateTaskStatus(task2.getId(), TaskStatus.IN_PROGRESS);
        taskManager.markTaskComplete(task3.getId());
        
        // Act
        List<Task> todoTasks = taskManager.getTasksByStatus(TaskStatus.TODO);
        List<Task> inProgressTasks = taskManager.getTasksByStatus(TaskStatus.IN_PROGRESS);
        List<Task> doneTasks = taskManager.getTasksByStatus(TaskStatus.DONE);
        
        // Assert
        assertEquals(1, todoTasks.size());
        assertEquals(1, inProgressTasks.size());
        assertEquals(1, doneTasks.size());
        assertEquals(task1.getId(), todoTasks.get(0).getId());
        assertEquals(task2.getId(), inProgressTasks.get(0).getId());
        assertEquals(task3.getId(), doneTasks.get(0).getId());
    }
    
    // Tests for US-009: Edit Task
    
    @Test
    void testUpdateTask() {
        // Arrange
        Task task = taskManager.createTask("Original Title", "Original Description");
        String newTitle = "Updated Title";
        String newDescription = "Updated Description";
        
        // Act
        Task updatedTask = taskManager.updateTask(task.getId(), newTitle, newDescription);
        
        // Assert
        assertEquals(newTitle, updatedTask.getTitle());
        assertEquals(newDescription, updatedTask.getDescription());
    }
    
    @Test
    void testUpdateTaskNotFound() {
        // Arrange, Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            taskManager.updateTask("NON_EXISTENT", "Title", "Description");
        });
    }
    
    @Test
    void testUpdateTaskWithInvalidTitle() {
        // Arrange
        Task task = taskManager.createTask("Original Title", "Original Description");
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            taskManager.updateTask(task.getId(), "", "Description");
        });
    }
    
    @Test
    void testUpdateTaskStatus() {
        // Arrange
        Task task = taskManager.createTask("Task", "Description");
        
        // Act
        Task updatedTask = taskManager.updateTaskStatus(task.getId(), TaskStatus.IN_PROGRESS);
        
        // Assert
        assertEquals(TaskStatus.IN_PROGRESS, updatedTask.getStatus());
    }
    
    @Test
    void testUpdateTaskStatusNotFound() {
        // Arrange, Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            taskManager.updateTaskStatus("NON_EXISTENT", TaskStatus.DONE);
        });
    }
    
    // Tests for US-011: Mark Task Complete
    
    @Test
    void testMarkTaskComplete() {
        // Arrange
        Task task = taskManager.createTask("Task to complete", "Description");
        assertEquals(TaskStatus.TODO, task.getStatus());
        
        // Act
        Task completedTask = taskManager.markTaskComplete(task.getId());
        
        // Assert
        assertEquals(TaskStatus.DONE, completedTask.getStatus());
        assertTrue(completedTask.isComplete());
    }
    
    @Test
    void testMarkTaskCompleteNotFound() {
        // Arrange, Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            taskManager.markTaskComplete("NON_EXISTENT");
        });
    }
    
    // Tests for US-010: Delete Task
    
    @Test
    void testDeleteTask() {
        // Arrange
        Task task = taskManager.createTask("Task to delete", "Description");
        String taskId = task.getId();
        assertEquals(1, taskManager.getTaskCount());
        
        // Act
        boolean deleted = taskManager.deleteTask(taskId);
        
        // Assert
        assertTrue(deleted);
        assertEquals(0, taskManager.getTaskCount());
        assertNull(taskManager.getTask(taskId));
    }
    
    @Test
    void testDeleteTaskNotFound() {
        // Act
        boolean deleted = taskManager.deleteTask("NON_EXISTENT");
        
        // Assert
        assertFalse(deleted);
    }
    
    @Test
    void testDeleteTaskDoesNotAffectOthers() {
        // Arrange
        Task task1 = taskManager.createTask("Task 1", "Desc 1");
        Task task2 = taskManager.createTask("Task 2", "Desc 2");
        Task task3 = taskManager.createTask("Task 3", "Desc 3");
        
        // Act
        taskManager.deleteTask(task2.getId());
        
        // Assert
        assertEquals(2, taskManager.getTaskCount());
        assertNotNull(taskManager.getTask(task1.getId()));
        assertNull(taskManager.getTask(task2.getId()));
        assertNotNull(taskManager.getTask(task3.getId()));
    }
    
    // Additional tests
    
    @Test
    void testGetTaskCount() {
        // Arrange & Assert - initially 0
        assertEquals(0, taskManager.getTaskCount());
        
        // Act
        taskManager.createTask("Task 1", "Desc 1");
        taskManager.createTask("Task 2", "Desc 2");
        
        // Assert
        assertEquals(2, taskManager.getTaskCount());
    }
    
    @Test
    void testClearAllTasks() {
        // Arrange
        taskManager.createTask("Task 1", "Desc 1");
        taskManager.createTask("Task 2", "Desc 2");
        assertEquals(2, taskManager.getTaskCount());
        
        // Act
        taskManager.clearAllTasks();
        
        // Assert
        assertEquals(0, taskManager.getTaskCount());
        assertTrue(taskManager.getAllTasks().isEmpty());
    }
}
