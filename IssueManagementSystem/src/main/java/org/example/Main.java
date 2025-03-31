package org.example;

import org.example.controllers.AgentController;
import org.example.controllers.IssueController;
import org.example.models.*;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("abhishek@gmail.com");
        User user2 = new User("ankit@gmail.com");

        Agent agent1 = new Agent("CS1@gmail.com", "Agent1", Set.of(IssueType.GOLD_RELATED, IssueType.INSURANCE_RELATED));
        Agent agent2 = new Agent("CS2@gmail.com", "Agent2", Set.of(IssueType.MUTUAL_FUND_RELATED, IssueType.INSURANCE_RELATED));

        AgentController agentController = new AgentController(new TypeBaseAgentSelectionStrategy());
        agentController.addAgent(agent1);
        agentController.addAgent(agent2);


        Issue issue1 = new Issue.IssueBuilder("T1", user1, IssueType.INSURANCE_RELATED)
                .setSubject("Insurance buy fail")
                .build();

        Issue issue2 = new Issue.IssueBuilder("T1", user2, IssueType.GOLD_RELATED)
                .setSubject("gold buy fail")
                .build();

        IssueController issueController = new IssueController(agentController);
        issueController.addIssue(issue1);
        issueController.addIssue(issue2);

        System.out.println("issue1 detail agent details " + issueController.getIssue(issue1.getId()).getAgent().getName());
        System.out.println("issue2 detail agent details " + issueController.getIssue(issue1.getId()).getAgent().getName());

        issueController.updateIssue(issue1.getId(), IssueStatus.PROCESS, "Resolution in process");
        issueController.resolveIssue(issue2.getId(),"Resolution by CS");

    }
}