package com.lx.design_pattern.observer.self;

/**
 * @author 贼不走空
 * @description 观察者接口，所有观察者都需要实现
 * @since 2021/7/6 11:14 下午
 */
public interface Observer {
    /**
     * 更新方法
     */
    void update(String message);
}
