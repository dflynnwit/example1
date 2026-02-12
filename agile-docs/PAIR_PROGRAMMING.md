# Pair Programming Guidelines

## Overview
Pair programming is an Agile practice where two developers work together at one workstation. One writes code (the Driver) while the other reviews each line (the Navigator). The roles switch frequently.

## Roles

### Driver
- **Responsibility**: Write the code
- **Focus**: Implementation details, syntax, typing
- **Activities**:
  - Types the code
  - Thinks about current line/block
  - Asks for input when stuck
  - Explains thought process

### Navigator
- **Responsibility**: Review and guide
- **Focus**: Big picture, design, edge cases
- **Activities**:
  - Reviews code as it's written
  - Thinks ahead about next steps
  - Spots potential issues
  - Suggests improvements
  - Looks up documentation
  - Takes notes

## Best Practices

### 1. Switch Roles Regularly
- **Frequency**: Every 15-25 minutes
- **Method**: Use a timer or natural breakpoints
- **Why**: Prevents fatigue, keeps both engaged

### 2. Communication
- **Driver should**:
  - Verbalize their thinking
  - Ask for help when needed
  - Be open to suggestions
  
- **Navigator should**:
  - Wait for good moments to interrupt
  - Ask questions rather than give commands
  - Be patient and supportive

### 3. Setup
- **Physical Pairing**:
  - Two monitors side-by-side
  - Two keyboards and mice
  - Comfortable seating for both
  - Easy switching between roles

- **Remote Pairing**:
  - Screen sharing (VS Code Live Share, Tuple, etc.)
  - Good audio connection (headsets recommended)
  - Video enabled when possible
  - Reliable internet connection

### 4. When to Pair Program

#### Excellent for:
- Complex algorithms or business logic
- Learning new technologies or codebases
- Critical features or bug fixes
- Design discussions and refactoring
- Onboarding new team members
- Code that needs deep focus

#### Not necessary for:
- Simple, well-understood tasks
- Routine maintenance
- Individual research/learning
- Writing documentation
- Administrative tasks

### 5. Pair Programming Styles

#### Driver-Navigator (Classic)
- One drives, one navigates
- Switch every 15-25 minutes
- Good for: General development

#### Ping Pong
- Navigator writes failing test
- Driver makes it pass
- Switch roles
- Good for: TDD, learning

#### Strong Style
- Navigator instructs, driver follows
- "For an idea to go from your head to the computer, it must go through someone else's hands"
- Good for: Knowledge transfer, mentoring

#### Mob Programming
- Multiple people (3+)
- One driver, multiple navigators
- Rotate driver every 10-15 minutes
- Good for: Complex problems, team alignment

## Example Pairing Session

### Setup (5 minutes)
1. Review the user story together
2. Discuss approach
3. Set up environment
4. Start timer

### First Rotation (20 minutes)
**Driver**: Alice  
**Navigator**: Bob

- Alice types, implementing the first test
- Bob reviews, suggests edge cases
- Discuss approach as code is written
- Test turns green

### Switch (1 minute)
- Bob takes keyboard
- Alice moves to navigator role
- Reset timer

### Second Rotation (20 minutes)
**Driver**: Bob  
**Navigator**: Alice

- Bob implements next feature
- Alice reviews for potential issues
- Find a bug together and fix it
- Refactor for clarity

### Break (5 minutes)
- Step away from computer
- Stretch, get water
- Casual conversation

### Continue...

## Communication Tips

### Good Phrases
- "What if we tried...?"
- "I'm thinking we should..."
- "Can you explain why...?"
- "Let me try something..."
- "I'm not sure about this part..."

### Avoid
- "That's wrong" (say: "I see an issue here...")
- "No, do it this way" (say: "What about trying...")
- "You're not listening" (take a break)
- Silence (communicate!)

## Common Challenges and Solutions

### Challenge: Skill Level Difference
**Solution**: 
- More experienced dev navigates more often
- Focus on knowledge transfer
- Be patient and explain reasoning
- Less experienced dev drives more (learns by doing)

### Challenge: Personality Conflicts
**Solution**:
- Establish ground rules at start
- Take breaks when tension rises
- Focus on the code, not the person
- Try different pairing partners

### Challenge: Going Too Fast
**Solution**:
- Navigator: "Can you slow down?"
- Driver: Check in frequently
- Take time to explain thinking
- Remember: collaboration > speed

### Challenge: One Person Dominates
**Solution**:
- Strict timer for switching
- Navigator limit to questions/suggestions
- Both must contribute
- Try different pairing style

### Challenge: Fatigue
**Solution**:
- Regular breaks (every hour)
- Pair for 4-6 hours max per day
- Mix pairing with solo work
- Know when to work independently

## Benefits of Pair Programming

### Code Quality
- Fewer bugs (caught in real-time)
- Better design decisions
- More consistent code style
- Improved readability

### Knowledge Sharing
- Team members learn from each other
- Knowledge spread across team
- No single point of failure
- Faster onboarding

### Focus
- Less distraction
- Stay on task
- Continuous code review
- Faster problem solving

### Team Building
- Improved communication
- Stronger relationships
- Shared ownership
- Better collaboration

## Metrics

### How to Measure Success
- **Defect Rate**: Should decrease
- **Code Review Time**: Reduced (continuous review)
- **Team Knowledge**: Increased (measured by surveys)
- **Team Satisfaction**: Higher collaboration scores

### Warning Signs
- One person always driving/navigating
- Long periods of silence
- Frustration or tension
- One person checked out (phone, email)
- Skipping breaks or switches

## Remote Pairing Tools

### Code Sharing
- **VS Code Live Share**: Integrated editor sharing
- **Tuple**: Designed for pair programming
- **GitHub Codespaces**: Cloud development environment
- **Replit**: Collaborative online IDE

### Communication
- **Zoom**: Video conferencing
- **Discord**: Good audio, screen sharing
- **Slack Huddles**: Quick pair sessions
- **Microsoft Teams**: Enterprise option

### Utilities
- **Pomodoro timers**: Track rotation time
- **Shared notes**: Google Docs, Notion
- **Virtual whiteboard**: Miro, Excalidraw

## Integration with Scrum

### Daily Standup
- Mention pair programming sessions
- "Bob and I paired on the login feature"
- Share learnings

### Sprint Planning
- Consider pairing for complex stories
- Estimate with pairing in mind
- Assign pairs during planning

### Sprint Review
- Demo work done in pairs
- Explain collaboration benefits
- Show code quality improvements

### Retrospective
- Discuss pairing effectiveness
- Identify improvements
- Celebrate successful pairs

## Getting Started

### Week 1: Introduction
- Pair for 1-2 hours per day
- Start with simple tasks
- Focus on communication
- Gather feedback

### Week 2-3: Building Habits
- Increase to 3-4 hours per day
- Try different pairing styles
- Rotate partners
- Refine process

### Week 4+: Mature Practice
- Pair on complex work
- Mix pairing with solo work
- Continue improving
- Track benefits

## Example Schedule

### Monday
- 9:00-10:30: Pair on new feature (Alice & Bob)
- 10:30-12:00: Solo work
- 1:00-3:00: Pair on bug fixes (Alice & Carol)
- 3:00-5:00: Solo work

### Pattern
- 40-50% of time pairing
- 50-60% solo work
- Mix partners
- Balance complex and simple work

## Resources
- **Book**: "Pair Programming Illuminated" - Laurie Williams & Robert Kessler
- **Article**: "On Pair Programming" - Martin Fowler
- **Video**: "Mob Programming" - Woody Zuill
- **Practice**: Code katas (codewars.com, exercism.io)

## Conclusion
Pair programming is a powerful Agile practice that improves code quality, spreads knowledge, and strengthens teams. Like any skill, it requires practice and refinement. Start small, communicate openly, and iterate on your approach.
