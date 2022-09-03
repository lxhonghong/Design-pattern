package com.lx.design_pattern.strategy_design_Pattern.example_after;

/*
 * @author 刘鑫
 * @since 2022/9/3 13:27
 * @description 黄金策略
 */
public class MembershipStrategyHJ extends MembershipStrategy{

    /**
     * 购物方法
     */
    @Override
    public void shopping() {
        System.out.println("尊贵的黄金VIP您好，欢迎您来到本店消费，如果您有什么需要，请到服务台咨询");
        System.out.println("作为黄金VIP会员，您在本店的所有消费均享受95折优惠");
        System.out.println("作为黄金VIP会员，您本次消费后请稍作休息，本店会将您的宝马325赠品为您准备好");
    }
}
