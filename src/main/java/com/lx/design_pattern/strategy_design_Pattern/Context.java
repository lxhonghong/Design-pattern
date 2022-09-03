package com.lx.design_pattern.strategy_design_Pattern;

/*
 * @author 刘鑫
 * @since 2022/9/3 11:52
 * @description
 */
public class Context {

    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doMethod(){
        strategy.strategy();
    }

}
