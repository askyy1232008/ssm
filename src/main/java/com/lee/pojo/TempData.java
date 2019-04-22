package com.lee.pojo;

import java.util.Date;

public class TempData {
    private Integer id;

    private String tempdata;

    private Date sreachtime;

    private Date starttime;

    private Date endtime;

    private String licenseplate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTempdata() {
        return tempdata;
    }

    public void setTempdata(String tempdata) {
        this.tempdata = tempdata == null ? null : tempdata.trim();
    }

    public Date getSreachtime() {
        return sreachtime;
    }

    public void setSreachtime(Date sreachtime) {
        this.sreachtime = sreachtime;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getLicenseplate() {
        return licenseplate;
    }

    public void setLicenseplate(String licenseplate) {
        this.licenseplate = licenseplate == null ? null : licenseplate.trim();
    }
}