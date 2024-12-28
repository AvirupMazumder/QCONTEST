package com.crio.qcontest.commands;

import java.util.List;
import com.crio.qcontest.constants.UserOrder;
import com.crio.qcontest.entities.User;
import com.crio.qcontest.services.UserService;

public class ShowLeaderboardCommand implements ICommand {

    private UserService userService;

    public ShowLeaderboardCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        String order = tokens.get(1);
        List<User> uList = userService.getUsers(UserOrder.valueOf("SCORE_"+order));
        System.out.print("[");
        for(int  i=0; i < uList.size(); i++){
            if(i == (uList.size()-1)){
                System.out.print("User [id=" + uList.get(i).getId() + ", totalScore=" + uList.get(i).getTotalScore() + "]"); 
            }else{
                System.out.print("User [id=" + uList.get(i).getId() + ", totalScore=" + uList.get(i).getTotalScore() + "], ");
            }
        }
        System.out.print("]");
    }
    
}
