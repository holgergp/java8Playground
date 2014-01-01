package com.grosseplankermann.jdk8test;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ChocolateCollectionsTest {
    @Test
    public void testJdk7way() throws Exception {
        assertEquals(2,new ChocolateCollections().jdk7way() );
    }

    @Test
    public void testJdk7wayWithAHintOfFunctions() throws Exception {
        assertEquals(2,new ChocolateCollections().jdk7wayWithAHintOfFunctions() );
    }

    @Test
    public void testJdk8wayWithClosures() throws Exception {
        assertEquals(2,new ChocolateCollections().jdk8wayWithClosures() );
    }

    @Test
    public void testJdk8wayWithAnonymousClassesAndStreamsAPI() throws Exception {
        assertEquals(2,new ChocolateCollections().jdk8wayWithAnonymousClassesAndStreamsAPI() );
    }

    @Test
    public void testJdk8wayWithClosuresAndStreamsAPI() throws Exception {
        assertEquals(2,new ChocolateCollections().jdk8wayWithClosuresAndStreamsAPI() );
    }
}
