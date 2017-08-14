package com.epam.courses.jf.se2.labmda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public interface SimpleLambda {


}


class Outer {

    private int field;

    public static void main(String[] args) {
    }

    private int method() {
        Functional func = () -> { return this.field; };
        return func.getField();
    }

    private int effectivelyFinal() {
        int value = 0;
        Functional funcFinal = () -> {
            System.out.println();
            return value;
        };
        return funcFinal.getField();
    }

    private int fieldValues() {
        Functional funcFinal = () -> field++;
        return funcFinal.getField();
    }

    private void runnable() {
        Runnable runnable = () -> System.out.println("QWERT");
        new Thread(runnable).start();
    }

    private void actionListener() {
        ActionListener methodRef = Outer::performed;
        methodRef.actionPerformed(new ActionEvent(null, 0, null));
    }

    private static void performed(ActionEvent event) {
        System.out.println(event.getSource());
    }


    private void biFunction() {
        BiFunction<Long, Long, Integer> biFunction = (Long x, Long y) -> (int)(x + y);
        BinaryOperator<Long> addExplicit = (Long х, Long у) -> х + у;

    }

    @FunctionalInterface
    interface Functional {
        int getField();

        default int defaultMethod() {
            return 0;
        }
    }

    class InheritedFunctionalInterface implements Functional {

        @Override
        public int getField() {
            return defaultMethod();
        }
    }
}




















