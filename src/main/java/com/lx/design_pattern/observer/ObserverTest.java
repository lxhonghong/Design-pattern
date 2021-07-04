package com.lx.design_pattern.observer;

import org.springframework.stereotype.Component;

/**
 * @author 刘鑫
 * @description 观察者模式测试类
 * @since 2020/11/19 8:48 上午
 */
@Component
public class ObserverTest {
    public static void main(String[] args) {
        // 生成一个主题角色
        AbstractSubject subject = new SpecificSubject();
        subject.addObserver(new AbstractObserver() {
            @Override
            public void update() {
                System.out.println("观察者一号睡觉");
            }
        });
        subject.addObserver(new AbstractObserver() {
            @Override
            public void update() {
                System.out.println("观察者二号睡觉");
            }
        });
        subject.addObserver(new AbstractObserver() {
            @Override
            public void update() {
                System.out.println("观察者三号睡觉");
            }
        });
        subject.notification();
    }
}
