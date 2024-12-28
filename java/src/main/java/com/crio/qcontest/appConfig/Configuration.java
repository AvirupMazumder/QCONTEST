package com.crio.qcontest.appConfig;

import java.util.List;
import com.crio.qcontest.commands.AttendContestCommand;
import com.crio.qcontest.commands.CommandRegistry;
import com.crio.qcontest.commands.ContestHistoryCommand;
import com.crio.qcontest.commands.CreateContestCommand;
import com.crio.qcontest.commands.CreateQuestionCommand;
import com.crio.qcontest.commands.CreateUserCommand;
import com.crio.qcontest.commands.ICommand;
import com.crio.qcontest.commands.CommandKeyword;
import com.crio.qcontest.commands.ListContestCommand;
import com.crio.qcontest.commands.ListQuestionCommand;
import com.crio.qcontest.commands.RunContestCommand;
import com.crio.qcontest.commands.ShowLeaderboardCommand;
import com.crio.qcontest.commands.WithdrawContestCommand;
import com.crio.qcontest.repositories.ContestRepository;
import com.crio.qcontest.repositories.ContestantRepository;
import com.crio.qcontest.repositories.QuestionRepository;
import com.crio.qcontest.repositories.UserRepository;
import com.crio.qcontest.services.ContestService;
import com.crio.qcontest.services.QuestionService;
import com.crio.qcontest.services.UserService;

public class Configuration {

    private static volatile Configuration configuration;

    private Configuration() {}

    public static Configuration getInstance() {

        if(configuration == null) {

            synchronized(Configuration.class) {
                if(configuration == null) {
                    configuration = new Configuration();
                }
            }
        }
        return configuration;
    }

    private final ContestRepository contestRepository = new ContestRepository();
    private final UserRepository userRepository = new UserRepository();
    private final QuestionRepository questionRepository = new QuestionRepository();
    private final ContestantRepository contestantRepository = new ContestantRepository();

    private final UserService userService = new UserService(userRepository);
    private final QuestionService questionService = new QuestionService(questionRepository);
    private final ContestService contestService = new ContestService(contestantRepository, contestRepository, questionRepository, userRepository);

    private final CreateUserCommand createUserCommand = new CreateUserCommand(userService);
    private final CreateContestCommand createContestCommand = new CreateContestCommand(contestService);
    private final CreateQuestionCommand createQuestionCommand = new CreateQuestionCommand(questionService);
    private final AttendContestCommand attendContestCommand = new AttendContestCommand(contestService);
    private final ContestHistoryCommand contestHistoryCommand = new ContestHistoryCommand(contestService);
    private final ListContestCommand listContestCommand = new ListContestCommand(contestService);
    private final ListQuestionCommand listQuestionCommand = new ListQuestionCommand(questionService);
    private final RunContestCommand runContestCommand = new RunContestCommand(contestService);
    private final WithdrawContestCommand withdrawContestCommand = new WithdrawContestCommand(contestService);
    private final ShowLeaderboardCommand showLeaderboardCommand = new ShowLeaderboardCommand(userService);

    private CommandRegistry commandRegistry = new CommandRegistry();

    public void registerCommands() {
        commandRegistry.register(CommandKeyword.CREATE_USER.getValue(),createUserCommand);
        commandRegistry.register(CommandKeyword.CREATE_QUESTION.getValue(), createQuestionCommand);
        commandRegistry.register(CommandKeyword.CREATE_CONTEST.getValue(), createContestCommand);
        commandRegistry.register(CommandKeyword.ATTEND_CONTEST.getValue(), attendContestCommand);
        commandRegistry.register(CommandKeyword.LIST_CONTEST.getValue(), listContestCommand);
        commandRegistry.register(CommandKeyword.LIST_QUESTION.getValue(), listQuestionCommand);
        commandRegistry.register(CommandKeyword.RUN_CONTEST.getValue(), runContestCommand);
        commandRegistry.register(CommandKeyword.WITHDRAW_CONTEST.getValue(), withdrawContestCommand);
        commandRegistry.register(CommandKeyword.CONTEST_HISTORY.getValue(), contestHistoryCommand);
        commandRegistry.register(CommandKeyword.SHOW_LEADERBOARD.getValue(), showLeaderboardCommand);
    }

    public CommandRegistry getCommandList() {
        registerCommands();
        return commandRegistry;
    }

    
}
