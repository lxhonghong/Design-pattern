package com.lx.design_pattern.observer.self.observer;

import com.alibaba.fastjson.JSONObject;
import com.lx.design_pattern.observer.self.Observer;
import org.springframework.stereotype.Component;

/**
 * @author 贼不走空
 * @description
 * @since 2021/7/6 11:27 下午
 */
@Component
public class Observer1 implements Observer {

    private final static String NAME = "昊天宗宗主";

    @Override
    public void update(String message) {
        JSONObject jsonObject = JSONObject.parseObject(message);
        // 哪个主题
        String subject = jsonObject.getString("subject");
        // 内容
        String body = jsonObject.getString("body");
        System.out.println(NAME+"看到了"+subject+"的消息，内容是"+body);
        if ("贼不走空拍卖场广告部".equals(subject)) {
            System.out.println(NAME+"说：这个消息很重要，就算我们得不到也绝不能让武魂殿得到");
            System.out.println();
        } else {
            System.out.println(NAME+"说：十万魂币");
        }
    }
}
