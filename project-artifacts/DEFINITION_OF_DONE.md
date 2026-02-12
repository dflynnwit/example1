# Definition of Done (DoD)

## Overview
The Definition of Done is a shared understanding of what it means for work to be complete. It ensures quality and consistency across all deliverables.

## Purpose
- Provides clarity on completion criteria
- Ensures quality standards are met
- Reduces ambiguity in "done"
- Creates shared accountability
- Enables predictable delivery

## Definition of Done Checklist

### Code Quality
- [ ] **Code written**: Feature implemented according to acceptance criteria
- [ ] **Code follows standards**: Adheres to team coding conventions
- [ ] **No hardcoded values**: Configuration externalized appropriately
- [ ] **No commented-out code**: Dead code removed
- [ ] **Error handling**: Proper exception handling implemented
- [ ] **Logging added**: Appropriate logging at key points
- [ ] **Code self-documented**: Clear variable/function names, minimal comments needed

### Testing
- [ ] **Unit tests written**: All new code has unit tests
- [ ] **Unit tests passing**: All unit tests pass locally
- [ ] **Test coverage maintained**: Code coverage ≥80%
- [ ] **Integration tests passing**: Integration tests pass (if applicable)
- [ ] **Edge cases tested**: Boundary conditions and error cases covered
- [ ] **Manual testing done**: Feature manually verified
- [ ] **No known bugs**: No critical or high-priority defects

### Code Review
- [ ] **Pull request created**: Code submitted for review
- [ ] **PR description complete**: Clear description of changes
- [ ] **User story linked**: PR references user story/task
- [ ] **Reviewers assigned**: Minimum 1 reviewer assigned
- [ ] **Review comments addressed**: All feedback incorporated or discussed
- [ ] **Approved**: PR approved by required reviewers
- [ ] **No merge conflicts**: Branch up to date with target branch

### Documentation
- [ ] **Code documented**: Complex logic explained in comments
- [ ] **API documented**: Public interfaces documented (if applicable)
- [ ] **README updated**: Project documentation updated
- [ ] **User guide updated**: End-user documentation updated (if applicable)
- [ ] **Architecture docs updated**: Design docs reflect changes (for significant changes)
- [ ] **Changelog updated**: Changes noted in changelog

### Integration
- [ ] **Code merged**: PR merged to appropriate branch
- [ ] **CI/CD pipeline passing**: All automated checks pass
- [ ] **Build successful**: Application builds without errors
- [ ] **Deployed to test environment**: Changes deployed to staging/test
- [ ] **No deployment errors**: Deployment completed successfully

### Acceptance
- [ ] **Acceptance criteria met**: All AC from user story satisfied
- [ ] **Product Owner approval**: PO accepts the feature
- [ ] **Stakeholder demo**: Feature demonstrated (if required)
- [ ] **No regression**: Existing functionality still works
- [ ] **Performance acceptable**: No significant performance degradation

### Security
- [ ] **Security reviewed**: Code reviewed for security issues
- [ ] **No hardcoded secrets**: Passwords, keys, tokens externalized
- [ ] **Input validated**: All user inputs validated
- [ ] **SQL injection prevented**: Parameterized queries used
- [ ] **XSS prevented**: Output properly escaped (for web apps)
- [ ] **Authentication/Authorization**: Proper access controls

## Definition of Done by Work Type

### User Story
All items from main DoD checklist, plus:
- [ ] Story delivers user value
- [ ] Acceptance criteria fully met
- [ ] Product Owner accepts feature
- [ ] User documentation updated

### Bug Fix
- [ ] Root cause identified
- [ ] Fix addresses root cause, not symptom
- [ ] Test added to prevent regression
- [ ] Related bugs considered
- [ ] Fix verified in production-like environment

### Technical Story/Refactoring
- [ ] Code quality improved (measurable)
- [ ] No functionality broken
- [ ] Tests updated to reflect changes
- [ ] Team understands changes
- [ ] Performance maintained or improved

### Spike/Research
- [ ] Research question answered
- [ ] Findings documented
- [ ] Recommendations provided
- [ ] Team presentation given
- [ ] Follow-up stories created (if needed)

## Examples

### Example 1: User Login Feature

**User Story**: As a registered user, I want to log in with my credentials, so that I can access my account.

**Definition of Done Verification**:
✅ Code Quality
- Login functionality implemented
- Password hashing used
- Session management implemented
- Error messages user-friendly

✅ Testing
- 15 unit tests written and passing
- Integration test with database passing
- Tested with valid/invalid credentials
- Test coverage: 87%

✅ Code Review
- PR #123 created and linked to US-002
- Reviewed by Alice and Bob
- Security concerns addressed
- Approved and merged

✅ Documentation
- API endpoint documented
- README updated with authentication info
- Inline comments for complex logic

✅ Integration
- Merged to main branch
- CI pipeline passed
- Deployed to staging
- Smoke tests passed

✅ Acceptance
- Product Owner verified functionality
- Demonstrated in Sprint Review
- All acceptance criteria met

✅ Security
- Password complexity enforced
- Account lockout after 5 attempts
- No credentials in logs
- Session timeout implemented

**Result**: Story meets Definition of Done ✅

---

### Example 2: Bug Fix - Incomplete

**Bug**: Users can't log in with special characters in password

**Current Status**:
✅ Root cause identified (encoding issue)
✅ Fix implemented
✅ Manual testing done
❌ Unit test not added
❌ Code review not completed
❌ Not deployed to test environment

**Result**: Bug fix does NOT meet Definition of Done ❌

**Next Steps**:
1. Add regression test
2. Submit for code review
3. Deploy to staging after approval

## Enforcement

### Sprint Planning
- Review DoD with team
- Ensure stories have clear acceptance criteria
- Estimate work including DoD activities

### During Sprint
- Check DoD during daily standup
- Use DoD checklist for each story
- Don't move to "Done" until DoD met

### Sprint Review
- Only demo items that meet DoD
- If DoD not met, story not complete
- Incomplete stories return to backlog

### Retrospective
- Discuss DoD effectiveness
- Update DoD based on learnings
- Add/remove criteria as needed

## Common Violations and Solutions

### Violation: "We'll add tests later"
**Impact**: Technical debt, increased bug risk  
**Solution**: Tests are part of DoD, not optional. Story not done without tests.

### Violation: "Just merge it, we'll fix in production"
**Impact**: Quality issues, rushed fixes  
**Solution**: Follow DoD. If urgent, create hot-fix process with expedited DoD.

### Violation: "Documentation can wait"
**Impact**: Knowledge gaps, maintenance difficulty  
**Solution**: Minimal documentation required. Update README/API docs before closing.

### Violation: "PO hasn't reviewed yet, but let's move on"
**Impact**: Misalignment, potential rework  
**Solution**: Schedule PO reviews during sprint. Demo early for feedback.

## Continuous Improvement

### Review Quarterly
- Is DoD still relevant?
- Are criteria too strict/loose?
- Are we consistently meeting DoD?
- What should we add/remove?

### Metrics to Track
- % stories meeting DoD on first attempt
- Time to complete DoD activities
- Defect rate for DoD-compliant stories
- Team satisfaction with DoD

### Evolution Example
**Sprint 1 DoD**: Basic (code, test, merge)  
**Sprint 5 DoD**: Added documentation requirements  
**Sprint 10 DoD**: Added security checklist  
**Sprint 15 DoD**: Added performance criteria  

## DoD vs Acceptance Criteria

### Acceptance Criteria
- **Specific to user story**
- **Defines feature behavior**
- **Written by Product Owner**
- **Varies per story**

**Example**: "User can reset password via email link"

### Definition of Done
- **Applies to all work**
- **Defines quality standards**
- **Agreed by whole team**
- **Consistent across stories**

**Example**: "All code has unit tests with 80% coverage"

### Relationship
- **AC defines WHAT** to build
- **DoD defines HOW WELL** to build it
- **Both must be satisfied** for story to be complete

## Template for Your Team

Use this template to create your own Definition of Done:

```markdown
## Our Definition of Done

### Code
- [ ] _[Your code quality criteria]_
- [ ] _[Your standards]_

### Testing  
- [ ] _[Your test requirements]_
- [ ] _[Your coverage goals]_

### Review
- [ ] _[Your review process]_
- [ ] _[Your approval requirements]_

### Documentation
- [ ] _[Your documentation needs]_

### Deployment
- [ ] _[Your deployment criteria]_

### Acceptance
- [ ] _[Your acceptance process]_

Last Updated: _[Date]_
Reviewed By: _[Team members]_
```

## Benefits of Clear DoD

### For Developers
- Clear expectations
- Reduced ambiguity
- Quality pride
- Consistent standards

### For Product Owner
- Predictable quality
- Known completion criteria
- Confident in "done"
- Reduced rework

### For Organization
- Higher quality
- Reduced technical debt
- Faster delivery (less rework)
- Improved customer satisfaction

## Conclusion

The Definition of Done is a living agreement that evolves with the team. Start simple, be consistent, and improve over time. A clear DoD is essential for maintaining quality and velocity in Agile development.

---

**Created for**: Agile Software Development Portfolio  
**Context**: Sprint 1 Implementation  
**Status**: Active and in use by team
