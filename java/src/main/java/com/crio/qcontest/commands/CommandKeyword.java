package com.crio.qcontest.commands;

public enum CommandKeyword {
    CREATE_USER ("CREATE_USER"),
    CREATE_CONTEST("CREATE_CONTEST"),
    CREATE_QUESTION("CREATE_QUESTION"),
    ATTEND_CONTEST("ATTEND_CONTEST"),
    LIST_CONTEST("LIST_CONTEST"),
    LIST_QUESTION("LIST_QUESTION"),
    RUN_CONTEST("RUN_CONTEST"),
    WITHDRAW_CONTEST("WITHDRAW_CONTEST"),
    CONTEST_HISTORY("CONTEST_HISTORY"),
    SHOW_LEADERBOARD("LEADERBOARD");

    private String value;

    CommandKeyword(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
