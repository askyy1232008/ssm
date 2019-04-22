package com.lee.pojo;

import java.util.Date;

public class Truck {
    private Integer truckid;

    private String truckingcompany;

    private String licenseplate;

    private String istrailer;

    private String trailerlicensepate;

    private String vehicletypes;

    private String vehicletype;

    private String vehiclebrand;

    private String vehiclecolor;

    private Date recorddate;

    private String vehicleownerarea;

    private String terestaccrual;

    private Date drivinglicense;

    private Date operationcertificate;

    private Date nextmaintain;

    private String maintenancecost;

    private String gps;

    private String gpsremarks;

    private String beidouinstrument;

    private String beidouinstrumentremarks;

    private Date compulsoryinsurancetime;

    private String compulsoryinsurancecompany;

    private Float compulsoryinsurancecost;

    private Date commercialinsurancetime;

    private String commercialinsurancecompany;

    private Float commercialinsurancecost;

    private String commercialinsurancetypes;

    private String drivermessage;

    private String vehicleremarks;

    private String trucktype;

    private String vin;

    private String enginenumber;

    private String gcontainersize;

    private String axlenumber;

    private String registrationcertificatenumber;

    private String authenticatedloadquality;

    private String curbweight;

    private String appearance;

    private String horsepower;

    private String enginemodel;

    private String totalmass;

    private String speedratio;

    private String tyre;

    private String compulsoryinsurcancetypequota;

    private String compulsoryinsurcancenumber;

    private String commercialinsurancenumber;

    private String gvin;

    private String gregistrationcertificatenumber;

    private Date grecorddate;

    private String gvehiclebrand;

    private String gtrucktype;

    private String gvehicletype;

    private String gvehiclecolor;

    private String gauthenticatedloadquality;

    private String gcurbweight;

    private String gtotalmass;

    private String grearaxle;

    private String gappearance;

    private String gtyre;

    private String gsparetire;

    private String gcommercialinsurancetypequota;

    private String gcommercialinsurancenumber;

    private String gcommercialinsurancecompany;

    private String gcommercialinsurancecost;

    private Date gdrivinglicense;

    private Date goperationcertificate;

    private Date gcommercialinsurancedate;
    
    private TruckOwner truckOwner;
    

    public TruckOwner getTruckOwner() {
		return truckOwner;
	}

	public void setTruckOwner(TruckOwner truckOwner) {
		this.truckOwner = truckOwner;
	}

	public Integer getTruckid() {
        return truckid;
    }

    public void setTruckid(Integer truckid) {
        this.truckid = truckid;
    }

    public String getTruckingcompany() {
        return truckingcompany;
    }

    public void setTruckingcompany(String truckingcompany) {
        this.truckingcompany = truckingcompany == null ? null : truckingcompany.trim();
    }

    public String getLicenseplate() {
        return licenseplate;
    }

    public void setLicenseplate(String licenseplate) {
        this.licenseplate = licenseplate == null ? null : licenseplate.trim();
    }

    public String getIstrailer() {
        return istrailer;
    }

    public void setIstrailer(String istrailer) {
        this.istrailer = istrailer == null ? null : istrailer.trim();
    }

    public String getTrailerlicensepate() {
        return trailerlicensepate;
    }

    public void setTrailerlicensepate(String trailerlicensepate) {
        this.trailerlicensepate = trailerlicensepate == null ? null : trailerlicensepate.trim();
    }

    public String getVehicletypes() {
        return vehicletypes;
    }

    public void setVehicletypes(String vehicletypes) {
        this.vehicletypes = vehicletypes == null ? null : vehicletypes.trim();
    }

    public String getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(String vehicletype) {
        this.vehicletype = vehicletype == null ? null : vehicletype.trim();
    }

    public String getVehiclebrand() {
        return vehiclebrand;
    }

    public void setVehiclebrand(String vehiclebrand) {
        this.vehiclebrand = vehiclebrand == null ? null : vehiclebrand.trim();
    }

    public String getVehiclecolor() {
        return vehiclecolor;
    }

    public void setVehiclecolor(String vehiclecolor) {
        this.vehiclecolor = vehiclecolor == null ? null : vehiclecolor.trim();
    }

    public Date getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(Date recorddate) {
        this.recorddate = recorddate;
    }

    public String getVehicleownerarea() {
        return vehicleownerarea;
    }

    public void setVehicleownerarea(String vehicleownerarea) {
        this.vehicleownerarea = vehicleownerarea == null ? null : vehicleownerarea.trim();
    }

    public String getTerestaccrual() {
        return terestaccrual;
    }

    public void setTerestaccrual(String terestaccrual) {
        this.terestaccrual = terestaccrual == null ? null : terestaccrual.trim();
    }

    public Date getDrivinglicense() {
        return drivinglicense;
    }

    public void setDrivinglicense(Date drivinglicense) {
        this.drivinglicense = drivinglicense;
    }

    public Date getOperationcertificate() {
        return operationcertificate;
    }

    public void setOperationcertificate(Date operationcertificate) {
        this.operationcertificate = operationcertificate;
    }

    public Date getNextmaintain() {
        return nextmaintain;
    }

    public void setNextmaintain(Date nextmaintain) {
        this.nextmaintain = nextmaintain;
    }

    public String getMaintenancecost() {
        return maintenancecost;
    }

    public void setMaintenancecost(String maintenancecost) {
        this.maintenancecost = maintenancecost == null ? null : maintenancecost.trim();
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps == null ? null : gps.trim();
    }

    public String getGpsremarks() {
        return gpsremarks;
    }

    public void setGpsremarks(String gpsremarks) {
        this.gpsremarks = gpsremarks == null ? null : gpsremarks.trim();
    }

    public String getBeidouinstrument() {
        return beidouinstrument;
    }

    public void setBeidouinstrument(String beidouinstrument) {
        this.beidouinstrument = beidouinstrument == null ? null : beidouinstrument.trim();
    }

    public String getBeidouinstrumentremarks() {
        return beidouinstrumentremarks;
    }

    public void setBeidouinstrumentremarks(String beidouinstrumentremarks) {
        this.beidouinstrumentremarks = beidouinstrumentremarks == null ? null : beidouinstrumentremarks.trim();
    }

    public Date getCompulsoryinsurancetime() {
        return compulsoryinsurancetime;
    }

    public void setCompulsoryinsurancetime(Date compulsoryinsurancetime) {
        this.compulsoryinsurancetime = compulsoryinsurancetime;
    }

    public String getCompulsoryinsurancecompany() {
        return compulsoryinsurancecompany;
    }

    public void setCompulsoryinsurancecompany(String compulsoryinsurancecompany) {
        this.compulsoryinsurancecompany = compulsoryinsurancecompany == null ? null : compulsoryinsurancecompany.trim();
    }

    public Float getCompulsoryinsurancecost() {
        return compulsoryinsurancecost;
    }

    public void setCompulsoryinsurancecost(Float compulsoryinsurancecost) {
        this.compulsoryinsurancecost = compulsoryinsurancecost;
    }

    public Date getCommercialinsurancetime() {
        return commercialinsurancetime;
    }

    public void setCommercialinsurancetime(Date commercialinsurancetime) {
        this.commercialinsurancetime = commercialinsurancetime;
    }

    public String getCommercialinsurancecompany() {
        return commercialinsurancecompany;
    }

    public void setCommercialinsurancecompany(String commercialinsurancecompany) {
        this.commercialinsurancecompany = commercialinsurancecompany == null ? null : commercialinsurancecompany.trim();
    }

    public Float getCommercialinsurancecost() {
        return commercialinsurancecost;
    }

    public void setCommercialinsurancecost(Float commercialinsurancecost) {
        this.commercialinsurancecost = commercialinsurancecost;
    }

    public String getCommercialinsurancetypes() {
        return commercialinsurancetypes;
    }

    public void setCommercialinsurancetypes(String commercialinsurancetypes) {
        this.commercialinsurancetypes = commercialinsurancetypes == null ? null : commercialinsurancetypes.trim();
    }

    public String getDrivermessage() {
        return drivermessage;
    }

    public void setDrivermessage(String drivermessage) {
        this.drivermessage = drivermessage == null ? null : drivermessage.trim();
    }

    public String getVehicleremarks() {
        return vehicleremarks;
    }

    public void setVehicleremarks(String vehicleremarks) {
        this.vehicleremarks = vehicleremarks == null ? null : vehicleremarks.trim();
    }

    public String getTrucktype() {
        return trucktype;
    }

    public void setTrucktype(String trucktype) {
        this.trucktype = trucktype == null ? null : trucktype.trim();
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin == null ? null : vin.trim();
    }

    public String getEnginenumber() {
        return enginenumber;
    }

    public void setEnginenumber(String enginenumber) {
        this.enginenumber = enginenumber == null ? null : enginenumber.trim();
    }

    public String getGcontainersize() {
        return gcontainersize;
    }

    public void setGcontainersize(String gcontainersize) {
        this.gcontainersize = gcontainersize == null ? null : gcontainersize.trim();
    }

    public String getAxlenumber() {
        return axlenumber;
    }

    public void setAxlenumber(String axlenumber) {
        this.axlenumber = axlenumber == null ? null : axlenumber.trim();
    }

    public String getRegistrationcertificatenumber() {
        return registrationcertificatenumber;
    }

    public void setRegistrationcertificatenumber(String registrationcertificatenumber) {
        this.registrationcertificatenumber = registrationcertificatenumber == null ? null : registrationcertificatenumber.trim();
    }

    public String getAuthenticatedloadquality() {
        return authenticatedloadquality;
    }

    public void setAuthenticatedloadquality(String authenticatedloadquality) {
        this.authenticatedloadquality = authenticatedloadquality == null ? null : authenticatedloadquality.trim();
    }

    public String getCurbweight() {
        return curbweight;
    }

    public void setCurbweight(String curbweight) {
        this.curbweight = curbweight == null ? null : curbweight.trim();
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance == null ? null : appearance.trim();
    }

    public String getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(String horsepower) {
        this.horsepower = horsepower == null ? null : horsepower.trim();
    }

    public String getEnginemodel() {
        return enginemodel;
    }

    public void setEnginemodel(String enginemodel) {
        this.enginemodel = enginemodel == null ? null : enginemodel.trim();
    }

    public String getTotalmass() {
        return totalmass;
    }

    public void setTotalmass(String totalmass) {
        this.totalmass = totalmass == null ? null : totalmass.trim();
    }

    public String getSpeedratio() {
        return speedratio;
    }

    public void setSpeedratio(String speedratio) {
        this.speedratio = speedratio == null ? null : speedratio.trim();
    }

    public String getTyre() {
        return tyre;
    }

    public void setTyre(String tyre) {
        this.tyre = tyre == null ? null : tyre.trim();
    }

    public String getCompulsoryinsurcancetypequota() {
        return compulsoryinsurcancetypequota;
    }

    public void setCompulsoryinsurcancetypequota(String compulsoryinsurcancetypequota) {
        this.compulsoryinsurcancetypequota = compulsoryinsurcancetypequota == null ? null : compulsoryinsurcancetypequota.trim();
    }

    public String getCompulsoryinsurcancenumber() {
        return compulsoryinsurcancenumber;
    }

    public void setCompulsoryinsurcancenumber(String compulsoryinsurcancenumber) {
        this.compulsoryinsurcancenumber = compulsoryinsurcancenumber == null ? null : compulsoryinsurcancenumber.trim();
    }

    public String getCommercialinsurancenumber() {
        return commercialinsurancenumber;
    }

    public void setCommercialinsurancenumber(String commercialinsurancenumber) {
        this.commercialinsurancenumber = commercialinsurancenumber == null ? null : commercialinsurancenumber.trim();
    }

    public String getGvin() {
        return gvin;
    }

    public void setGvin(String gvin) {
        this.gvin = gvin == null ? null : gvin.trim();
    }

    public String getGregistrationcertificatenumber() {
        return gregistrationcertificatenumber;
    }

    public void setGregistrationcertificatenumber(String gregistrationcertificatenumber) {
        this.gregistrationcertificatenumber = gregistrationcertificatenumber == null ? null : gregistrationcertificatenumber.trim();
    }

    public Date getGrecorddate() {
        return grecorddate;
    }

    public void setGrecorddate(Date grecorddate) {
        this.grecorddate = grecorddate;
    }

    public String getGvehiclebrand() {
        return gvehiclebrand;
    }

    public void setGvehiclebrand(String gvehiclebrand) {
        this.gvehiclebrand = gvehiclebrand == null ? null : gvehiclebrand.trim();
    }

    public String getGtrucktype() {
        return gtrucktype;
    }

    public void setGtrucktype(String gtrucktype) {
        this.gtrucktype = gtrucktype == null ? null : gtrucktype.trim();
    }

    public String getGvehicletype() {
        return gvehicletype;
    }

    public void setGvehicletype(String gvehicletype) {
        this.gvehicletype = gvehicletype == null ? null : gvehicletype.trim();
    }

    public String getGvehiclecolor() {
        return gvehiclecolor;
    }

    public void setGvehiclecolor(String gvehiclecolor) {
        this.gvehiclecolor = gvehiclecolor == null ? null : gvehiclecolor.trim();
    }

    public String getGauthenticatedloadquality() {
        return gauthenticatedloadquality;
    }

    public void setGauthenticatedloadquality(String gauthenticatedloadquality) {
        this.gauthenticatedloadquality = gauthenticatedloadquality == null ? null : gauthenticatedloadquality.trim();
    }

    public String getGcurbweight() {
        return gcurbweight;
    }

    public void setGcurbweight(String gcurbweight) {
        this.gcurbweight = gcurbweight == null ? null : gcurbweight.trim();
    }

    public String getGtotalmass() {
        return gtotalmass;
    }

    public void setGtotalmass(String gtotalmass) {
        this.gtotalmass = gtotalmass == null ? null : gtotalmass.trim();
    }

    public String getGrearaxle() {
        return grearaxle;
    }

    public void setGrearaxle(String grearaxle) {
        this.grearaxle = grearaxle == null ? null : grearaxle.trim();
    }

    public String getGappearance() {
        return gappearance;
    }

    public void setGappearance(String gappearance) {
        this.gappearance = gappearance == null ? null : gappearance.trim();
    }

    public String getGtyre() {
        return gtyre;
    }

    public void setGtyre(String gtyre) {
        this.gtyre = gtyre == null ? null : gtyre.trim();
    }

    public String getGsparetire() {
        return gsparetire;
    }

    public void setGsparetire(String gsparetire) {
        this.gsparetire = gsparetire == null ? null : gsparetire.trim();
    }

    public String getGcommercialinsurancetypequota() {
        return gcommercialinsurancetypequota;
    }

    public void setGcommercialinsurancetypequota(String gcommercialinsurancetypequota) {
        this.gcommercialinsurancetypequota = gcommercialinsurancetypequota == null ? null : gcommercialinsurancetypequota.trim();
    }

    public String getGcommercialinsurancenumber() {
        return gcommercialinsurancenumber;
    }

    public void setGcommercialinsurancenumber(String gcommercialinsurancenumber) {
        this.gcommercialinsurancenumber = gcommercialinsurancenumber == null ? null : gcommercialinsurancenumber.trim();
    }

    public String getGcommercialinsurancecompany() {
        return gcommercialinsurancecompany;
    }

    public void setGcommercialinsurancecompany(String gcommercialinsurancecompany) {
        this.gcommercialinsurancecompany = gcommercialinsurancecompany == null ? null : gcommercialinsurancecompany.trim();
    }

    public String getGcommercialinsurancecost() {
        return gcommercialinsurancecost;
    }

    public void setGcommercialinsurancecost(String gcommercialinsurancecost) {
        this.gcommercialinsurancecost = gcommercialinsurancecost == null ? null : gcommercialinsurancecost.trim();
    }

    public Date getGdrivinglicense() {
        return gdrivinglicense;
    }

    public void setGdrivinglicense(Date gdrivinglicense) {
        this.gdrivinglicense = gdrivinglicense;
    }

    public Date getGoperationcertificate() {
        return goperationcertificate;
    }

    public void setGoperationcertificate(Date goperationcertificate) {
        this.goperationcertificate = goperationcertificate;
    }

    public Date getGcommercialinsurancedate() {
        return gcommercialinsurancedate;
    }

    public void setGcommercialinsurancedate(Date gcommercialinsurancedate) {
        this.gcommercialinsurancedate = gcommercialinsurancedate;
    }
}