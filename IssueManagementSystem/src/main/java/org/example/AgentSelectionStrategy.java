package org.example;

import org.example.models.Agent;
import org.example.models.IssueType;

import java.util.List;
import java.util.Map;

public interface AgentSelectionStrategy {
    public Agent getAvailableAgent(Map<String, Agent> agentList, IssueType issueType);
}
