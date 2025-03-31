
# Customer Issue Management System

Issue reasons
- transaction fail or remain in pending state
- Bank or NPCI issue/Internal phone pay error

Issue categories
- payment-related
- mutual fund-related
- gold-related
- insurance-related

Different CS have different expertise, waiting system if customer is busy
- customer log complaint
- search issue in the system with customerId or issueId
- Agent will change the status of the issue
- Issue assigning strategy 
- New agent is added
- Agent work history

Functionalities
- createIssue(transactionId, issueType, subject, description, email)
- addAgent(agentEmail, agentName ,List)
- assignIssue(issueId)
- getIssues(filter)
- updateIssue(issueId, status, resolution)
- resolveIssue(issueId, resolution)
- viewAgentsWorkHistory() 

Thinking from entity point of view
- User
- UserManager (responsible for search over users)
- Agent
- AgentManager (responsible for search over agent, also include agent availibility status)
- Issue 
- IssueManager (storing searching over the issue, agent assigning strategy)
- IssueTypeEnum
- IssueStatusEnum