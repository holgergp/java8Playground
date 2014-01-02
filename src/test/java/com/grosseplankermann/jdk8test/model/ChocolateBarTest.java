package com.grosseplankermann.jdk8test.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ChocolateBarTest {

    @Test
    public void checkCalories() throws Exception {
       assertEquals(20000 ,new ChocolateBar(20, 100, ChocolateType.WHOLEMILK, "Sarotti").getCalories());

    }
}
