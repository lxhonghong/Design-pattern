package com.lx.design_pattern.strategy_design_Pattern.example_after;

/*
 * @author 刘鑫
 * @since 2022/9/3 13:27
 * @description 非会员策略
 */
public class MembershipStrategyOhter extends MembershipStrategy{
    /**
     * 购物方法
     */
    @Override
    public void shopping() {
        System.out.println("您好，本店是VIP服务店，如果您需要的话我们可以帮您办理VIP充值业务");
    }
}
