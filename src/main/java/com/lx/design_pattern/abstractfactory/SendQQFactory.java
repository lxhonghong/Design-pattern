package com.lx.design_pattern.abstractfactory;

/**
 * @author 贼不走空
 * @description
 * @since 2019/11/18 9:55 下午
 */
public class SendQQFactory implements Provider {
    @Override
    public Sender produce() {
        return new QQSender();
    }

    public static void main(String[] args) {
        Provider provider = new SendQQFactory();
        Sender sender = provider.produce();
        sender.send();
    }
}
