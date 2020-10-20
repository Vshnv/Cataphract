package com.github.vshnv.cataphract;

import com.google.common.collect.HashMultimap;
import com.mojang.brigadier.CommandDispatcher;


import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.server.v1_14_R1.Material;
import net.minecraft.server.v1_14_R1.MinecraftServer;
import org.bukkit.craftbukkit.libs.it.unimi.dsi.fastutil.Hash;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static com.mojang.brigadier.arguments.StringArgumentType.word;
import static com.mojang.brigadier.builder.LiteralArgumentBuilder.literal;
import static com.mojang.brigadier.builder.RequiredArgumentBuilder.argument;
import static org.bukkit.Bukkit.getServer;


public final class Cataphract {


    public void onEnable() {

        CommandDispatcher dispatcher = ((MinecraftServer) getServer()).getCommandDispatcher().a();
        ArgumentBuilder ab = argument("player", word()).executes(a->7);
        LiteralArgumentBuilder liter = literal("town");


    }



}
