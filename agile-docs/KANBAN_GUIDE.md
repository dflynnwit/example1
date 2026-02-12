# Kanban Guide

## Overview
Kanban is a visual workflow management method that helps teams manage work in progress and optimize flow. Unlike Scrum's time-boxed sprints, Kanban is a continuous flow system.

## Core Principles

### 1. Visualize Work
Make work visible on a Kanban board to see:
- What's being worked on
- Where bottlenecks exist
- Overall system state

### 2. Limit Work in Progress (WIP)
Constrain how many items can be in progress at once to:
- Reduce context switching
- Identify bottlenecks faster
- Improve flow and delivery time
- Focus on finishing work rather than starting new work

### 3. Manage Flow
Optimize the flow of work through the system:
- Monitor lead time and cycle time
- Identify and remove blockers
- Balance workload across the team

### 4. Make Process Policies Explicit
Clear rules about how work moves through the system:
- Definition of what each column means
- When work can move between columns
- Who can move work

### 5. Implement Feedback Loops
Regular reviews to improve the system:
- Daily standups
- Replenishment meetings
- Delivery planning
- Retrospectives

### 6. Improve Collaboratively
Evolve the system based on data and feedback:
- Use metrics to guide improvements
- Experiment with changes
- Involve the whole team

## Kanban Board Structure

### Basic Board
```
┌─────────────┬─────────────┬─────────────┬─────────────┐
│   Backlog   │     To Do   │ In Progress │     Done    │
│             │    (WIP:5)  │   (WIP:3)   │             │
├─────────────┼─────────────┼─────────────┼─────────────┤
│  [Item 8]   │  [Item 5]   │  [Item 2]   │  [Item 1]   │
│  [Item 9]   │  [Item 6]   │  [Item 3]   │  [Item 4]   │
│  [Item 10]  │  [Item 7]   │  [Item 11]  │             │
│             │             │             │             │
└─────────────┴─────────────┴─────────────┴─────────────┘
```

### Advanced Board
```
┌─────────┬──────────┬──────────────────────────┬────────┬────────┐
│ Backlog │ Selected │   Development (WIP:4)    │ Testing│  Done  │
│         │          ├────────┬─────────────────┤(WIP:2) │        │
│         │          │ Doing  │ Code Review     │        │        │
│         │          │(WIP:2) │    (WIP:2)      │        │        │
├─────────┼──────────┼────────┼─────────────────┼────────┼────────┤
│[Item 10]│ [Item 5] │[Item 2]│    [Item 3]     │[Item 7]│[Item 1]│
│[Item 11]│ [Item 6] │[Item 8]│    [Item 9]     │        │[Item 4]│
│         │          │        │                 │        │        │
└─────────┴──────────┴────────┴─────────────────┴────────┴────────┘
```

## Work in Progress (WIP) Limits

### Why WIP Limits Matter
- **Focus**: Team concentrates on finishing work
- **Flow**: Work moves through system faster
- **Quality**: More attention to each item
- **Bottleneck Detection**: WIP limits make constraints visible

### Setting WIP Limits

#### Rule of Thumb
Start with: Number of team members + 1 for the "In Progress" column

**Example**: 
- 3 developers → WIP limit of 4 for "In Progress"

#### By Column
```
Backlog: Unlimited
Selected: 2x sprint capacity
To Do: 5-7 items
In Progress: 3 items
Code Review: 2 items
Testing: 2 items
Done: Unlimited (cleared regularly)
```

### Enforcing WIP Limits
- **Hard Limit**: Cannot exceed under any circumstances
- **Soft Limit**: Can temporarily exceed with team agreement
- **Visual Indicators**: Red flag when limit exceeded

## Kanban Metrics

### 1. Lead Time
**Definition**: Time from work request to delivery

**Example**: 
- Item added to backlog: Jan 1
- Item delivered: Jan 15
- Lead Time: 14 days

**Goal**: Reduce lead time by improving process

### 2. Cycle Time
**Definition**: Time from work start to completion

**Example**:
- Development started: Jan 3
- Item delivered: Jan 15
- Cycle Time: 12 days

**Goal**: Predictable, consistent cycle time

### 3. Throughput
**Definition**: Number of items completed per time period

**Example**: 
- Week 1: 8 items completed
- Week 2: 10 items completed
- Average throughput: 9 items/week

**Goal**: Increase throughput without sacrificing quality

### 4. Cumulative Flow Diagram (CFD)
Visual representation showing:
- Work in each stage over time
- Bottlenecks (bulges in specific areas)
- Overall system health

## Kanban Ceremonies

### Daily Standup (15 min)
**Focus**: Walk the board from right to left
- **Right to Left**: Focus on completing work before starting new work
- Discuss: Blockers, aging items, approaching WIP limits

### Replenishment Meeting (30-60 min)
**Frequency**: As needed (when backlog low)
**Purpose**: Add new work to the board
**Participants**: Team + stakeholders
**Activities**:
- Review capacity
- Prioritize backlog items
- Pull items onto board

### Delivery Planning (30-60 min)
**Frequency**: Weekly or bi-weekly
**Purpose**: Plan upcoming deliveries
**Activities**:
- Review forecasts
- Commit to deliveries
- Coordinate with stakeholders

### Retrospective (60-90 min)
**Frequency**: Monthly or every 2 weeks
**Purpose**: Improve the process
**Activities**:
- Review metrics
- Discuss problems
- Experiment with solutions

## Classes of Service

### 1. Expedite (Critical)
- **WIP Limit**: 1
- **Example**: Production outage, critical bug
- **Policy**: Stops all other work

### 2. Fixed Date
- **Example**: Release deadline, demo date
- **Policy**: Must be completed by specific date

### 3. Standard
- **Example**: Regular features, improvements
- **Policy**: Normal flow through system

### 4. Intangible
- **Example**: Research, learning, technical debt
- **Policy**: Allocate % of capacity (e.g., 20%)

## Pull System vs Push System

### Pull System (Kanban)
- Work is "pulled" when capacity available
- Team decides when to start new work
- Respects WIP limits
- More sustainable pace

### Push System (Traditional)
- Work is "pushed" to team
- External forces decide timing
- Can lead to overload
- Variable quality

## Kanban vs Scrum Comparison

| Aspect | Kanban | Scrum |
|--------|--------|-------|
| **Cadence** | Continuous flow | Fixed sprints |
| **Roles** | No prescribed roles | PO, SM, Dev Team |
| **Changes** | Anytime | Between sprints |
| **Commitment** | Per item | Per sprint |
| **Metrics** | Lead/cycle time | Velocity |
| **Board** | Persistent | Reset each sprint |
| **WIP** | Limited | Sprint capacity |
| **Best For** | Operational work, support | Product development |

## Example Kanban Board Policies

### "To Do" Column
- **Entry Criteria**: Item prioritized and refined
- **WIP Limit**: 5
- **Exit Criteria**: Developer has capacity and selects item

### "In Progress" Column  
- **Entry Criteria**: Developer actively working on item
- **WIP Limit**: 3
- **Exit Criteria**: Code complete and pushed for review

### "Code Review" Column
- **Entry Criteria**: PR created and reviewers assigned
- **WIP Limit**: 2
- **Exit Criteria**: PR approved by 2 reviewers

### "Testing" Column
- **Entry Criteria**: PR merged, deployed to test environment
- **WIP Limit**: 2
- **Exit Criteria**: All tests pass, acceptance criteria met

### "Done" Column
- **Entry Criteria**: Deployed to production, stakeholder approved
- **Exit Criteria**: None (cleared weekly)

## Common Patterns

### Blocker Flags
- **Red sticker**: Blocked, needs attention
- **Yellow sticker**: Aging (in column >3 days)
- **Blue sticker**: Waiting for external input

### Swimlanes
Horizontal divisions for different types of work:
- **Lane 1**: Features
- **Lane 2**: Bugs
- **Lane 3**: Technical debt
- **Lane 4**: Expedite

### Aging Items
- Items get visual indicator after specific time
- Draws attention to stuck work
- Prompts discussion and action

## Tools for Kanban

### Physical Boards
- **Pros**: Visible, tactile, easy collaboration
- **Cons**: Not suitable for remote teams
- **Best For**: Co-located teams

### Digital Tools
- **Trello**: Simple, visual, free tier
- **Jira**: Powerful, enterprise features
- **Azure DevOps**: Integrated with development tools
- **Monday.com**: Flexible, good visualizations
- **GitHub Projects**: Integrated with code repositories

## Anti-Patterns to Avoid

### 1. Ignoring WIP Limits
**Problem**: Board becomes cluttered, flow slows
**Solution**: Enforce limits strictly, discuss exceptions

### 2. Not Walking the Board
**Problem**: Miss opportunities to collaborate
**Solution**: Walk board right-to-left in standups

### 3. Hidden Work
**Problem**: Work not on board, can't be managed
**Solution**: All work visible, including support tasks

### 4. Stale "Done" Column
**Problem**: Loses meaning as signal of completion
**Solution**: Archive done items regularly (weekly)

### 5. No Policies
**Problem**: Confusion about how board works
**Solution**: Document and share column policies

## Getting Started with Kanban

### Step 1: Map Current Process
- Document current workflow
- Identify handoffs and stages
- Note where work waits

### Step 2: Create Initial Board
- Keep it simple (4-5 columns)
- Match current process
- Add WIP limits

### Step 3: Start Flowing Work
- Populate with current work
- Begin using board daily
- Observe bottlenecks

### Step 4: Measure and Improve
- Track lead/cycle time
- Identify constraints
- Experiment with improvements

### Step 5: Evolve
- Adjust WIP limits based on data
- Add/remove columns as needed
- Refine policies

## Case Study Example

### Initial State
- **Team**: 4 developers, 1 QA
- **Problem**: Long lead times, unpredictable delivery
- **Board**: To Do → In Progress → Done
- **No WIP limits**

### After 3 Months
- **Board**: Backlog → Selected → Dev (WIP:3) → Review (WIP:2) → Test (WIP:2) → Done
- **Lead Time**: Reduced from 18 days to 9 days
- **Throughput**: Increased from 12 to 20 items/month
- **Predictability**: Within 10% of forecast

### Key Changes
1. Added WIP limits
2. Split "In Progress" into stages
3. Added daily board walks
4. Tracked metrics weekly
5. Monthly retrospectives

## Resources
- **Book**: "Kanban" by David J. Anderson
- **Book**: "Kanban from the Inside" by Mike Burrows  
- **Online**: Kanban University (https://kanban.university)
- **Tool**: Personal Kanban (https://personalkanban.com)
