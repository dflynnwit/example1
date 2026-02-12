# Test-Driven Development (TDD)

## Overview
Test-Driven Development is a software development approach where tests are written before the code. It follows a simple cycle: Red-Green-Refactor.

## The TDD Cycle

### 1. Red - Write a Failing Test
- Write a test for the next bit of functionality
- The test should fail because the code doesn't exist yet
- Verifies that the test can fail

### 2. Green - Make the Test Pass
- Write the minimum code needed to make the test pass
- Don't worry about perfection yet
- Focus on functionality, not optimization

### 3. Refactor - Improve the Code
- Clean up the code while keeping tests green
- Remove duplication
- Improve design and readability
- Tests ensure nothing breaks

## Benefits of TDD

### Code Quality
- Forces you to think about design before implementation
- Results in more modular, testable code
- Catches bugs early in development

### Documentation
- Tests serve as living documentation
- Show how code is intended to be used
- Examples of expected behavior

### Confidence
- Safe to refactor with comprehensive test coverage
- Regression testing built-in
- Quick feedback on changes

### Design Improvement
- Encourages simpler, more focused code
- Promotes loose coupling
- Identifies design issues early

## TDD Example: Calculator Class

### Iteration 1: Addition

#### Test First (Red)
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    
    @Test
    public void testAddition() {
        Calculator calc = new Calculator();
        int result = calc.add(2, 3);
        assertEquals(5, result);
    }
}
```

#### Make It Pass (Green)
```java
public class Calculator {
    
    public int add(int a, int b) {
        return a + b;
    }
}
```

#### Refactor
- Code is already simple, no refactoring needed

### Iteration 2: Subtraction

#### Test First (Red)
```java
@Test
public void testSubtraction() {
    Calculator calc = new Calculator();
    int result = calc.subtract(5, 3);
    assertEquals(2, result);
}
```

#### Make It Pass (Green)
```java
public class Calculator {
    
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
}
```

### Iteration 3: Division with Error Handling

#### Test First (Red)
```java
@Test
public void testDivision() {
    Calculator calc = new Calculator();
    double result = calc.divide(10, 2);
    assertEquals(5.0, result, 0.001);
}

@Test
public void testDivisionByZero() {
    Calculator calc = new Calculator();
    assertThrows(ArithmeticException.class, () -> {
        calc.divide(10, 0);
    });
}
```

#### Make It Pass (Green)
```java
public class Calculator {
    
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) a / b;
    }
}
```

## TDD Best Practices

### Write Small Tests
- Test one thing at a time
- Keep tests focused and simple
- Easy to understand what failed

### Test Behavior, Not Implementation
```java
// Good - Tests behavior
@Test
public void shouldReturnEmptyListWhenNoItemsMatch() {
    List<Item> results = search.findItems("nonexistent");
    assertTrue(results.isEmpty());
}

// Bad - Tests implementation details
@Test
public void shouldCallDatabaseQueryMethod() {
    search.findItems("test");
    verify(database).query(any());
}
```

### Use Descriptive Test Names
```java
// Good
@Test
public void shouldThrowExceptionWhenAmountIsNegative() { }

@Test
public void shouldReturnTrueWhenUserIsAuthenticated() { }

// Bad
@Test
public void test1() { }

@Test
public void testValidation() { }
```

### Follow AAA Pattern
```java
@Test
public void testWithdrawal() {
    // Arrange - Setup test data and conditions
    BankAccount account = new BankAccount(100);
    
    // Act - Execute the behavior being tested
    account.withdraw(30);
    
    // Assert - Verify the outcome
    assertEquals(70, account.getBalance());
}
```

### Keep Tests Independent
- Each test should run in isolation
- No dependencies between tests
- Tests can run in any order

### Fast Feedback
- Tests should run quickly
- Use test doubles (mocks, stubs) for external dependencies
- Quick feedback encourages running tests frequently

## Common TDD Patterns

### Test Doubles

#### Mock
```java
@Test
public void shouldSendEmailOnRegistration() {
    EmailService mockEmail = mock(EmailService.class);
    UserService service = new UserService(mockEmail);
    
    service.registerUser("user@example.com");
    
    verify(mockEmail).send(eq("user@example.com"), anyString());
}
```

#### Stub
```java
@Test
public void shouldCalculateDiscount() {
    PriceService stubPriceService = mock(PriceService.class);
    when(stubPriceService.getPrice("item1")).thenReturn(100.0);
    
    DiscountCalculator calc = new DiscountCalculator(stubPriceService);
    double result = calc.calculateDiscount("item1", 0.1);
    
    assertEquals(90.0, result, 0.01);
}
```

### Parameterized Tests
```java
@ParameterizedTest
@CsvSource({
    "2, 3, 5",
    "10, 20, 30",
    "-5, 5, 0",
    "0, 0, 0"
})
public void testAdditionWithMultipleInputs(int a, int b, int expected) {
    Calculator calc = new Calculator();
    assertEquals(expected, calc.add(a, b));
}
```

## TDD Anti-Patterns

### Testing Too Much
- Don't test framework code
- Don't test trivial getters/setters
- Focus on business logic

### Tests That Are Too Large
- Break into smaller, focused tests
- Each test should verify one behavior

### Ignoring Failing Tests
- Fix immediately or remove the test
- Never commit with failing tests
- Failing tests lose value over time

### Not Refactoring
- TDD without refactoring is incomplete
- Clean code is as important as working code

## Integration with Agile

### Definition of Done
- All tests passing
- Code coverage maintained or improved
- New features have test coverage

### Pair Programming
- Navigator writes test
- Driver implements code
- Switch roles regularly

### Continuous Integration
- Tests run automatically on commit
- Fast feedback on integration issues
- Prevents broken builds

## Metrics

### Code Coverage
- Percentage of code executed by tests
- Aim for >80% coverage
- Not a guarantee of quality, but useful metric

### Test-to-Code Ratio
- Typical ratio: 1:1 or higher
- More test code than production code is normal

## Tools

### Java
- JUnit 5
- Mockito
- AssertJ
- TestNG

### JavaScript
- Jest
- Mocha
- Jasmine
- Cypress

### Python
- pytest
- unittest
- mock

### CI/CD
- Jenkins
- GitHub Actions
- GitLab CI
- Travis CI

## Learning Resources
- "Test Driven Development: By Example" - Kent Beck
- "Growing Object-Oriented Software, Guided by Tests" - Steve Freeman
- Kata exercises: Code katas for TDD practice
