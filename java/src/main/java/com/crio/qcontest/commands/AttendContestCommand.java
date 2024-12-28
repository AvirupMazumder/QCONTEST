package com.crio.qcontest.commands;

import java.util.List;
import com.crio.qcontest.entities.Contestant;
import com.crio.qcontest.services.ContestService;

public class AttendContestCommand implements ICommand {

    private ContestService contestService;

    public AttendContestCommand(ContestService contestService) {
        this.contestService = contestService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        Long contestId = Long.parseLong(tokens.get(1));
        String userName = tokens.get(2);
        Contestant contestant = contestService.createContestant(contestId, userName);
        System.out.println(contestant); 
    }
    
}
