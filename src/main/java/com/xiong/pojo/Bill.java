package com.xiong.pojo;

import java.math.BigDecimal;

/**
 * Created by gonghui on 2017/11/23.
 */
public class Bill {
    private Integer billId;
    private String userId;
    private Integer type;
    private BigDecimal preAcount;
    private BigDecimal afAcount;
    private BigDecimal transAcount;

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setPreAcount(BigDecimal preAcount) {
        this.preAcount = preAcount;
    }

    public void setAfAcount(BigDecimal afAcount) {
        this.afAcount = afAcount;
    }

    public void setTransAcount(BigDecimal transAcount) {
        this.transAcount = transAcount;
    }

    public Integer getBillId() {
        return billId;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getType() {
        return type;
    }

    public BigDecimal getPreAcount() {
        return preAcount;
    }

    public BigDecimal getAfAcount() {
        return afAcount;
    }

    public BigDecimal getTransAcount() {
        return transAcount;
    }
}
