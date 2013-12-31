package com.grosseplankermann.jdk8test;

import com.grosseplankermann.jdk8test.model.ChocolateBar;
import com.grosseplankermann.jdk8test.model.ChocolateType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created with IntelliJ IDEA.
 * User: flunky
 * Date: 29.12.13
 * Time: 14:28
 * To change this template use File | Settings | File Templates.
 */
public class ChocolateCollections {


    public static void main(String[] args) {
        Collection<String> mycol;
        mycol = new ArrayList<>();
        mycol.add("Test1");
        mycol.add("Test2");
        mycol.forEach(i -> {
            System.out.print(i);
        });

    }


    public int jdk7way() {

        final Collection<ChocolateBar> chocolateBarCollection = getChocolateBarCollection();
        int chocolateCounter = 0;
        for (ChocolateBar chocolateBar : chocolateBarCollection) {
            if (chocolateBar.getChocolateType() == ChocolateType.HAZELNUT) {
                chocolateCounter++;

            }
        }
        return chocolateCounter;

    }

    public long jdk7wayWithAHintOfFunctions() {
        return 0;
    }


    public long jdk8wayWithClosures() {
        return 0;
    }

    public long jdk8wayWithAnonymousClassesAndStreamsAPI() {
        return getChocolateBarCollection().stream().map(new Function<ChocolateBar, Object>() {
            @Override
            public Object apply(ChocolateBar chocolateBar) {
                return chocolateBar.getChocolateType();
            }
        }).filter(new Predicate<Object>() {
            @Override
            public boolean test(Object o) {
                ChocolateType ct = (ChocolateType) o;
                return ct == ChocolateType.HAZELNUT;
            }
        }).count();

    }

    public long jdk8wayWithClosuresAndStreamsAPI() {
        return getChocolateBarCollection().stream()
                .map(chocolateBar -> chocolateBar.getChocolateType())
                .filter(chocolateType -> chocolateType == ChocolateType.HAZELNUT)
                .count();

    }

    private Collection<ChocolateBar> getChocolateBarCollection() {
        Collection<ChocolateBar> chocolateBars;
        chocolateBars = new ArrayList<>();
        chocolateBars.add(new ChocolateBar(20, 100, ChocolateType.WHOLEMILK, "Sarotti"));
        chocolateBars.add(new ChocolateBar(25, 200, ChocolateType.HAZELNUT, "Milka"));
        chocolateBars.add(new ChocolateBar(10, 100, ChocolateType.DARK, "Ritter Sport"));
        chocolateBars.add(new ChocolateBar(10, 180, ChocolateType.HAZELNUT, "Ritter Sport"));
        chocolateBars.add(new ChocolateBar(5, 20, ChocolateType.WHOLEMILK, "Kinder Schokolade"));
        chocolateBars.add(new ChocolateBar(18, 100, ChocolateType.RAISINS, "Schogetten"));
        return chocolateBars;
    }

}
