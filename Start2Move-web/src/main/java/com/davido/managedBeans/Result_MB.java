/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davido.managedBeans;

import com.davido.ejb.DbDistrictFacadeLocal;
import com.davido.ejb.DbHospitalFacadeLocal;
import com.davido.ejb.DbLocalityFacadeLocal;
import com.davido.ejb.DbMunicipalityFacadeLocal;
import com.davido.ejb.DbRegionFacadeLocal;
import com.davido.ejb.DbSchoolFacadeLocal;
import com.davido.ejb.DbUserFacadeLocal;
import com.davido.ejb.DbViewFacadeLocal;
import com.davido.ejb.DbWardFacadeLocal;
import com.davido.ejb.DbbusStopFacadeLocal;
import com.davido.ejb.DbcrimeRateFacadeLocal;
import com.davido.ejb.DbhouseBuyingFacadeLocal;
import com.davido.ejb.DbhouseRentFacadeLocal;
import com.davido.ejb.DblandPriceFacadeLocal;
import com.davido.ejb.DbpostCodeFacadeLocal;
import com.davido.ejb.DbtrainStationFacadeLocal;
import com.davido.entities.DbHospital;
import com.davido.entities.DbSchool;
import com.davido.entities.DbbusStop;
import com.davido.entities.DbcrimeRate;
import com.davido.entities.DbhouseBuying;
import com.davido.entities.DbhouseRent;
import com.davido.entities.DblandPrice;
import com.davido.entities.DbtrainStation;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author davidortega
 */

@Named(value = "result_MB")
@ViewScoped
public class Result_MB implements Serializable {

    @EJB
    private DbbusStopFacadeLocal dbbusStopFacade;

    @EJB
    private DbtrainStationFacadeLocal dbtrainStationFacade;

    @EJB
    private DbpostCodeFacadeLocal dbpostCodeFacade;

    @EJB
    private DblandPriceFacadeLocal dblandPriceFacade;

    @EJB
    private DbhouseRentFacadeLocal dbhouseRentFacade;

    @EJB
    private DbhouseBuyingFacadeLocal dbhouseBuyingFacade;

    @EJB
    private DbcrimeRateFacadeLocal dbcrimeRateFacade;

    @EJB
    private DbWardFacadeLocal dbWardFacade;

    @EJB
    private DbViewFacadeLocal dbViewFacade;

    @EJB
    private DbUserFacadeLocal dbUserFacade;

    @EJB
    private DbSchoolFacadeLocal dbSchoolFacade;

    @EJB
    private DbRegionFacadeLocal dbRegionFacade;

    @EJB
    private DbMunicipalityFacadeLocal dbMunicipalityFacade;

    @EJB
    private DbLocalityFacadeLocal dbLocalityFacade;

    @EJB
    private DbHospitalFacadeLocal dbHospitalFacade;

    @EJB
    private DbDistrictFacadeLocal dbDistrictFacade;

    private String postCodeSuggested;

    public String getPostCodeSuggested() {
        return postCodeSuggested;
    }

    public void setPostCodeSuggested(String postCodeSuggested) {
        this.postCodeSuggested = postCodeSuggested;
    }

    public DbtrainStationFacadeLocal getDbtrainStationFacade() {
        return dbtrainStationFacade;
    }

    public void setDbtrainStationFacade(DbtrainStationFacadeLocal dbtrainStationFacade) {
        this.dbtrainStationFacade = dbtrainStationFacade;
    }

    public DbpostCodeFacadeLocal getDbpostCodeFacade() {
        return dbpostCodeFacade;
    }

    public void setDbpostCodeFacade(DbpostCodeFacadeLocal dbpostCodeFacade) {
        this.dbpostCodeFacade = dbpostCodeFacade;
    }

    public DblandPriceFacadeLocal getDblandPriceFacade() {
        return dblandPriceFacade;
    }

    public void setDblandPriceFacade(DblandPriceFacadeLocal dblandPriceFacade) {
        this.dblandPriceFacade = dblandPriceFacade;
    }

    public DbhouseRentFacadeLocal getDbhouseRentFacade() {
        return dbhouseRentFacade;
    }

    public void setDbhouseRentFacade(DbhouseRentFacadeLocal dbhouseRentFacade) {
        this.dbhouseRentFacade = dbhouseRentFacade;
    }

    public DbhouseBuyingFacadeLocal getDbhouseBuyingFacade() {
        return dbhouseBuyingFacade;
    }

    public void setDbhouseBuyingFacade(DbhouseBuyingFacadeLocal dbhouseBuyingFacade) {
        this.dbhouseBuyingFacade = dbhouseBuyingFacade;
    }

    public DbcrimeRateFacadeLocal getDbcrimeRateFacade() {
        return dbcrimeRateFacade;
    }

    public void setDbcrimeRateFacade(DbcrimeRateFacadeLocal dbcrimeRateFacade) {
        this.dbcrimeRateFacade = dbcrimeRateFacade;
    }

    public DbbusStopFacadeLocal getDbbusStopFacade() {
        return dbbusStopFacade;
    }

    public void setDbbusStopFacade(DbbusStopFacadeLocal dbbusStopFacade) {
        this.dbbusStopFacade = dbbusStopFacade;
    }

    public DbWardFacadeLocal getDbWardFacade() {
        return dbWardFacade;
    }

    public void setDbWardFacade(DbWardFacadeLocal dbWardFacade) {
        this.dbWardFacade = dbWardFacade;
    }

    public DbViewFacadeLocal getDbViewFacade() {
        return dbViewFacade;
    }

    public void setDbViewFacade(DbViewFacadeLocal dbViewFacade) {
        this.dbViewFacade = dbViewFacade;
    }

    public DbUserFacadeLocal getDbUserFacade() {
        return dbUserFacade;
    }

    public void setDbUserFacade(DbUserFacadeLocal dbUserFacade) {
        this.dbUserFacade = dbUserFacade;
    }

    public DbSchoolFacadeLocal getDbSchoolFacade() {
        return dbSchoolFacade;
    }

    public void setDbSchoolFacade(DbSchoolFacadeLocal dbSchoolFacade) {
        this.dbSchoolFacade = dbSchoolFacade;
    }

    public DbRegionFacadeLocal getDbRegionFacade() {
        return dbRegionFacade;
    }

    public void setDbRegionFacade(DbRegionFacadeLocal dbRegionFacade) {
        this.dbRegionFacade = dbRegionFacade;
    }

    public DbMunicipalityFacadeLocal getDbMunicipalityFacade() {
        return dbMunicipalityFacade;
    }

    public void setDbMunicipalityFacade(DbMunicipalityFacadeLocal dbMunicipalityFacade) {
        this.dbMunicipalityFacade = dbMunicipalityFacade;
    }

    public DbLocalityFacadeLocal getDbLocalityFacade() {
        return dbLocalityFacade;
    }

    public void setDbLocalityFacade(DbLocalityFacadeLocal dbLocalityFacade) {
        this.dbLocalityFacade = dbLocalityFacade;
    }

    public DbHospitalFacadeLocal getDbHospitalFacade() {
        return dbHospitalFacade;
    }

    public void setDbHospitalFacade(DbHospitalFacadeLocal dbHospitalFacade) {
        this.dbHospitalFacade = dbHospitalFacade;
    }

    public DbDistrictFacadeLocal getDbDistrictFacade() {
        return dbDistrictFacade;
    }

    public void setDbDistrictFacade(DbDistrictFacadeLocal dbDistrictFacade) {
        this.dbDistrictFacade = dbDistrictFacade;
    }
    
    private List<DbbusStop> listbusStops;
    private List<DbcrimeRate> listcrimeRates;
    private List<DbHospital> listHospitals;
    private List<DbhouseBuying> listhousePrices;
    private List<DbhouseRent> listhouseRents;
    private List<DblandPrice> listlandPrices;
    private List<DbSchool> listSchools;
    private List<DbtrainStation> listtrainStations;
    private String postCodeName;

    public List<DbbusStop> getListbusStops() {
        return listbusStops;
    }

    public void setListbusStops(List<DbbusStop> listbusStops) {
        this.listbusStops = listbusStops;
    }

    public List<DbcrimeRate> getListcrimeRates() {
        return listcrimeRates;
    }

    public void setListcrimeRates(List<DbcrimeRate> listcrimeRates) {
        this.listcrimeRates = listcrimeRates;
    }

    public List<DbHospital> getListHospitals() {
        return listHospitals;
    }

    public void setListHospitals(List<DbHospital> listHospitals) {
        this.listHospitals = listHospitals;
    }

    public List<DbhouseBuying> getListhousePrices() {
        return listhousePrices;
    }

    public void setListhousePrices(List<DbhouseBuying> listhousePrices) {
        this.listhousePrices = listhousePrices;
    }

    public List<DbhouseRent> getListhouseRents() {
        return listhouseRents;
    }

    public void setListhouseRents(List<DbhouseRent> listhouseRents) {
        this.listhouseRents = listhouseRents;
    }

    public List<DblandPrice> getListlandPrices() {
        return listlandPrices;
    }

    public void setListlandPrices(List<DblandPrice> listlandPrices) {
        this.listlandPrices = listlandPrices;
    }

    public List<DbSchool> getListSchools() {
        return listSchools;
    }

    public void setListSchools(List<DbSchool> listSchools) {
        this.listSchools = listSchools;
    }

    public List<DbtrainStation> getListtrainStations() {
        return listtrainStations;
    }

    public void setListtrainStations(List<DbtrainStation> listtrainStations) {
        this.listtrainStations = listtrainStations;
    }

    public String getPostCodeName() {
        return postCodeName;
    }

    public void setPostCodeName(String postCodeName) {
        this.postCodeName = postCodeName;
    }
 
    /**
     * Creates a new instance of Result_MB
     */
    public Result_MB() {
    }
    
    @PostConstruct
    private void init() {
        postCodeSuggested = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("suggestedPostCode");
        int postCodeInt = Integer.parseInt(postCodeSuggested);
        setListbusStops(dbbusStopFacade.findByPostcode(postCodeInt));
        setListcrimeRates(dbcrimeRateFacade.findByPostcode(postCodeInt));
        setListHospitals(dbHospitalFacade.findByPostcode(postCodeInt));
        setListhousePrices(dbhouseBuyingFacade.findByPostcode(postCodeInt));
        setListhouseRents(dbhouseRentFacade.findByPostcode(postCodeInt));
        setListlandPrices(dblandPriceFacade.findByPostcode(postCodeInt));
        setListSchools(dbSchoolFacade.findByPostcode(postCodeInt));
        setListtrainStations(dbtrainStationFacade.findByPostcode(postCodeInt));
    }
    
}

