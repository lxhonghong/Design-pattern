package com.lx.design_pattern.strategy_design_Pattern;

/*
 * @author 刘鑫
 * @since 2022/9/3 11:53
 * @description 简单测试实验
 */
public class StrategyTest {
    public static void main(String[] args) {
        Context context = new Context(new StrategyImplA());
        context.doMethod();

        context = new Context(new StrategyImplB());
        context.doMethod();

        context = new Context(new StrategyImplC());
        context.doMethod();
    }
}
