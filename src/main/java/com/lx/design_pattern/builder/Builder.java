package com.lx.design_pattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 贼不走空
 * @description
 * @since 2019/11/19 9:36 下午
 */
public class Builder {

    private List<Sender> list = new ArrayList<Sender>();

    public void produceMailSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
    }

    public void produceQQSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new QQSender());
        }
    }


    /**
     * 测试
     */
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(10);
        System.out.println(builder.list.toString());
    }

}


