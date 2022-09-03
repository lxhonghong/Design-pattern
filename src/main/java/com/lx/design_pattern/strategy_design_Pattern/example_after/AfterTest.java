package com.lx.design_pattern.strategy_design_Pattern.example_after;

/*
 * @author 刘鑫
 * @since 2022/9/3 13:42
 * @description
 */
public class AfterTest {

    public static void main(String[] args) {
        MembershipContext zs = new MembershipContext(new MembershipStrategyZS());
        zs.shopping();

        MembershipContext bj = new MembershipContext(new MembershipStrategyBJ());
        bj.shopping();

        MembershipContext hj = new MembershipContext(new MembershipStrategyHJ());
        hj.shopping();

        MembershipContext context = new MembershipContext(new MembershipStrategyOhter());
        context.shopping();
    }
}
