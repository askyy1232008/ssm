package com.lee.pojo;

import java.util.Date;

public class PayLog {
    private Integer id;

    private Integer truckid;

    private Integer voucherid;

    private String licenseplate;

    private String trailerlicensepate;

    private Date paydate;

    private Float sum;

    private Float pay;

    private Float payed;

    private Boolean finished;

    private Boolean logit;

    private String remarks;

    private Date insertdate;

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

    public Integer getVoucherid() {
        return voucherid;
    }

    public void setVoucherid(Integer voucherid) {
        this.voucherid = voucherid;
    }

    public String getLicenseplate() {
        return licenseplate;
    }

    public void setLicenseplate(String licenseplate) {
        this.licenseplate = licenseplate == null ? null : licenseplate.trim();
    }

    public String getTrailerlicensepate() {
        return trailerlicensepate;
    }

    public void setTrailerlicensepate(String trailerlicensepate) {
        this.trailerlicensepate = trailerlicensepate == null ? null : trailerlicensepate.trim();
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }

    public Float getPay() {
        return pay;
    }

    public void setPay(Float pay) {
        this.pay = pay;
    }

    public Float getPayed() {
        return payed;
    }

    public void setPayed(Float payed) {
        this.payed = payed;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Boolean getLogit() {
        return logit;
    }

    public void setLogit(Boolean logit) {
        this.logit = logit;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(Date insertdate) {
        this.insertdate = insertdate;
    }
}