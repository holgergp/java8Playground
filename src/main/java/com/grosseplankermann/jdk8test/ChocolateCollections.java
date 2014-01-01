package com.grosseplankermann.jdk8test;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.grosseplankermann.jdk8test.model.ChocolateBar;
import com.grosseplankermann.jdk8test.model.ChocolateType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.google.common.collect.Lists.newArrayList;

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

    public int jdk7wayWithAHintOfFunctions() {
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


    public int jdk8wayWithClosures() {
        final Collection<ChocolateBar> chocolateBarCollection = getChocolateBarCollection();

       chocolateBarCollection.removeIf(chocolateBar -> chocolateBar.getChocolateType() != ChocolateType.HAZELNUT);
        return chocolateBarCollection.size();


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
