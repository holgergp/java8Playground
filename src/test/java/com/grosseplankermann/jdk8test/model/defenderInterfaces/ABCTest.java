package com.grosseplankermann.jdk8test.model.defenderInterfaces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ABCTest {
    @Test
    public void testSomeMethod() throws Exception {
           assertEquals("A",new ABC().someMethod());
    }
}
