package com.epam.courses.jf.se7.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedFifoQueue {

    private Object[] elems;
    private int current;
    private int placeIndex;
    private int removeIndex;

    private final Lock lock;
    //Создаем 2 переменных условия - когда очередь пуста и заполнена
    private final Condition isNotEmpty;
    private final Condition isFull;

    public SharedFifoQueue(int capacity) {
        this.elems = new Object[capacity];
        this.lock = new ReentrantLock();
        this.isNotEmpty = lock.newCondition();
        this.isFull = lock.newCondition();
    }

    public void add(Object elem) {
        try {
            //блокируем очередь для выполнения операции добавления элемента
            lock.lock();

            //если текущий индекс превышает размер очереди, значит очередь заполнена и поток оживает
            while (current >= elems.length) {
                isFull.awaitUninterruptibly();
            }

            //после выхода из режима ожидания помещаем элемент в очередь
            elems[placeIndex] = elem;

            //Рассчитываем следующий индекс так, чтобы не выйти за пределы массива
            placeIndex = (placeIndex + 1) % elems.length;

            ++current;

            //Даем сиглал consumer-потоку, что очередь не пуста
            isNotEmpty.signal();
        } finally {
            //снимаем блокировку
            lock.unlock();
        }
    }

    public Object remove() throws InterruptedException {
        try {
            Object elem = null;

            //блокируем очередь для удаления элемента
            lock.lock();

            //если текущий индекс меньше нуля, значит очередь пуста и поток оживает
            while (current <= 0) {
                isNotEmpty.await();
            }

            //после выхода из режима ожидания получаем элемент
            elem = elems[removeIndex];

            //Рассчитываем следующий индекс так, чтобы не выйти за пределы массива
            removeIndex = (removeIndex + 1) % elems.length;

            --current;

            //Даем сиглал producer-потоку, что очередь не полностью заполнена
            isFull.signal();
            return elem;
        } finally {
            //снимаем блокировку
            lock.unlock();
        }
    }
}
