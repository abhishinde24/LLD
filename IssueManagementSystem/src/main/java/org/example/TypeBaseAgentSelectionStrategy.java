package org.example;

import org.example.models.Agent;
import org.example.models.IssueType;

import java.util.Map;

public class TypeBaseAgentSelectionStrategy implements AgentSelectionStrategy{

    public Agent getAvailableAgent(Map<String, Agent> agents, IssueType issueType) {

        for(Agent agent : agents.values()) {
            if(agent.isExpert(issueType)) return agent;
        }

        return null;
    }
}
