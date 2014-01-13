package com.grosseplankermann.jdk8test.model.defenderInterfaces;

public interface E extends F{
    default String someMethod(){
        return "E";

    }

}
