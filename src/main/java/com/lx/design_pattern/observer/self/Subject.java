package com.lx.design_pattern.observer.self;

/**
 * @author 贼不走空
 * @description 主题接口，所有主题都必须实现此接口
 * @since 2021/7/6 11:12 下午
 */
public interface Subject {
    /**
     * 增加订阅者
     * @param observer
     */
    void attach(Observer observer);
    /**
     * 删除订阅者
     * @param observer
     */
    void detach(Observer observer);
    /**
     * 通知订阅者更新消息
     */
    void notify(String message);

}
