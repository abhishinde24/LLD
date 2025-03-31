package org.example.controllers;

import org.example.models.Agent;
import org.example.models.Issue;
import org.example.models.IssueStatus;
import org.example.models.IssueType;

import java.util.Map;
import java.util.HashMap;

public class IssueController {
    private Map<String, Issue> issues;
    private AgentController agentController;

    public IssueController(AgentController agentController) {
        issues = new HashMap<>();
        this.agentController = agentController;
    }

    public void addIssue(Issue issue) {
        Agent agent = agentController.getAgent(issue.getIssueType());
        issue.setAgent(agent);
        issues.put(issue.getId(), issues.getOrDefault(issue.getId(), issue));
    }

    public Issue getIssue(String id) {
        if(!issues.containsKey(id)) return null;

        return issues.get(id);
    }

    public void resolveIssue(String issueId, String resolution) {
        Issue issue = getIssue(issueId);
        issue.setIssueStatus(IssueStatus.RESOLVED);
        issue.setResolution(resolution);
    }

    public void updateIssue(String issueId, IssueStatus issueStatus, String resolution) {
        Issue issue = getIssue(issueId);
        issue.setIssueStatus(issueStatus);
        issue.setResolution(resolution);
    }
}
