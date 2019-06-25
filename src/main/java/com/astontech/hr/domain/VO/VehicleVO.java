package com.astontech.hr.domain.VO;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;

public class VehicleVO {

    private String newVehicleColor;
    private String newVehicleLicensePlate;
    private String newVehicleVin;
    private String newVehicleYear;
    private String[] newVehicleArray;

    private VehicleModel newVehicleModel;
    private VehicleMake newVehicleMake;


    public VehicleVO(){}

    public String getNewVehicleColor() {
        return newVehicleColor;
    }

    public void setNewVehicleColor(String newVehicleColor) {
        this.newVehicleColor = newVehicleColor;
    }

    public String getNewVehicleLicensePlate() {
        return newVehicleLicensePlate;
    }

    public void setNewVehicleLicensePlate(String newVehicleLicensePlate) {
        this.newVehicleLicensePlate = newVehicleLicensePlate;
    }

    public String getNewVehicleVin() {
        return newVehicleVin;
    }

    public void setNewVehicleVin(String newVehicleVin) {
        this.newVehicleVin = newVehicleVin;
    }

    public String getNewVehicleYear() {
        return newVehicleYear;
    }

    public void setNewVehicleYear(String newVehicleYear) {
        this.newVehicleYear = newVehicleYear;
    }

    public VehicleModel getNewVehicleModel() {
        return newVehicleModel;
    }

    public void setNewVehicleModel(VehicleModel newVehicleModel) {
        this.newVehicleModel = newVehicleModel;
    }

    public VehicleMake getNewVehicleMake() {
        return newVehicleMake;
    }

    public void setNewVehicleMake(VehicleMake newVehicleMake) {
        this.newVehicleMake = newVehicleMake;
    }

    public String[] getNewVehicleArray() {
        return newVehicleArray;
    }

    public void setNewVehicleArray(String[] newVehicleArray) {
        this.newVehicleArray = newVehicleArray;
    }

    //region CUSTOM METHODS

    //endregion
}
