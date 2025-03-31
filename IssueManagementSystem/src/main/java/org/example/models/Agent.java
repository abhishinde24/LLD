package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
public class Agent {
    private String email;
    private String name;
    private Set<IssueType> expertise;

    public boolean isExpert(IssueType issueType) {
        return expertise.contains(issueType);
    }
}
