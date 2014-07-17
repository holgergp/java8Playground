package com.grosseplankermann.jdk8test;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ChocolateCollectionsTest {


    @Test
    public void simpleIteration() {
        new ChocolateCollections().simpleIteration(p -> System.out.println(p));
    }

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
    public void averageNumberOfPiecesJDK8() {
        assertEquals(15d, new ChocolateCollections().averageNumberOfPiecesForChocolateHeavierThan50GramsJDK8().getAsDouble(), 0);
    }

    @Test
    public void averageNumberOfPiecesJDK8Parallel() {
        assertEquals(15d, new ChocolateCollections().averageNumberOfPiecesForChocolateHeavierThan50GramsJDK8Parallel().getAsDouble(), 0);
    }

    @Test
    public void averageNumberOfPiecesJDK7() {
        assertEquals(15d, new ChocolateCollections().averageNumberOfPiecesForChocolateHeavierThan50GramsJDK7(), 0);
    }


}
