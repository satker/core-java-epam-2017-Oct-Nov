package com.epam.courses.jf.se3;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Locales {

    public static void main(String[] args) throws ParseException {
        String numGer = "9.876,598";
        String curGer = "9.876,598 €";

        NumberFormat nfGer = NumberFormat.getNumberInstance(Locale.GERMANY);
        NumberFormat cfGer = NumberFormat.getCurrencyInstance(Locale.GERMANY);

        double dGer = (Double) nfGer.parse(numGer);
        double dcGer = (Double) cfGer.parse(curGer);

        System.out.println(dGer + " " + dcGer);

    }
}
