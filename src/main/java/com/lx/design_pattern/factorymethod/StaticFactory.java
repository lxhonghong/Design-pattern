package com.lx.design_pattern.factorymethod;

/**
 * @author 刘鑫
 * @description 静态工厂方法类
 * @since 2019/11/18 3:00 下午
 */
public class StaticFactory {

    public static Sender produceMail() {
        return new MailSender();
    }

    public static Sender produceSms() {
        return new SmsSender();
    }

    public static Sender produceQq() {
        return new QQSender();
    }

    public static void main(String[] args) {
        Sender sender = StaticFactory.produceMail();
        Sender sender1 = StaticFactory.produceSms();
        Sender sender2 = StaticFactory.produceQq();
        sender.send();
        sender1.send();
        sender2.send();
    }
}
