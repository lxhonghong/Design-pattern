package com.lx.design_pattern.singleton;

/**
 * @author 刘鑫
 * @description
 * @since 2019/11/19 9:29 下午
 */
public class Singleton3 {
    private static Singleton3 instance = null;

    private Singleton3() {
    }

    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new Singleton3();
        }
    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }
}
