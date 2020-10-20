package com.github.vshnv.cataphract.nodes;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AliasNode extends Node {
    private final List<String> aliases;

    public AliasNode(List<String> aliases) {
        this.aliases = aliases
                .stream()
                .map( it -> it.toLowerCase().replace(' ', '_') )
                .collect(Collectors.toList());
    }


    @Override
    public boolean matches(String input) {
        return aliases.contains(input.toLowerCase().replace(' ', '_'));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AliasNode aliasNode = (AliasNode) o;
        return Objects.equals(aliases, aliasNode.aliases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aliases);
    }
}
