package com.lx.design_pattern.strategy_design_Pattern.example_after;

/*
 * @author 刘鑫
 * @since 2022/9/3 13:40
 * @description 会员环境（上下文）
 */
public class MembershipContext {

    private MembershipStrategy membershipStrategy;

    public MembershipContext() {
    }

    public MembershipContext(MembershipStrategy membershipStrategy) {
        this.membershipStrategy = membershipStrategy;
    }

    public void shopping(){
        membershipStrategy.shopping();
    }
}
