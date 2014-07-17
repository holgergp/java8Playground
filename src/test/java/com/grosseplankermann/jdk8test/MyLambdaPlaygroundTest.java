package com.grosseplankermann.jdk8test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyLambdaPlaygroundTest {



    @Test
    public void echoString() {
        assertEquals("Ping", new MyLambdaPlayground().jdk8UnaryOperatorExample(echoString -> echoString, "Ping"));
    }

    @Test
    public void customFunctionalInterface() {
        assertEquals("Lambdas rock", new MyLambdaPlayground().consumeCustomFunctionalInterface(
                () -> "Lambdas " + "rock"
        ));
    }

    @Test
    public void predefinedFunctionalInterface() {


        String[] lambdaList = {"rock", "suck", "are green"};

        assertEquals(StringUtils.countMatches(
                new MyLambdaPlayground().appendStringsInStringArrayWithFunction(
                        p -> "Lambdas " + p + " ", lambdaList)

                , "Lambdas")

                , 3);


    }



}