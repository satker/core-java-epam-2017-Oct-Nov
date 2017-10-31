package com.epam.courses.jf.practice.akunats.second;

import com.epam.courses.jf.practice.common.second.ITestableTask11;

import java.util.ArrayList;
import java.util.LinkedList;

public class Task11 implements ITestableTask11 {
    public String emulate(ArrayList<String> peoples) {
//        int i = 0;
//        while (peoples.size() > 1) {
//            ArrayList<String> interList = new ArrayList<>();
//            for (int j = 0; j < peoples.size(); j++) {
//                if (interList.size() >= peoples.size() - 1) {
//                    break;
//                }
//                if (j == i) {
//                    interList.add(peoples.get(i));
//                    if (i + 2 < peoples.size()) {
//                        i += 2;
//                    } else {
//                        i = ((i + 2) % (peoples.size() - 1)) == 1 ? 0 : 1;
//                    }
//                }
//            }
//            peoples.removeAll(interList);
//        }
//        return peoples.get(0);
        if (peoples == null || peoples.isEmpty()) {
            throw new IllegalArgumentException("Linked list not provided!");
        }
        if (peoples.size() == 1) {
            return peoples.get(0);
        }
        int i = 0;
        while (true) {
            peoples.remove(i);
            i++;
            if (i >= peoples.size()) {
                i %= peoples.size();
            }
            if (peoples.size() == 1) {
                return peoples.get(0);
            }
        }
    }

    public String emulate(LinkedList<String> peoples) {
//        int i = 0;
//        while (peoples.size() > 1) {
//            Iterator<String> iter = peoples.iterator();
//            while (iter.hasNext()) {
//                String next = iter.next();
//                if (peoples.size() == 1) {
//                    break;
//                }
//                if (peoples.indexOf(next) == i) {
//                    iter.remove();
//                    if (i + 1 < peoples.size()) {
//                        i += 1;
//                    } else {
//                        if (peoples.size() == 1) {
//                            break;
//                        }
//                        i = i % (peoples.size() - 1);
//                    }
//                }
//            }
//        }
//        return peoples.get(0);
        if (peoples == null || peoples.isEmpty()) {
            throw new IllegalArgumentException("Array list not provided!");
        }
        return emulate(new ArrayList<>(peoples));
    }
}
