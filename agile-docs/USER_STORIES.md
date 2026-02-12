# User Story Writing Guide

## User Story Format

### Template
```
As a [type of user]
I want [goal/desire]
So that [benefit/value]
```

### Example
```
As a registered user
I want to reset my password via email
So that I can regain access to my account if I forget my password
```

## INVEST Criteria

Good user stories follow the INVEST principles:

### Independent
- Stories should be self-contained
- Minimize dependencies on other stories
- Can be developed in any order

### Negotiable
- Details can be discussed and refined
- Not a contract or detailed requirements
- Room for collaboration and creativity

### Valuable
- Delivers clear value to the user or business
- Can articulate why it matters
- Prioritizable based on value

### Estimable
- Team can estimate effort reasonably
- Not too vague or too detailed
- Enough information to size the work

### Small
- Can be completed in one sprint
- If too large, break into smaller stories
- Aim for 1-3 days of work

### Testable
- Clear acceptance criteria
- Can verify when story is complete
- Can be demonstrated

## Acceptance Criteria

### Purpose
- Define "done" for a user story
- Provide testable conditions
- Guide development and testing

### Format: Given-When-Then (Gherkin)
```
Given [context/precondition]
When [action/event]
Then [expected outcome]
```

### Example
```
Story: Password Reset

Acceptance Criteria:
1. Given I am on the login page
   When I click "Forgot Password"
   Then I should see a password reset form

2. Given I enter a valid email address
   When I submit the reset form
   Then I should receive a password reset email within 5 minutes

3. Given I click the reset link in the email
   When I enter a new password meeting requirements
   Then my password should be updated
   And I should be logged in automatically
```

## Story Points and Estimation

### Fibonacci Scale
- 1, 2, 3, 5, 8, 13, 21
- Reflects increasing uncertainty with size
- Relative sizing, not time-based

### Planning Poker
1. Product Owner presents story
2. Team asks clarifying questions
3. Each member secretly selects estimate
4. All reveal simultaneously
5. Discuss outliers and re-estimate
6. Converge on consensus

### Story Point Guidelines
- **1 point**: Very simple, well-understood task (few hours)
- **2 points**: Simple task with minor complexity (half day)
- **3 points**: Moderate complexity (1 day)
- **5 points**: Complex task, some unknowns (2-3 days)
- **8 points**: Very complex, many unknowns (near full sprint)
- **13+ points**: Epic - needs to be broken down

## Example User Stories

### Story 1: User Registration
```
As a new visitor
I want to create an account
So that I can access personalized features

Acceptance Criteria:
- Given I am on the registration page
  When I enter valid email, password, and name
  Then an account should be created
  And I should receive a confirmation email

- Given I enter an email that already exists
  When I try to register
  Then I should see an error message
  And no account should be created

- Given I enter an invalid email format
  When I try to register
  Then I should see a validation error
  And the form should not submit

Story Points: 5
Priority: High
Sprint: 1
```

### Story 2: Search Functionality
```
As a logged-in user
I want to search for items by keyword
So that I can quickly find what I'm looking for

Acceptance Criteria:
- Given I enter a search term in the search box
  When I press Enter or click Search
  Then I should see results matching my query
  And results should be displayed within 2 seconds

- Given my search returns no results
  When the search completes
  Then I should see a "No results found" message
  And suggestions for related terms

- Given I search without entering any text
  When I try to submit the search
  Then I should see a validation message
  And no search should be performed

Story Points: 8
Priority: Medium
Sprint: 2
```

### Story 3: Profile Picture Upload
```
As a registered user
I want to upload a profile picture
So that I can personalize my account

Acceptance Criteria:
- Given I am on my profile page
  When I click "Upload Picture" and select an image
  Then the image should be uploaded and displayed
  And the image should be under 5MB

- Given I try to upload a file over 5MB
  When I select the file
  Then I should see an error message
  And the file should not be uploaded

- Given I upload an invalid file type (e.g., .txt)
  When I select the file
  Then I should see an error message
  And only image formats should be accepted

Story Points: 3
Priority: Low
Sprint: 3
```

## Epic vs Story vs Task

### Epic
- Large body of work
- Spans multiple sprints
- Broken down into stories
- Example: "User Account Management"

### User Story
- Single feature or functionality
- Completable in one sprint
- Delivers user value
- Example: "Password Reset"

### Task
- Technical work item
- Part of implementing a story
- No direct user-facing value
- Example: "Create database migration for password_reset_tokens table"

## Anti-Patterns to Avoid

### Too Technical
❌ "Implement OAuth2 authentication flow"
✅ "As a user, I want to log in using my Google account, so that I don't need to remember another password"

### No Value Statement
❌ "As a user, I want to see a dashboard"
✅ "As a user, I want to see a dashboard showing my recent activity, so that I can quickly understand what's new"

### Too Vague
❌ "Improve performance"
✅ "As a user, I want the search results to load in under 2 seconds, so that I can find information quickly"

### Too Large
❌ "Build entire e-commerce platform"
✅ Break into: "Product catalog", "Shopping cart", "Checkout process", etc.

## Tips for Success
1. **Collaborate**: Write stories with the team, not in isolation
2. **Refine regularly**: Groom backlog in ongoing refinement sessions
3. **Start with epics**: Break down progressively
4. **Include non-functional**: Don't forget performance, security, etc.
5. **Keep visible**: Use physical or digital board everyone can access
6. **Update continuously**: Stories evolve based on learning

## Tools
- Jira
- Azure DevOps
- Trello
- GitHub Issues/Projects
- Physical index cards
