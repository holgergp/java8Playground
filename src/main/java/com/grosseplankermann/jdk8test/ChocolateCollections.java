package com.grosseplankermann.jdk8test;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.grosseplankermann.jdk8test.model.ChocolateBar;
import com.grosseplankermann.jdk8test.model.ChocolateType;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Try different ways to work on a collection, comparing JDK7 and JDK8 style
 */
public class ChocolateCollections {

    public void simpleIteration(Consumer consumer) {
        final Collection<ChocolateBar> chocolateBarCollection = ChocolateCollections.getChocolateBarCollection();
        chocolateBarCollection.forEach(consumer);
    }


    public int countHazelnutChocolateJdk7way() {
        final Collection<ChocolateBar> chocolateBarCollection = getChocolateBarCollection();
        int chocolateCounter = 0;
        for (ChocolateBar chocolateBar : chocolateBarCollection) {
            if (chocolateBar.getChocolateType() == ChocolateType.HAZELNUT) {
                chocolateCounter++;
            }
        }
        return chocolateCounter;

    }

    public int countHazelnutChocolateJdk7wayWithAHintOfFunctions() {
        final Collection<ChocolateBar> chocolateBarCollection = getChocolateBarCollection();

        final Collection<ChocolateType> chocolateTypeCollection = Collections2.transform(chocolateBarCollection, new com.google.common.base.Function<ChocolateBar, ChocolateType>() {
            @Override
            public ChocolateType apply(ChocolateBar chocolateBar) {
                return chocolateBar.getChocolateType();
            }
        });

        final ArrayList<ChocolateType> filteredChocolateBars = newArrayList(Iterables.filter(chocolateTypeCollection, new com.google.common.base.Predicate<ChocolateType>() {
            @Override
            public boolean apply(ChocolateType chocolateType) {
                return chocolateType == ChocolateType.HAZELNUT;
            }
        }));

        return filteredChocolateBars.size();
    }


    public int countHazelnutChocolateJdk8wayWithClosures() {
        final Collection<ChocolateBar> chocolateBarCollection = getChocolateBarCollection();

        chocolateBarCollection.removeIf(chocolateBar -> chocolateBar.getChocolateType() != ChocolateType.HAZELNUT);
        return chocolateBarCollection.size();


    }

    public long countHazelnutChocolateJdk8wayWithAnonymousClassesAndStreamsAPI() {
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

    public long countHazelnutChocolateJdk8wayWithClosuresAndStreamsAPI() {
        return getChocolateBarCollection().stream()
                .map(ChocolateBar::getChocolateType)
                .filter(chocolateType -> chocolateType == ChocolateType.HAZELNUT)
                .count();
    }


    public double averageNumberOfPiecesForChocolateHeavierThan50GramsJDK7() {

        final Collection<ChocolateBar> chocolateBarCollection = getChocolateBarCollection();
        int selectedChocolateBars = 0;
        int sumOfPieces = 0;
        double average = 0;
        for (ChocolateBar chocolateBar : chocolateBarCollection) {
            if (chocolateBar.getWeight() > 50) {
                selectedChocolateBars++;
                sumOfPieces += chocolateBar.getNumberOfPieces();
            }
        }
        if (selectedChocolateBars > 0) {
            average = sumOfPieces / selectedChocolateBars;
        }
        return average;

    }

    public OptionalDouble averageNumberOfPiecesForChocolateHeavierThan50GramsJDK8() {
        final long start = System.nanoTime();

        final OptionalDouble average = getChocolateBarCollection().stream()
                .filter(chocolateBar -> chocolateBar.getWeight() > 50)
                .mapToInt(ChocolateBar::getNumberOfPieces)
                .average();
        System.out.println(String.format("Execution time sequential %d microseconds", (System.nanoTime() - start) / 10000));
        return average;

    }

    public OptionalDouble averageNumberOfPiecesForChocolateHeavierThan50GramsJDK8Parallel() {
        final long start = System.nanoTime();
        final OptionalDouble average = getChocolateBarCollection().parallelStream()
                .filter(chocolateBar -> chocolateBar.getWeight() > 50)
                .mapToInt(ChocolateBar::getNumberOfPieces)
                .average();
        System.out.println(String.format("Execution time parallel %d microseconds", (System.nanoTime() - start) / 1000));
        return average;

    }



    public static Collection<ChocolateBar> getChocolateBarCollection() {
        Collection<ChocolateBar> chocolateBars;
        chocolateBars = new ArrayList<>();
        chocolateBars.add(new ChocolateBar(20, 100, ChocolateType.WHOLEMILK, "Sarotti"));
        chocolateBars.add(new ChocolateBar(25, 200, ChocolateType.HAZELNUT, "Milka"));
        chocolateBars.add(new ChocolateBar(10, 100, ChocolateType.DARK, "Ritter Sport"));
        chocolateBars.add(new ChocolateBar(10, 180, ChocolateType.HAZELNUT, "Ritter Sport"));
        chocolateBars.add(new ChocolateBar(5, 20, ChocolateType.WHOLEMILK, "Kinder Schokolade"));
        chocolateBars.add(new ChocolateBar(18, 100, ChocolateType.RAISINS, "Schogetten"));
        chocolateBars.add(new ChocolateBar(7, 55, ChocolateType.WHOLEMILK, "Lindt"));
        chocolateBars.add(new ChocolateBar(1, 45, ChocolateType.PEANUTS, "Snickers"));
        return chocolateBars;
    }


    public static void main(String[] args) {
        Collection<String> mycol;
        mycol = new ArrayList<>();
        mycol.add("Test1");
        mycol.add("Test2");
        mycol.forEach(i -> {
            System.out.print(i);
        });

    }
}
