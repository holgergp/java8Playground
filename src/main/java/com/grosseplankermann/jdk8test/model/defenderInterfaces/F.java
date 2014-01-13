package com.grosseplankermann.jdk8test.model.defenderInterfaces;


public interface F {
    default String someMethod(){
        return "F";
    }
}
