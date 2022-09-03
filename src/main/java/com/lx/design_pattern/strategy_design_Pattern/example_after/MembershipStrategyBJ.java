package com.lx.design_pattern.strategy_design_Pattern.example_after;

/*
 * @author 刘鑫
 * @since 2022/9/3 13:27
 * @description 铂金策略
 */
public class MembershipStrategyBJ extends MembershipStrategy{

    /**
     * 购物方法
     */
    @Override
    public void shopping() {
        System.out.println("尊贵的铂金VIP您好，欢迎您来到本店消费，我是您的专属客服XXX");
        System.out.println("作为铂金VIP会员，您在本店的所有消费均享受85折优惠");
        System.out.println("作为铂金VIP会员，您本次消费后请稍作休息，本店会将您的保时捷718赠品为您准备好");
    }
}
