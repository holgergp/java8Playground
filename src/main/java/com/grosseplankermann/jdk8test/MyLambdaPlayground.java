package com.grosseplankermann.jdk8test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Some experimentation with lambdas
 * Created by flunky on 17.07.14.
 */
public class MyLambdaPlayground {


    /**
     * Apply an Unary Operator
     *
     * @param echo
     * @param echoString
     * @return
     */
    public String jdk8UnaryOperatorExample(UnaryOperator<String> echo, String echoString) {
        return echo.apply(echoString);
    }

    /**
     * Example of a method using a custom functional interface
     *
     * @param myOwnFunctionalInterface
     * @return
     */
    public String consumeCustomFunctionalInterface(MyOwnFunctionalInterface myOwnFunctionalInterface) {
        return myOwnFunctionalInterface.myFunction();
    }

    /**
     * Example of a function using the predefined functional interface function
     *
     * @param function
     * @param stringList
     * @return
     */
    public String appendStringsInStringArrayWithFunction(Function<String, String> function, String[] stringList) {
        /**StringBuffer buffer = new StringBuffer();
         for (String s : stringList) {
         buffer.append(function.apply(s));
         }

         return buffer.toString();    **/


        final List<String> strings = Arrays.asList(stringList);
        return String.valueOf(strings.stream()
                .reduce("", (accumulator, currentValue) -> accumulator + function.apply(currentValue)));
    }
}
