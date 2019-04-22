package com.lee.pojo;

import java.util.Date;

public class LoanLog {
    private Integer id;

    private Double totalrepayment;

    private Double thatmonthhasreturned;

    private Date payeddate;

    private Double accumulatedrepayment;

    private Double surplusshouldalsobereturned;

    private Integer loanid;

    private Integer truckid;

    private String remark;

    private Double nowpay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalrepayment() {
        return totalrepayment;
    }

    public void setTotalrepayment(Double totalrepayment) {
        this.totalrepayment = totalrepayment;
    }

    public Double getThatmonthhasreturned() {
        return thatmonthhasreturned;
    }

    public void setThatmonthhasreturned(Double thatmonthhasreturned) {
        this.thatmonthhasreturned = thatmonthhasreturned;
    }

    public Date getPayeddate() {
        return payeddate;
    }

    public void setPayeddate(Date payeddate) {
        this.payeddate = payeddate;
    }

    public Double getAccumulatedrepayment() {
        return accumulatedrepayment;
    }

    public void setAccumulatedrepayment(Double accumulatedrepayment) {
        this.accumulatedrepayment = accumulatedrepayment;
    }

    public Double getSurplusshouldalsobereturned() {
        return surplusshouldalsobereturned;
    }

    public void setSurplusshouldalsobereturned(Double surplusshouldalsobereturned) {
        this.surplusshouldalsobereturned = surplusshouldalsobereturned;
    }

    public Integer getLoanid() {
        return loanid;
    }

    public void setLoanid(Integer loanid) {
        this.loanid = loanid;
    }

    public Integer getTruckid() {
        return truckid;
    }

    public void setTruckid(Integer truckid) {
        this.truckid = truckid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Double getNowpay() {
        return nowpay;
    }

    public void setNowpay(Double nowpay) {
        this.nowpay = nowpay;
    }
}