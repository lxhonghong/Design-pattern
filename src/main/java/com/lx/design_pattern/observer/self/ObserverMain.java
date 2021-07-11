package com.lx.design_pattern.observer.self;

import com.alibaba.fastjson.JSONObject;
import com.lx.design_pattern.observer.self.observer.Observer1;
import com.lx.design_pattern.observer.self.observer.Observer2;
import com.lx.design_pattern.observer.self.observer.Observer3;
import com.lx.design_pattern.observer.self.observer.Observer4;
import com.lx.design_pattern.observer.self.subject.DragonEggAdvertisementSubject;
import com.lx.design_pattern.observer.self.subject.DragonEggPriceSubject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 贼不走空
 * @description
 * @since 2021/7/7 2:24 下午
 */
@Component
public class ObserverMain {
    public static int price = 100000;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("贼不走空拍卖场通过他们独有的渠道获得了一个上古龙蛋，于是乎，他们打了很大的广告，希望各界人士前来参与拍卖");
        System.out.println();
        Thread.sleep(2000);
        // 创建龙蛋广告主题（被观察者）
        Subject dragonEggAdvertisement = new DragonEggAdvertisementSubject();
        Observer observer1 = new Observer1();
        Observer observer2 = new Observer2();
        Observer observer3 = new Observer3();
        Observer observer4 = new Observer4();
        dragonEggAdvertisement.attach(observer1);
        dragonEggAdvertisement.attach(observer2);
        dragonEggAdvertisement.attach(observer3);
        dragonEggAdvertisement.attach(observer4);
        Map<String,String> map = new HashMap<>();
        map.put("subject","贼不走空拍卖场广告部");
        map.put("body","龙蛋将于3天后拍卖");
        dragonEggAdvertisement.notify(JSONObject.toJSONString(map));
        Thread.sleep(3000);
        System.out.println("三天后,拍卖会如期举行。。。");
        Subject dragonEggPrice = new DragonEggPriceSubject();
        dragonEggPrice.attach(observer1);
        dragonEggPrice.attach(observer2);
        dragonEggPrice.attach(observer3);
        dragonEggPrice.attach(observer4);
        map.put("subject","贼不走空拍卖场一号技师");
        map.put("body",price+"");
        dragonEggPrice.notify(JSONObject.toJSONString(map));
        System.out.println("龙蛋之争就这样开始了");
    }
}
