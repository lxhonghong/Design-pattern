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
public class Observer4 implements Observer {

    private final static String NAME = "蓝电霸王龙家族族长";

    @Override
    public void update(String message) {
        JSONObject jsonObject = JSONObject.parseObject(message);
        // 哪个主题
        String subject = jsonObject.getString("subject");
        // 内容
        String body = jsonObject.getString("body");
        System.out.println(NAME+"看到了"+subject+"的消息，内容是"+body);
        if ("贼不走空拍卖场广告部".equals(subject)) {
            System.out.println(NAME+"说：我们蓝电霸王龙家族如果得到龙蛋的话肯定可以更强大，这次就算赌上整个家族也一定要拿下");
            System.out.println(NAME+"说：传我命令，家族内所有值钱的资产三天内尽可能变卖，三天后一定要拿下龙蛋");
            System.out.println();
        } else {
            System.out.println(NAME+"说：十三万魂币");
        }
    }
}
