package com.lee.pojo;

import java.util.Date;

public class Settlement {
    private Integer id;

    private Date settlementdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSettlementdate() {
        return settlementdate;
    }

    public void setSettlementdate(Date settlementdate) {
        this.settlementdate = settlementdate;
    }
}