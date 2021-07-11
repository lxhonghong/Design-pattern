package com.lx.design_pattern.singleton;

/**
 * @author 贼不走空
 * @description
 * @since 2019/11/18 10:17 下午
 */
public class Singleton1 {

    /**
     * 私有构造方法，防止被实例化
     */
    private Singleton1() {
    }

    /**
     * 此处使用一个内部类来维护单例
     */
    private static class SingletonFactory {
        private static Singleton1 instance = new Singleton1();
    }

    /**
     * 获取实例
     */
    public static Singleton1 getInstance() {
        return SingletonFactory.instance;
    }

    /**
     * 如果该对象被用于序列化，可以保证对象在序列化前后保持一致
     */
    public Object readResolve() {
        return getInstance();
    }
    /**
     * 其实说它完美，也不一定，如果在构造函数中抛出异常，实例将永远得不到创建，也会出错。
     * 所以说，十分完美的东西是没有的，我们只能根据实际情况，选择最适合自己应用场景的实现方法。
     *
     * 也有人这样实现：因为我们只需要在创建类的时候进行同步，所以只要将创建和getInstance()分开，单独为创建加synchronized关键字，也是可以的：
     * {@link Singleton3}
     */
}
