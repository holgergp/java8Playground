package com.grosseplankermann.jdk8test.model.defenderInterfaces;


public interface A {
    default String someMethod(){
             return "A";
    }
}
