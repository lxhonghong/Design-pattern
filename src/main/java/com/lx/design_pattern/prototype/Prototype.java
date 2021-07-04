package com.lx.design_pattern.prototype;

/**
 * @author 刘鑫
 * @description
 * @since 2019/11/19 9:48 下午
 */
public class Prototype implements Cloneable {

    public Object cloneA() throws CloneNotSupportedException {
        Prototype proto = (Prototype) super.clone();
        return proto;
    }

}
