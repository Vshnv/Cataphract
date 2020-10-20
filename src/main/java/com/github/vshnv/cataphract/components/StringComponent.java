package com.github.vshnv.cataphract.components;

import com.mojang.brigadier.builder.ArgumentBuilder;

import static com.mojang.brigadier.arguments.StringArgumentType.greedyString;
import static com.mojang.brigadier.builder.RequiredArgumentBuilder.argument;

public class StringComponent extends CommandComponent {

    public StringComponent(String name) {
        super(name);
    }

    @Override
    public ArgumentBuilder asBrigadierComponent() {
        return argument(getName(), greedyString());
    }
}
