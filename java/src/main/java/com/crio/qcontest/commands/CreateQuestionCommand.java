package com.crio.qcontest.commands;

import java.util.List;
import com.crio.qcontest.entities.Level;
import com.crio.qcontest.entities.Question;
import com.crio.qcontest.services.QuestionService;

public class CreateQuestionCommand implements ICommand {

    private QuestionService questionService;

    public CreateQuestionCommand(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // TODO Auto-generated method stub
        String title = tokens.get(1);
        String level = tokens.get(2);
        Integer score = Integer.parseInt(tokens.get(3));
        Question question = questionService.createQuestion(title, Level.valueOf(level),score);
        System.out.println(question);
    }
    
}
