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
public class Observer2 implements Observer {

    private final static String NAME = "武魂殿殿主";

    @Override
    public void update(String message) {
        JSONObject jsonObject = JSONObject.parseObject(message);
        // 哪个主题
        String subject = jsonObject.getString("subject");
        // 内容
        String body = jsonObject.getString("body");
        System.out.println(NAME+"看到了"+subject+"的消息，内容是"+body);
        if ("贼不走空拍卖场广告部".equals(subject)) {
            System.out.println(NAME+"说：龙蛋一定是我的");
            System.out.println();
        } else {
            System.out.println(NAME+"说：十一万魂币");
        }
    }
}
