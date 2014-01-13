package com.grosseplankermann.jdk8test.model.defenderInterfaces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by flunky on 13.01.14.
 */
public class DEFTest {

    @Test
    public void someMethod(){
        assertEquals("SuperClass", new DEF().someMethod());
    }
}
