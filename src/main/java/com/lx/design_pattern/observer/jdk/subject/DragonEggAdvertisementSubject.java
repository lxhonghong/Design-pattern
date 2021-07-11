package com.lx.design_pattern.observer.jdk.subject;

import org.springframework.stereotype.Component;

import java.util.Observable;

/**
 * @author 贼不走空
 * @description 龙蛋广告主题
 * @since 2021/7/6 11:23 下午
 */
@Component
public class DragonEggAdvertisementSubject extends Observable {

    public void setMessage(Object o){
        this.setChanged();
        this.notifyObservers(o);
    }

}
