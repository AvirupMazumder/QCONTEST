package com.crio.qcontest.commands;

import java.util.List;
import com.crio.qcontest.entities.Contestant;
import com.crio.qcontest.services.ContestService;

public class RunContestCommand implements ICommand {

    private ContestService contestService;

    public RunContestCommand(ContestService contestService) {
        this.contestService = contestService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        Long contestId = Long.parseLong(tokens.get(1));
        String contestCreator = tokens.get(2);
        List<Contestant> contestants = contestService.runContest(contestId, contestCreator);
        System.out.println(contestants);
    }
    
}
