package com.grosseplankermann.jdk8test.model;

/**
 * Created with IntelliJ IDEA.
 * User: flunky
 * Date: 31.12.13
 * Time: 15:22
 * To change this template use File | Settings | File Templates.
 */
public class ChocolateBar {

    int numberOfPieces;
    int weight;
    ChocolateType chocolateType;
    String brandName;

    public ChocolateBar(int numberOfPieces, int weight, ChocolateType chocolateType, String brandName) {
        this.numberOfPieces = numberOfPieces;
        this.weight = weight;
        this.chocolateType = chocolateType;
        this.brandName = brandName;
    }

    public int getNumberOfPieces() {
        return numberOfPieces;
    }

    public void setNumberOfPieces(int numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ChocolateType getChocolateType() {
        return chocolateType;
    }

    public void setChocolateType(ChocolateType chocolateType) {
        this.chocolateType = chocolateType;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
