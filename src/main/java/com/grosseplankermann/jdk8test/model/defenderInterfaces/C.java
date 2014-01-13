package com.grosseplankermann.jdk8test.model.defenderInterfaces;


public interface C {
    default String someMethod(){
        return "C";
    }
}
