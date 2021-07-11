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
public class Observer3 implements Observer {

    private final static String NAME = "七宝琉璃宗";

    @Override
    public void update(String message) {
        JSONObject jsonObject = JSONObject.parseObject(message);
        // 哪个主题
        String subject = jsonObject.getString("subject");
        // 内容
        String body = jsonObject.getString("body");
        System.out.println(NAME+"看到了"+subject+"的消息，内容是"+body);
        if ("贼不走空拍卖场广告部".equals(subject)) {
            System.out.println(NAME+"说：上三宗论财力还是我们七宝琉璃宗第一，这次说什么也要阻止武魂殿，他们的野心实在太可怕了");
            System.out.println(NAME+"说：传我命令，三天之内，聚集所有可以聚集的资产，龙蛋我们一定要得到");
            System.out.println();
        } else {
            System.out.println(NAME+"说：十二万魂币");
        }
    }
}
