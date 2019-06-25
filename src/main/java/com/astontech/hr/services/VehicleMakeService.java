package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleMake;

public interface VehicleMakeService {
    Iterable<VehicleMake> listAllVehicleMake();

    VehicleMake getVehicleMakeById(Integer id);

     VehicleMake saveVehicleMake(VehicleMake vehicleMake);

    Iterable<VehicleMake> saveVehicleMakeList(Iterable<VehicleMake> vehicleMakes);

    void deleteVehicleMake(Integer id);

    VehicleMake getVehicleMakeByName(String vehicleMakeName);

}
