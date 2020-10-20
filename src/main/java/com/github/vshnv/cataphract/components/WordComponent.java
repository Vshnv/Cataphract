package com.github.vshnv.cataphract.components;

import com.mojang.brigadier.builder.ArgumentBuilder;

import static com.mojang.brigadier.arguments.StringArgumentType.word;
import static com.mojang.brigadier.builder.RequiredArgumentBuilder.argument;

public class WordComponent extends CommandComponent {
    public WordComponent(String name) {
        super(name);
    }

    @Override
    public ArgumentBuilder asBrigadierComponent() {
        return argument(getName(), word());
    }
}
