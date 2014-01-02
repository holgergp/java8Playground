package com.grosseplankermann.jdk8test.model;

/**
 * Interface with the sole purpose of showing a default method
 */
public interface CandyBar {


     int getWeight();

    /**
     * Not very clever use of a default method, perhaps I'll come up with a better one
     * @return
     */
    default int getCalories() {
        return getWeight() * 200;
    }
}
