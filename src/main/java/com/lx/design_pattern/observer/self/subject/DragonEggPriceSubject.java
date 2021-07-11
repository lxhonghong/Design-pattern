package com.lx.design_pattern.observer.self.subject;

import com.lx.design_pattern.observer.self.Observer;
import com.lx.design_pattern.observer.self.Subject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 贼不走空
 * @description 龙蛋广告主题
 * @since 2021/7/6 11:23 下午
 */
@Component
public class DragonEggPriceSubject implements Subject {
    // 存储所有关注龙蛋价格的观察者
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
