package com.crio.qcontest.commands;

import java.util.List;
import com.crio.qcontest.services.ContestService;

public class WithdrawContestCommand implements ICommand {

    private ContestService contestService;

    public WithdrawContestCommand(ContestService contestService) {
        this.contestService = contestService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        Long contestId = Long.parseLong(tokens.get(1));
        String userName = tokens.get(2);
        String message = contestService.deleteContestant(contestId, userName);
        System.out.println(message);        
    }
    
}
