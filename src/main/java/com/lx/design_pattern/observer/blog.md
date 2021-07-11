
## 观察者模式学习第一步：抄概念
- **定义**：定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖他的对象都得到通知并自动更新
- **主要解决**：一个对象状态改变给其他对象通知的问题，而且需要考虑到易用和低耦合，保证高度的协作
- **何时使用**：一个对象（目标对象）的状态发生改变，所有的依赖对象（观察者对象）都将得到通知，进行**广播**通知
- **如何解决**：使用面向对象技术，可以将这种依赖关系弱化
- **关键代码**：在抽象类了有一个ArrayList存放所有的观察者
## 观察者模式学习第二步：场景带入
- 1.拍卖：拍卖会上所有人都会关注拍卖师报出的最高标价（目标对象），最高标价发生变更后拍卖师大喇叭通知所有竞价者（也就是观察者，至于加不加钱就看他们自己了）--- 这里补充下：目标对象是最高标价，而不是拍卖师，拍卖师只是负责广播的工具
- 2.十字路口：十字路口有红绿灯（目标对象），路上腿着的、骑自行车的、开汽车的、还有交警都是观察者，左转灯绿了左转的走，直行灯绿了直行的走，交警还得跟着灯稍息立正向左/右转，小手摆起来指示。。。
## 观察者模式学习第三步：编程场景理解
- 一个抽象模型有两个方面，其中一个方面依赖于另一个方面。将这些方面封装在独立的对象中使他们可以各自独立的改变和复用
- 一个对象的改变将导致其他一个或多个对象也发生改变，而不知道具体有多少对象将发生改变，可以降低对象之间的耦合度
- 一个对象必须通知其他对象，而他并不知道这些对象是谁
- 需要在系统中创建一个触发链，A对象的行为将影响到B对象，B对象的行为将影响C对象...，可以使用观察者模式创建一种链式触发机制
## 观察者模式学习第四步：画类图☺☺☺
![观察者模式类图](https://img-blog.csdnimg.cn/20210706225820259.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x4eGlhb3l1YW4=,size_16,color_FFFFFF,t_70)
## 观察者模式学习第五步：讲故事（上代码）☺☺☺☺☺☺
背景：贼不走空拍卖场通过他们独有的渠道获得了一个上古龙蛋，于是乎，他们打了很大的广告，希望各界人士前来参与拍卖
主题1：贼不走空龙蛋广告
主题2：龙蛋价格

观察者1：武魂殿殿主
观察者2：昊天宗宗主
观察者3：蓝电霸王龙家族族长
观察者4：七宝琉璃宗宗主

##### 主题和观察者接口
```
/**
 * @author 贼不走空
 * @description 抽象主题（被观察者）
 * @since 2021/7/6 11:12 下午
 */
public interface Subject {
    /**
     * 增加订阅者
     * @param observer
     */
    void attach(Observer observer);
    /**
     * 删除订阅者
     * @param observer
     */
    void detach(Observer observer);
    /**
     * 通知订阅者更新消息
     */
    void notify(String message);

}
```

```
/**
 * @author 贼不走空
 * @description 观察者接口，所有观察者都需要实现
 * @since 2021/7/6 11:14 下午
 */
public interface Observer {
    /**
     * 更新方法
     */
    void update(String message);
}
```
##### 广告主题和龙蛋价格主题实现

```
/**
 * @author 贼不走空
 * @description 龙蛋广告主题
 * @since 2021/7/6 11:23 下午
 */
@Component
public class DragonEggAdvertisementSubject implements Subject {
    // 存储所有关注龙蛋广告的观察者
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
```

```

/**
 * @author 贼不走空
 * @description 龙蛋广告主题
 * @since 2021/7/6 11:23 下午
 */
@Component
public class DragonEggPriceSubject implements Subject {
    // 存储所有关注龙蛋价格的观察者
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
```
##### 几个大人物（实际观察者）

```
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
```

```

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
```

```

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
```

```

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
```
##### 测试一下开拍卖会的感觉
```
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
        System.out.println();
        System.out.println();
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
```
##### 看下执行的结果

```
贼不走空拍卖场通过他们独有的渠道获得了一个上古龙蛋，于是乎，他们打了很大的广告，希望各界人士前来参与拍卖

昊天宗宗主看到了贼不走空拍卖场广告部的消息，内容是龙蛋将于3天后拍卖
昊天宗宗主说：这个消息很重要，就算我们得不到也绝不能让武魂殿得到

武魂殿殿主看到了贼不走空拍卖场广告部的消息，内容是龙蛋将于3天后拍卖
武魂殿殿主说：龙蛋一定是我的

七宝琉璃宗看到了贼不走空拍卖场广告部的消息，内容是龙蛋将于3天后拍卖
七宝琉璃宗说：上三宗论财力还是我们七宝琉璃宗第一，这次说什么也要阻止武魂殿，他们的野心实在太可怕了
七宝琉璃宗说：传我命令，三天之内，聚集所有可以聚集的资产，龙蛋我们一定要得到

蓝电霸王龙家族族长看到了贼不走空拍卖场广告部的消息，内容是龙蛋将于3天后拍卖
蓝电霸王龙家族族长说：我们蓝电霸王龙家族如果得到龙蛋的话肯定可以更强大，这次就算赌上整个家族也一定要拿下
蓝电霸王龙家族族长说：传我命令，家族内所有值钱的资产三天内尽可能变卖，三天后一定要拿下龙蛋

三天后,拍卖会如期举行。。。
昊天宗宗主看到了贼不走空拍卖场一号技师的消息，内容是100000
昊天宗宗主说：十万魂币
武魂殿殿主看到了贼不走空拍卖场一号技师的消息，内容是100000
武魂殿殿主说：十一万魂币
七宝琉璃宗看到了贼不走空拍卖场一号技师的消息，内容是100000
七宝琉璃宗说：十二万魂币
蓝电霸王龙家族族长看到了贼不走空拍卖场一号技师的消息，内容是100000
蓝电霸王龙家族族长说：十三万魂币
龙蛋之争就这样开始了
```
## 观察者模式学习第六步：Java内置了观察者模式，我们来试一下☺☺☺☺☺☺
##### 首先这里不需要自己定义被观察者和观察者的接口了，被观察者继承Observable类，观察者实现Observer接口即可，看代码
##### 广告主题和龙蛋价格主题实现

```
import java.util.Observable;

/**
 * @author 贼不走空
 * @description 龙蛋广告主题
 * @since 2021/7/6 11:23 下午
 */
@Component
public class DragonEggAdvertisementSubject extends Observable {
    public void setMessage(Object o){
        this.setChanged();
        this.notifyObservers(o);
    }
}
```

```
import java.util.Observable;

/**
 * @author 贼不走空
 * @description 龙蛋广告主题
 * @since 2021/7/6 11:23 下午
 */
@Component
public class DragonEggPriceSubject extends Observable {

    public void setMessage(Object o){
        this.setChanged();
        this.notifyObservers(o);
    }
}
```
##### 几个大人物（实际观察者）每个观察者都内置了一个注册被观察者的方法

```
import java.util.Observable;
import java.util.Observer;

/**
 * @author 贼不走空
 * @description
 * @since 2021/7/6 11:27 下午
 */
@Component
public class Observer1 implements Observer {

    private final static String NAME = "昊天宗宗主";
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
            System.out.println(NAME+"说：这个消息很重要，就算我们得不到也绝不能让武魂殿得到");
            System.out.println();
        }
        if (o instanceof DragonEggPriceSubject) {
            System.out.println(NAME+"说：十万魂币");
        }
    }
}
```

```
import java.util.Observable;
import java.util.Observer;

/**
 * @author 贼不走空
 * @description
 * @since 2021/7/6 11:27 下午
 */
@Component
public class Observer2 implements Observer {

    private final static String NAME = "武魂殿殿主";

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
            System.out.println(NAME+"说：龙蛋一定是我的");
            System.out.println();
        }
        if (o instanceof DragonEggPriceSubject) {
            System.out.println(NAME+"说：十一万魂币");
        }
    }
}

```

```
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
```

```
import java.util.Observable;
import java.util.Observer;

/**
 * @author 贼不走空
 * @description
 * @since 2021/7/6 11:27 下午
 */
@Component
public class Observer4 implements Observer {

    private final static String NAME = "蓝电霸王龙家族族长";

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
            System.out.println(NAME+"说：我们蓝电霸王龙家族如果得到龙蛋的话肯定可以更强大，这次就算赌上整个家族也一定要拿下");
            System.out.println(NAME+"说：传我命令，家族内所有值钱的资产三天内尽可能变卖，三天后一定要拿下龙蛋");
            System.out.println();
        }
        if (o instanceof DragonEggPriceSubject) {
            System.out.println(NAME+"说：十三万魂币");
        }
    }
}
```
##### 执行的代码也有一些相对的改变
###### 主要的变化就是不是直接往主题里添加对应的观察者了，改成了主题自己进行注册（主题也可以选择不注册）
```
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
        DragonEggAdvertisementSubject dragonEggAdvertisement = new DragonEggAdvertisementSubject();
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();
        Observer3 observer3 = new Observer3();
        Observer4 observer4 = new Observer4();
        observer1.registerSubject(dragonEggAdvertisement);
        observer2.registerSubject(dragonEggAdvertisement);
        observer3.registerSubject(dragonEggAdvertisement);
        observer4.registerSubject(dragonEggAdvertisement);
        Map<String,String> map = new HashMap<>();
        map.put("subject","贼不走空拍卖场广告部");
        map.put("body","龙蛋将于3天后拍卖");
        dragonEggAdvertisement.setMessage(JSONObject.toJSONString(map));
        Thread.sleep(3000);
        System.out.println("三天后,拍卖会如期举行。。。");
        DragonEggPriceSubject dragonEggPrice = new DragonEggPriceSubject();
        observer1.registerSubject(dragonEggPrice);
        observer2.registerSubject(dragonEggPrice);
        observer3.registerSubject(dragonEggPrice);
        observer4.registerSubject(dragonEggPrice);
        map.put("subject","贼不走空拍卖场一号技师");
        map.put("body",price+"");
        dragonEggPrice.setMessage(JSONObject.toJSONString(map));
        System.out.println("龙蛋之争就这样开始了");
    }
}
```
##### 最终执行的结果也和之前是一致的
```
贼不走空拍卖场通过他们独有的渠道获得了一个上古龙蛋，于是乎，他们打了很大的广告，希望各界人士前来参与拍卖

蓝电霸王龙家族族长看到了贼不走空拍卖场广告部的消息，内容是龙蛋将于3天后拍卖
蓝电霸王龙家族族长说：我们蓝电霸王龙家族如果得到龙蛋的话肯定可以更强大，这次就算赌上整个家族也一定要拿下
蓝电霸王龙家族族长说：传我命令，家族内所有值钱的资产三天内尽可能变卖，三天后一定要拿下龙蛋

七宝琉璃宗看到了贼不走空拍卖场广告部的消息，内容是龙蛋将于3天后拍卖
七宝琉璃宗说：上三宗论财力还是我们七宝琉璃宗第一，这次说什么也要阻止武魂殿，他们的野心实在太可怕了
七宝琉璃宗说：传我命令，三天之内，聚集所有可以聚集的资产，龙蛋我们一定要得到

武魂殿殿主看到了贼不走空拍卖场广告部的消息，内容是龙蛋将于3天后拍卖
武魂殿殿主说：龙蛋一定是我的

昊天宗宗主看到了贼不走空拍卖场广告部的消息，内容是龙蛋将于3天后拍卖
昊天宗宗主说：这个消息很重要，就算我们得不到也绝不能让武魂殿得到

三天后,拍卖会如期举行。。。
蓝电霸王龙家族族长看到了贼不走空拍卖场一号技师的消息，内容是100000
蓝电霸王龙家族族长说：十三万魂币
七宝琉璃宗看到了贼不走空拍卖场一号技师的消息，内容是100000
七宝琉璃宗说：十二万魂币
武魂殿殿主看到了贼不走空拍卖场一号技师的消息，内容是100000
武魂殿殿主说：十一万魂币
昊天宗宗主看到了贼不走空拍卖场一号技师的消息，内容是100000
昊天宗宗主说：十万魂币
龙蛋之争就这样开始了
```
可以看到，用jdk自带的可以让我们的代码更简洁，这里顺便贴一下被观察者调用的两个函数的源码，不然可能会有些疑问
- setChanged()
```
protected synchronized void setChanged() {
        changed = true;
    }
```
- notifyObservers(Object arg)
```
public void notifyObservers(Object arg) {
        Object[] arrLocal;
        synchronized (this) {
            if (!changed)
                return;
            arrLocal = obs.toArray();
            clearChanged();
        }
        for (int i = arrLocal.length-1; i>=0; i--)
            ((Observer)arrLocal[i]).update(this, arg);
    }
```
可以看到只是很简单的操作，在有变更以后再执行clearChanged()

```
protected synchronized void clearChanged() {
        changed = false;
    }
```
##### 好的，代码就这么多啦
## 观察者模式学习第六步：总结下观察者模式的优缺点
#### 优点
- 观察者和被观察者是抽象耦合的，这样就使得必须发生关系的类保持足够的灵活
- 观察者模式建立的是一种触发广播机制
#### 缺点
- 如果被观察者的观察者很多的话，全部通知一遍很耗时
- 实际开发场景中被观察者和观察者对象很有可能循环依赖
- 观察者只知道被观察者发生了变化，但是不知道为什么发生变化

## 扩展
观察者模式实际应用又可以分为两种模型
- 推模型：被观察者向观察者推送变化的详细信息，不管观察者是否需要，推送的信息通常是被观察对象的全部或全部变更数据。
- 拉模型：被观察对象在通知观察者的时候，只传递少量信息。如果观察者需要更具体的信息，由观察者主动到被观察对象中获取，相当于是观察者从被观察对象中拉数据。
  **注意：<font color=red>一般使用拉模型具体实现需要把被观察对象自身通过update()方法传递给观察者，这样在观察者需要获取数据的时候，就可以通过这个引用来获取了。</font>**

感兴趣的话可以自己代码实现下看看，不同的模式选择也是按照实际的场景进行处理的