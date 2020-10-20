package com.github.vshnv.cataphract.components;

import com.mojang.brigadier.builder.ArgumentBuilder;

public abstract class CommandComponent {
    private final String name;

    public CommandComponent(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public abstract ArgumentBuilder asBrigadierComponent();
}
