package com.lx.design_pattern.abstractfactory;

/**
 * @author 刘鑫
 * @description
 * @since 2019/11/18 9:55 下午
 */
public class SendMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }

    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.send();
    }
}
