package com.lx.design_pattern.strategy_design_Pattern.example_before;

/*
 * @author 刘鑫
 * @since 2022/9/3 13:17
 * @description
 */
public class BeforeTest {

    public static void main(String[] args) {
        Before zs = new Before("钻石");
        zs.shopping();
        System.out.println();
        System.out.println();
        System.out.println();

        Before bj = new Before("铂金");
        bj.shopping();
        System.out.println();
        System.out.println();
        System.out.println();

        Before hj = new Before("黄金");
        hj.shopping();
        System.out.println();
        System.out.println();
        System.out.println();

        Before pt = new Before("普通");
        pt.shopping();
    }
}
