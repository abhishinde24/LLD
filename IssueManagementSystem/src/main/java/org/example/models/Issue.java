package org.example.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.UUID;

@Getter
@Setter
public class Issue {
    private String id;
    private String transactionId;
    private User user;
    private IssueType issueType;
    private Agent agent;
    private String discription;
    private String subject;
    private IssueStatus issueStatus;
    private String resolution;

    private Issue(IssueBuilder issueBuilder) {
        this.id = issueBuilder.id;
        this.transactionId = issueBuilder.transactionId;
        this.user = issueBuilder.user;
        this.issueType = issueBuilder.issueType;
        this.agent = issueBuilder.agent;
        this.discription = issueBuilder.discription;
        this.subject = issueBuilder.subject;
        this.resolution = issueBuilder.resolution;
        this.issueStatus = IssueStatus.UNASSIGNED;
    }

    public void getAgent(Agent agent) {
        this.issueStatus = IssueStatus.ASSIGNED;
        this.agent = agent;
    }

    public static class IssueBuilder{
        private String id;
        private String transactionId;
        private User user;
        private IssueType issueType;
        private Agent agent;
        private String discription;
        private String subject;
        private String resolution;

        public IssueBuilder(String transactionId, User user, IssueType issueType) {
            this.id = UUID.randomUUID().toString();
            this.transactionId =  transactionId;
            this.user = user;
            this.issueType = issueType;
        }

        public IssueBuilder setAgent(Agent agent) {
            this.agent = agent;
            return this;
        }

        public IssueBuilder setDiscription(String discription) {
            this.discription = discription;
            return this;
        }

        public IssueBuilder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public IssueBuilder setResolution(String resolution) {
            this.resolution = resolution;
            return this;
        }

        public Issue build(){
            return new Issue(this);
        }
    }
}
