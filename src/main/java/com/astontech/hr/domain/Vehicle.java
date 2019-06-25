package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleId")
    private Integer id;

    @Version
    private Integer version;

    private String color;
    private String licensePlate;
    private String vIN;
    private String year;


    @ManyToOne
    private VehicleModel vehicleModel;

    public Vehicle() {}

    public Vehicle(String year, String licensePlate, String vIN, String color) {this.setColor(color);
    this.setLicensePlate(licensePlate); this.setvIN(vIN); this.setYear(year);}



//region GETTERS/SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getvIN() {
        return vIN;
    }

    public void setvIN(String vIN) {
        this.vIN = vIN;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }


    //endregion
}
