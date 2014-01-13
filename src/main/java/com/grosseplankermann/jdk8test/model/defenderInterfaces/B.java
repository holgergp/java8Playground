package com.grosseplankermann.jdk8test.model.defenderInterfaces;


public interface B {
    default String someMethod(){
        return "B";
    }
}
