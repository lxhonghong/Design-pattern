package com.lx.design_pattern.strategy_design_Pattern.example_before;

import org.springframework.util.StringUtils;

import java.util.Objects;

/*
 * @author 刘鑫
 * @since 2022/9/3 13:01
 * @description
 */
public class Before {

    /**
     * 会员等级
     */
    private String membershipLevel;

    /**
     * 欢迎语
     */
    private String welcome;

    /**
     * 折扣
     */
    private Integer discount;

    /**
     * 赠品
     */
    private String gift;

    public Before(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public void shopping(){
        String membershipLevel = getMembershipLevel();
        if ("钻石".equals(membershipLevel)) {
            setWelcome("尊贵的钻石VIP您好，欢迎您来到本店消费，我是您的专属客服经理XXX，我和我的团队将精心为您服务");
            setGift("劳斯莱斯幻影");
            setDiscount(8);
        } else if ("铂金".equals(membershipLevel)) {
            setWelcome("尊贵的铂金VIP您好，欢迎您来到本店消费，我是您的专属客服XXX");
            setGift("保时捷718");
            setDiscount(85);
        } else if ("黄金".equals(membershipLevel)) {
            setWelcome("尊贵的黄金VIP您好，欢迎您来到本店消费，如果您有什么需要，请到服务台咨询");
            setGift("宝马325");
            setDiscount(95);
        } else {
            setWelcome("您好，本店是VIP服务店，如果您需要的话我们可以帮您办理VIP充值业务");
            setGift(null);
            setDiscount(null);
        }
        System.out.println(getWelcome());
        if (!Objects.isNull(getDiscount())) {
            System.out.println("作为"+membershipLevel+"VIP会员，您在本店的所有消费均享受"+getDiscount()+"折优惠");
        }

        if (!Objects.isNull(getGift())) {
            System.out.println("作为"+membershipLevel+"VIP会员，您本次消费后请稍作休息，本店会将您的"+getGift()+"赠品为您准备好");
        }
    }
}
