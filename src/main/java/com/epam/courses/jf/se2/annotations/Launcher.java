package com.epam.courses.jf.se2.annotations;

import java.lang.annotation.Annotation;

public class Launcher {


    public static void main(String[] args) {
        RawMountain oldMountain = new RawMountain("Everest", 100, 200, "Nepal");
        Mountain mountain = new Mountain("Everest", 100, 200, "Nepal");
        Mountain defaulMountain = new Mountain();

        System.out.println(oldMountain);
        System.out.println(mountain);


        mountain.setName("BLA BLA");
        System.out.println(mountain.getName());
        System.out.println(mountain.getCountry());
        System.out.println(mountain.getLatitude());
        System.out.println(mountain.getLongitude());

        for (Annotation annotation : Mountain.class.getAnnotations()) {
            System.out.println(annotation);
        }
    }
}
