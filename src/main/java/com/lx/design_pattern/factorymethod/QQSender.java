package com.lx.design_pattern.factorymethod;

/**
 * @author 刘鑫
 * @description
 * @since 2019/11/18 2:58 下午
 */
public class QQSender implements Sender {
    @Override
    public void send() {
        System.out.println("我是QQ");
    }
}
