package com.grosseplankermann.jdk8test.model.defenderInterfaces;


public class ABC implements A,B{
   public String someMethod(){
        return A.super.someMethod();
    }
}
