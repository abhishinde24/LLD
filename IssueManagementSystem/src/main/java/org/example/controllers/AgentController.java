package org.example.controllers;

import org.example.AgentSelectionStrategy;
import org.example.models.Agent;
import org.example.models.IssueType;

import java.util.HashMap;
import java.util.Map;

public class AgentController {
    private Map<String, Agent> agentMap;
    private AgentSelectionStrategy agentSelectionStrategy;

    public AgentController(AgentSelectionStrategy agentSelectionStrategy) {
        agentMap = new HashMap<>();
        this.agentSelectionStrategy = agentSelectionStrategy;
    }

    public void addAgent(Agent agent) {
        agentMap.put(agent.getEmail(), agentMap.getOrDefault(agent.getEmail(), agent));
    }

    public Agent getAgent(Agent agent) {
        if(agentMap.containsKey(agent.getEmail())) return null;

        return agentMap.get(agent.getEmail());
    }

    public Agent getAgent(IssueType issueType) {
        return agentSelectionStrategy.getAvailableAgent(agentMap, issueType);
    }
}
