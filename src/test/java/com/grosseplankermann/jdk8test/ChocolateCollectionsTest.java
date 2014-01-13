package com.grosseplankermann.jdk8test;


import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ChocolateCollectionsTest {
    @Test
    public void countHazelnutChocolateJdk7way() throws Exception {
        assertEquals(2, new ChocolateCollections().countHazelnutChocolateJdk7way());
    }

    @Test
    public void countHazelnutChocolateJdk7wayWithAHintOfFunctions() throws Exception {
        assertEquals(2, new ChocolateCollections().countHazelnutChocolateJdk7wayWithAHintOfFunctions());
    }

    @Test
    public void countHazelnutChocolateJdk8wayWithClosures() throws Exception {
        assertEquals(2, new ChocolateCollections().countHazelnutChocolateJdk8wayWithClosures());
    }

    @Test
    public void countHazelnutChocolateJdk8wayWithAnonymousClassesAndStreamsAPI() throws Exception {
        assertEquals(2, new ChocolateCollections().countHazelnutChocolateJdk8wayWithAnonymousClassesAndStreamsAPI());
    }

    @Test
    public void countHazelnutChocolateJdk8wayWithClosuresAndStreamsAPI() throws Exception {
        assertEquals(2, new ChocolateCollections().countHazelnutChocolateJdk8wayWithClosuresAndStreamsAPI());
    }

    @Test
    public void treatCodeAsData() {
        new ChocolateCollections().treatingCodeAsData(p -> System.out.println(p));
    }

    @Test
    public void averageNumberOfPiecesJDK8() {
        assertEquals(15d, new ChocolateCollections().averageNumberOfPiecesForChocolateHeavierThan50GramsJDK8().getAsDouble(), 0);
    }

    @Test
    public void averageNumberOfPiecesJDK7() {
        assertEquals(15d, new ChocolateCollections().averageNumberOfPiecesForChocolateHeavierThan50GramsJDK7(), 0);
    }


    @Test
    public void customFunctionalInterface() {
        assertEquals("Lambdas rock", new ChocolateCollections().consumeCustomFunctionalInterface(
                () -> "Lambdas " + "rock"
        ));
    }

    @Test
    public void predefinedFunctionalInterface() {


        String[] lambdaList = {"rock", "suck", "are green"};

        assertEquals(StringUtils.countMatches(
                new ChocolateCollections().consumeFunction(
                p -> "Lambdas " + p + " ", lambdaList), "Lambdas")

                , 3);


    }
}
