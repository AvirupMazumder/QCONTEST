package com.crio.qcontest.commands;

import java.util.List;
import com.crio.qcontest.entities.Level;
import com.crio.qcontest.entities.Question;
import com.crio.qcontest.services.QuestionService;

public class ListQuestionCommand implements ICommand {

    private QuestionService questionService;

    public ListQuestionCommand(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        if(tokens.size() == 1){

            List<Question> qList = questionService.getQuestions(null);
            System.out.println(qList);

        }else if(tokens.size() == 2){

            String level = tokens.get(1);
            List<Question> qList = questionService.getQuestions(Level.valueOf(level));
            System.out.println(qList);

        }
        
    }
    
}
