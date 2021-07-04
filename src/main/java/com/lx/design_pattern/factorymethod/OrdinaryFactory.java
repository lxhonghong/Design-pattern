package com.lx.design_pattern.factorymethod;

/**
 * @author 刘鑫
 * @description 普通工厂方法类
 * @since 2019/11/18 3:00 下午
 */
public class OrdinaryFactory {
    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else if ("qq".equals(type)) {
            return new QQSender();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }

    public static void main(String[] args) {
        OrdinaryFactory factory = new OrdinaryFactory();
        Sender sender = factory.produce("sms");
        Sender sender1 = factory.produce("mail");
        Sender sender2 = factory.produce("qq");
        sender.send();
        sender1.send();
        sender2.send();
    }
}
