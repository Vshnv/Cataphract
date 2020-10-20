package com.github.vshnv.cataphract.components;

import com.mojang.brigadier.builder.ArgumentBuilder;

import static com.mojang.brigadier.builder.LiteralArgumentBuilder.literal;

public class LiteralComponent extends CommandComponent {
    private LiteralComponent(String name) {
        super(name);
    }
    @Override
    public ArgumentBuilder asBrigadierComponent() {
        return literal(getName());
    }
}
