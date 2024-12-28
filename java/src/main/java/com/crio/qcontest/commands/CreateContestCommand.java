package com.crio.qcontest.commands;

import java.util.List;
import com.crio.qcontest.entities.Contest;
import com.crio.qcontest.entities.Level;
import com.crio.qcontest.services.ContestService;

public class CreateContestCommand implements ICommand {

    private ContestService contestService;

    public CreateContestCommand(ContestService contestService) {
        this.contestService = contestService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        String contestName = tokens.get(1);
        String level = tokens.get(2);
        String creatorName = tokens.get(3);
        Integer numQuestion = Integer.parseInt(tokens.get(4));
        Contest contest = contestService.createContest(contestName,Level.valueOf(level), creatorName,numQuestion);
        System.out.println(contest);
        
    }
    
}
