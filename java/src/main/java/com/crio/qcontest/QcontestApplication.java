package com.crio.qcontest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import com.crio.qcontest.appConfig.Configuration;
import com.crio.qcontest.commands.CommandRegistry;
import com.crio.qcontest.constants.UserOrder;
import com.crio.qcontest.entities.Contest;
import com.crio.qcontest.entities.Contestant;
import com.crio.qcontest.entities.Level;
import com.crio.qcontest.entities.Question;
import com.crio.qcontest.entities.User;
import com.crio.qcontest.repositories.ContestRepository;
import com.crio.qcontest.repositories.ContestantRepository;
import com.crio.qcontest.repositories.IContestRepository;
import com.crio.qcontest.repositories.IContestantRepository;
import com.crio.qcontest.repositories.IQuestionRepository;
import com.crio.qcontest.repositories.IUserRepository;
import com.crio.qcontest.repositories.QuestionRepository;
import com.crio.qcontest.repositories.UserRepository;
import com.crio.qcontest.services.ContestService;
import com.crio.qcontest.services.QuestionService;
import com.crio.qcontest.services.UserService;

public class QcontestApplication {

	public static void main(String[] args) {
        if (args.length != 1){
            throw new RuntimeException();
        }
        List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
        run(commandLineArgs);
    }

    public static void run(List<String> commandLineArgs){
		// Initialize repositories
        //Commented for implementing Command line design instead of Vanilla design
        /*
        IUserRepository userRepository = new UserRepository();
		IQuestionRepository questionRepository = new QuestionRepository();
        IContestRepository contestRepository = new ContestRepository();
        IContestantRepository contestantRepository = new ContestantRepository();
        

        // Initialize services
        UserService userService = new UserService(userRepository);
        QuestionService questionService = new QuestionService(questionRepository);
        ContestService contestService = new ContestService(contestantRepository, contestRepository, questionRepository, userRepository);
        */
        Configuration configuration = Configuration.getInstance();
        CommandRegistry commandRegistry = configuration.getCommandList();
        
        String inputFile = commandLineArgs.get(0).split("=")[1];

        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            while (true) {
                String line = reader.readLine();
                if (line == null){
                    break;
                }
                List<String> tokens = Arrays.asList(line.split(" "));
                commandRegistry.invokeCommand(tokens);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
