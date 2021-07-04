package com.lx.design_pattern.observer;

/**
 * @author 刘鑫
 * @description 抽象主题角色
 * 把所有观察者对象的引用保存在一个集合中，
 * 每个抽象主题角色都可以有任意数量的观察者，
 * 抽象主题提供一个接口，可以增加和删除观察者角色，
 * 一般用一个抽象类或接口来实现
 * @since 2020/11/19 8:37 上午
 */
public interface AbstractSubject {
    /**
     * 增加观察者
     */
    void addObserver(AbstractObserver abstractObserver);
    /**
     * 删除观察者
     */
    void removeObserver(AbstractObserver abstractObserver);
    /**
     * 通知
     */
    public void notification();
}
