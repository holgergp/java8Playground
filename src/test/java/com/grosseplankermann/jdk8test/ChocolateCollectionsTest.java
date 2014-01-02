package com.grosseplankermann.jdk8test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


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
}
