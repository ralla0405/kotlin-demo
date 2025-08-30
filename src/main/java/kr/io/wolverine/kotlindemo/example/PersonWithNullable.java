package kr.io.wolverine.kotlindemo.example;

import org.jetbrains.annotations.Nullable;

public class PersonWithNullable {

    private final String name;

    public PersonWithNullable(String name) {
        this.name = name;
    }

    @Nullable
    public String getName() {
        return name;
    }
}
