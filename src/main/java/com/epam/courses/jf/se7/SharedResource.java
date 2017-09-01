package com.epam.courses.jf.se7;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {

    private List<Integer> list = new ArrayList<>();

    public void setElement(Integer element) {
        list.add(element);
    }

    public Integer getElement() {
        return !list.isEmpty() ? list.remove(0) : null;
    }
}

