package com.lx.design_pattern.factorymethod;

/**
 * @author 刘鑫
 * @description 多个工厂方法类
 * @since 2019/11/18 3:00 下午
 */
public class MultipleFactory {

    public Sender produceMail() {
        return new MailSender();
    }

    public Sender produceSms() {
        return new SmsSender();
    }

    public Sender produceQq() {
        return new QQSender();
    }

    public static void main(String[] args) {
        MultipleFactory factory = new MultipleFactory();
        Sender sender = factory.produceMail();
        Sender sender1 = factory.produceSms();
        Sender sender2 = factory.produceQq();
        sender.send();
        sender1.send();
        sender2.send();
    }
}
