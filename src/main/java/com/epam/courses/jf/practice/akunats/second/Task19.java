package com.epam.courses.jf.practice.akunats.second;

import com.epam.courses.jf.practice.common.second.ITestableTask19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;

public class Task19 implements ITestableTask19 {
    @Override
    public int getNumberOvertaking(Set<ICar> cars, long lengthLap, int numberLaps) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ICar> inputData = new ArrayList<>(cars);
        inputData.stream()
                .sorted(Comparator.comparingInt(ICar::getStartPosition))
                .forEach(i -> {
                    // сортируем от максимального к минимальному и смотрим сколько раз обгонит быстрый медленных
                    // на последующем шаге убираем проверенную быструю машину
                    for (ICar car : cars) {
                        if (!car.equals(i) && i.getSpeed() > car.getSpeed()) {
                            // если скорость одинаковая, то обгона никогда не будет
                            if (car.getSpeed() == i.getSpeed()){
                                list.add(0);
                                break;
                            }
                            // через какое расстояние быстрый обгонит медленного первый раз,
                            // так как старт с разных дистанций
                            double firthOvertaking;
                            if (i.getStartPosition() > car.getStartPosition()) {
                                // первый обгон если более быстрый впереди медленного
                                firthOvertaking = (double) (i.getStartPosition() * car.getSpeed()
                                        - car.getStartPosition() * i.getSpeed()
                                        - lengthLap * car.getSpeed()) / (double) (car.getSpeed() - i.getSpeed());
                                // если расстояние от старта одинаковое то принимаем его за единицу
                            } else if ((i.getStartPosition() - car.getStartPosition()) == 0) {
                                // первый обгон если более медленный впереди быстрого
                                firthOvertaking = (double) (car.getSpeed())
                                        / (double) (i.getSpeed() - car.getSpeed());
                            } else {
                                // первый обгон если более медленный впереди быстрого
                                firthOvertaking = (double) (car.getSpeed() * (car.getStartPosition() - i.getStartPosition()))
                                        / (double) (i.getSpeed() - car.getSpeed());
                            }
                            // количество обгонов при старте с одинаковой позиции
                            double continueOvertaking = (double) (lengthLap * car.getSpeed()) / (double) (i.getSpeed() - car.getSpeed());
                            // Записываем полученное число обгонов в коллекцию
                            double numOvertaking = (lengthLap * numberLaps - firthOvertaking) / continueOvertaking;
                            list.add((int) numOvertaking);
                        }
                    }
                });
        int result = 0;
        // Подсчитываем число обгонов
        for (Integer i : list) {
            result += i;
        }
        return result;
    }
}
