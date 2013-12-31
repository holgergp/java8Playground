package com.grosseplankermann.jdk8test;

import static org.junit.Assert.assertEquals;


public class ChocolateCollectionsTest {
    @org.junit.Test
    public void testJdk7way() throws Exception {
        assertEquals(2,new ChocolateCollections().jdk7way() );
    }

    @org.junit.Test
    public void testJdk7wayWithAHintOfFunctions() throws Exception {
        assertEquals(2,new ChocolateCollections().jdk7wayWithAHintOfFunctions() );
    }

    @org.junit.Test
    public void testJdk8wayWithClosures() throws Exception {
        assertEquals(2,new ChocolateCollections().jdk8wayWithClosures() );
    }

    @org.junit.Test
    public void testJdk8wayWithAnonymousClassesAndStreamsAPI() throws Exception {
        assertEquals(2,new ChocolateCollections().jdk8wayWithAnonymousClassesAndStreamsAPI() );
    }

    @org.junit.Test
    public void testJdk8wayWithClosuresAndStreamsAPI() throws Exception {
        assertEquals(2,new ChocolateCollections().jdk8wayWithClosuresAndStreamsAPI() );
    }
}
