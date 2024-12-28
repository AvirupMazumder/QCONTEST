package com.crio.qcontest.commands;

import java.util.List;
import com.crio.qcontest.entities.Contestant;
import com.crio.qcontest.services.ContestService;

public class ContestHistoryCommand implements ICommand {

    private ContestService contestService;

    public ContestHistoryCommand(ContestService contestService) {
        this.contestService = contestService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        Long contestId = Long.parseLong(tokens.get(1));
        List<Contestant> contestants = contestService.contestHistory(contestId);
        System.out.println(contestants);        
    }
    
}
