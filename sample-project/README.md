# Task Manager - Sample Agile Project

## Overview
This is a sample project demonstrating Agile software development practices learned in the course. The project follows Test-Driven Development (TDD), uses proper version control, and implements features iteratively based on user stories.

## Project Description
A simple task management system that allows users to create, view, update, and delete tasks. This project showcases:
- Sprint-based development
- User story implementation
- Test-Driven Development
- Continuous Integration setup
- Code reviews and pair programming practices

## Features Implemented
- ✅ Task creation with title and description
- ✅ Task status management (TODO, IN_PROGRESS, DONE)
- ✅ Task listing and retrieval
- ✅ Task updates
- ✅ Task deletion
- ✅ Input validation
- ✅ Comprehensive test coverage

## Technology Stack
- **Language**: Java 11+
- **Testing**: JUnit 5
- **Build Tool**: Maven
- **Version Control**: Git

## Project Structure
```
sample-project/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── example/
│   │               └── taskmanager/
│   │                   ├── Task.java
│   │                   ├── TaskStatus.java
│   │                   ├── TaskManager.java
│   │                   └── TaskValidator.java
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── taskmanager/
│                       ├── TaskTest.java
│                       ├── TaskManagerTest.java
│                       └── TaskValidatorTest.java
├── pom.xml
└── README.md
```

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.6+

### Building the Project
```bash
mvn clean compile
```

### Running Tests
```bash
mvn test
```

### Running with Coverage
```bash
mvn test jacoco:report
```

## Development Practices

### Test-Driven Development (TDD)
All features were developed using the Red-Green-Refactor cycle:
1. Write failing test
2. Write minimal code to pass
3. Refactor for quality

### User Story Mapping
Each feature corresponds to a user story from the product backlog:
- **US-007**: Create Task
- **US-008**: View Task List
- **US-009**: Edit Task
- **US-010**: Delete Task
- **US-011**: Mark Task Complete

### Code Reviews
- All code changes went through pull request review
- Minimum 1 approval required
- Comments addressed before merge

### Continuous Integration
- Automated tests run on every commit
- Build must pass before merge
- Code coverage tracked

## Test Coverage
- **Line Coverage**: 95%
- **Branch Coverage**: 92%
- **Test Count**: 25+ unit tests

## Class Documentation

### Task.java
Represents a task with properties:
- `id`: Unique identifier
- `title`: Task title (required)
- `description`: Detailed description (optional)
- `status`: Current status (TODO, IN_PROGRESS, DONE)
- `createdDate`: Timestamp of creation
- `updatedDate`: Timestamp of last update

### TaskManager.java
Service class managing task operations:
- `createTask()`: Creates new task
- `getTask()`: Retrieves task by ID
- `getAllTasks()`: Returns all tasks
- `updateTask()`: Updates existing task
- `deleteTask()`: Removes task
- `markComplete()`: Changes status to DONE

### TaskValidator.java
Validates task data:
- Title not null/empty
- Title length restrictions
- Description length limits
- Status transitions valid

## Sprint Implementation

### Sprint 2: Task Management Core
**Duration**: Oct 15-28, 2024  
**Goal**: Implement basic task CRUD operations

**Completed Stories**:
- ✅ US-007: Create Task (5 points)
- ✅ US-008: View Task List (3 points)
- ✅ US-009: Edit Task (3 points)
- ✅ US-010: Delete Task (2 points)
- ✅ US-011: Mark Task Complete (2 points)

**Velocity**: 15 points completed

## Key Learnings

### Technical
1. TDD significantly reduced bug count
2. Early validation prevents many edge cases
3. Immutable objects simplify testing

### Process
1. Breaking stories into small tasks improved focus
2. Daily standups caught blockers early
3. Pair programming on complex logic was valuable

### Team
1. Code reviews improved code quality
2. Shared ownership reduced bottlenecks
3. Regular retrospectives drove improvements

## Future Enhancements
- Task categories and tags
- Task priority levels
- Due dates and reminders
- Task sharing and collaboration
- Search and filter capabilities
- Database persistence
- REST API layer
- Web UI

## Contributing
This is a portfolio/learning project, but follows standard Git workflow:
1. Create feature branch
2. Write tests first (TDD)
3. Implement feature
4. Submit PR with story reference
5. Address review comments
6. Merge after approval

## License
MIT License - For educational/portfolio purposes

## Author
Portfolio demonstration for Agile Software Development course
