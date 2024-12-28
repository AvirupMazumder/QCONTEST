package com.crio.qcontest.commands;

import java.util.*;

public interface ICommand {

    public void invoke(List<String> tokens);

}