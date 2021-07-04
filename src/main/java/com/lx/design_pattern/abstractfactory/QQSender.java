package com.lx.design_pattern.abstractfactory;

/**
 * @author 刘鑫
 * @description
 * @since 2019/11/18 9:51 下午
 */
public class QQSender implements Sender {
    @Override
    public void send() {
        System.out.println("这里是QQ");
    }
}
