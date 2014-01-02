package com.grosseplankermann.jdk8test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ChocolateCollectionsTest {
    @Test
    public void testJdk7way() throws Exception {
        assertEquals(2,new ChocolateCollections().countHazelnutChocolateJdk7way() );
    }

    @Test
    public void testJdk7wayWithAHintOfFunctions() throws Exception {
        assertEquals(2,new ChocolateCollections().countHazelnutChocolateJdk7wayWithAHintOfFunctions() );
    }

    @Test
    public void testJdk8wayWithClosures() throws Exception {
        assertEquals(2,new ChocolateCollections().countHazelnutChocolateJdk8wayWithClosures() );
    }

    @Test
    public void testJdk8wayWithAnonymousClassesAndStreamsAPI() throws Exception {
        assertEquals(2,new ChocolateCollections().countHazelnutChocolateJdk8wayWithAnonymousClassesAndStreamsAPI() );
    }

    @Test
    public void testJdk8wayWithClosuresAndStreamsAPI() throws Exception {
        assertEquals(2,new ChocolateCollections().countHazelnutChocolateJdk8wayWithClosuresAndStreamsAPI() );
    }
}
