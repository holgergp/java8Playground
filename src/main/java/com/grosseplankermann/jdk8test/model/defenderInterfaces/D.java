package com.grosseplankermann.jdk8test.model.defenderInterfaces;


public interface D extends F{
    default String someMethod(){
        return "D";
    }
}
