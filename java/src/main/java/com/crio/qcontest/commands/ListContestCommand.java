package com.crio.qcontest.commands;

import java.util.List;
import com.crio.qcontest.entities.Contest;
import com.crio.qcontest.entities.Level;
import com.crio.qcontest.services.ContestService;

public class ListContestCommand implements ICommand {

    private ContestService contestService;

    public ListContestCommand(ContestService contestService) {
        this.contestService = contestService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        if(tokens.size() == 1){

            List<Contest> qList = contestService.getContests(null);
            System.out.println(qList);

        }else if(tokens.size() == 2){

            String level = tokens.get(1);
            List<Contest> qList = contestService.getContests(Level.valueOf(level));
            System.out.println(qList);
            
        }
    }
    
}
