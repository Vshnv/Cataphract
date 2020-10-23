package com.github.vshnv.cataphract;

import com.github.vshnv.cataphract.handler.CommandHandler;

public class DummyCommand extends CommandHandler {
    @Permission("Player.canTest")
    @Syntax("myCommand <test/t/testing> [some_value] lol")
    @MessageHandlerId(1)
    public void executeMyCommand(String some_value) {
        System.out.println(some_value);
    }
}
