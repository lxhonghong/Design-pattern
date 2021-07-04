package com.lx.design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘鑫
 * @description
 * @since 2020/11/19 8:45 上午
 */
public class SpecificSubject implements AbstractSubject {
    List<AbstractObserver> observers = new ArrayList<>();
    @Override
    public void addObserver(AbstractObserver abstractObserver) {
        observers.add(abstractObserver);
    }

    @Override
    public void removeObserver(AbstractObserver abstractObserver) {
        observers.remove(abstractObserver);
    }

    /**
     * 有变化是观察者更新自己
     */
    @Override
    public void notification() {
        for (AbstractObserver observer : observers) {
            observer.update();
        }
    }
}
