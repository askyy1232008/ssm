package com.lee.pojo;

public class TruckOwner {
    private Integer id;

    private Integer truckid;

    private String name;

    private String phone;

    private String adress;

    private String number;

    private String issingle;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

	public String getIssingle() {
		return issingle;
	}

	public void setIssingle(String issingle) {
		this.issingle = issingle;
	}

    
}