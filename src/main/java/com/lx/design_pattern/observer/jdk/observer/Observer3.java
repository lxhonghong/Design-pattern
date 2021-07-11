package com.lx.design_pattern.observer.jdk.observer;

import com.alibaba.fastjson.JSONObject;
import com.lx.design_pattern.observer.jdk.subject.DragonEggAdvertisementSubject;
import com.lx.design_pattern.observer.jdk.subject.DragonEggPriceSubject;
import org.springframework.stereotype.Component;

import java.util.Observable;
import java.util.Observer;

/**
 * @author 贼不走空
 * @description
 * @since 2021/7/6 11:27 下午
 */
@Component
public class Observer3 implements Observer {

    private final static String NAME = "七宝琉璃宗";

    public void registerSubject(Observable observable)
    {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        JSONObject jsonObject = JSONObject.parseObject(arg.toString());
        // 哪个主题
        String subject = jsonObject.getString("subject");
        // 内容
        String body = jsonObject.getString("body");
        System.out.println(NAME+"看到了"+subject+"的消息，内容是"+body);
        if (o instanceof DragonEggAdvertisementSubject) {
            System.out.println(NAME+"说：上三宗论财力还是我们七宝琉璃宗第一，这次说什么也要阻止武魂殿，他们的野心实在太可怕了");
            System.out.println(NAME+"说：传我命令，三天之内，聚集所有可以聚集的资产，龙蛋我们一定要得到");
            System.out.println();
        }
        if (o instanceof DragonEggPriceSubject) {
            System.out.println(NAME+"说：十二万魂币");
        }
    }
}
