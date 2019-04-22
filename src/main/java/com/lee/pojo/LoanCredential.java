package com.lee.pojo;

import java.util.Date;

public class LoanCredential {
    private Integer id;

    private Integer truckid;

    private String loanpeople;

    private String financecompany;

    private Date loandate;

    private Double loanmoney;

    private Double moneyrate;

    private Double grossinterest;

    private Double loanservicecharge;

    private String loanservicechargemark;

    private Double othercost;

    private String othercostmark;

    private Double bond;

    private Double actual;

    private Double monthlyrepayment;

    private Integer trem;

    private String vin;

    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTruckid() {
        return truckid;
    }

    public void setTruckid(Integer truckid) {
        this.truckid = truckid;
    }

    public String getLoanpeople() {
        return loanpeople;
    }

    public void setLoanpeople(String loanpeople) {
        this.loanpeople = loanpeople == null ? null : loanpeople.trim();
    }

    public String getFinancecompany() {
        return financecompany;
    }

    public void setFinancecompany(String financecompany) {
        this.financecompany = financecompany == null ? null : financecompany.trim();
    }

    public Date getLoandate() {
        return loandate;
    }

    public void setLoandate(Date loandate) {
        this.loandate = loandate;
    }

    public Double getLoanmoney() {
        return loanmoney;
    }

    public void setLoanmoney(Double loanmoney) {
        this.loanmoney = loanmoney;
    }

    public Double getMoneyrate() {
        return moneyrate;
    }

    public void setMoneyrate(Double moneyrate) {
        this.moneyrate = moneyrate;
    }

    public Double getGrossinterest() {
        return grossinterest;
    }

    public void setGrossinterest(Double grossinterest) {
        this.grossinterest = grossinterest;
    }

    public Double getLoanservicecharge() {
        return loanservicecharge;
    }

    public void setLoanservicecharge(Double loanservicecharge) {
        this.loanservicecharge = loanservicecharge;
    }

    public String getLoanservicechargemark() {
        return loanservicechargemark;
    }

    public void setLoanservicechargemark(String loanservicechargemark) {
        this.loanservicechargemark = loanservicechargemark == null ? null : loanservicechargemark.trim();
    }

    public Double getOthercost() {
        return othercost;
    }

    public void setOthercost(Double othercost) {
        this.othercost = othercost;
    }

    public String getOthercostmark() {
        return othercostmark;
    }

    public void setOthercostmark(String othercostmark) {
        this.othercostmark = othercostmark == null ? null : othercostmark.trim();
    }

    public Double getBond() {
        return bond;
    }

    public void setBond(Double bond) {
        this.bond = bond;
    }

    public Double getActual() {
        return actual;
    }

    public void setActual(Double actual) {
        this.actual = actual;
    }

    public Double getMonthlyrepayment() {
        return monthlyrepayment;
    }

    public void setMonthlyrepayment(Double monthlyrepayment) {
        this.monthlyrepayment = monthlyrepayment;
    }

    public Integer getTrem() {
        return trem;
    }

    public void setTrem(Integer trem) {
        this.trem = trem;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin == null ? null : vin.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}