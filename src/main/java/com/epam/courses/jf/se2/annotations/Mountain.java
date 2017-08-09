package com.epam.courses.jf.se2.annotations;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mountain {

    private String name;
    private double latitude;
    private double longitude;
    private String country;

    @Synchronized
    public void method(@NonNull String value) {

    }
}