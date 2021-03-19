package com.study.dubbo.model;

import java.io.Serializable;

/**
 * @author Hash
 * @since 2021/2/12
 */
public class OrderModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 订单类型*/
    private int orderType;

    /** 用户ID*/
    private String userId;

    /** 订单名称*/
    private String orderName;

    /** 订单编号*/
    private String orderNo;

    @Override
    public String toString() {
        return "OrderModel{" +
                "orderType=" + orderType +
                ", userId='" + userId + '\'' +
                ", orderName='" + orderName + '\'' +
                ", orderNo='" + orderNo + '\'' +
                '}';
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
