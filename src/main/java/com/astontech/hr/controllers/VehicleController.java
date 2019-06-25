package com.astontech.hr.controllers;
import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    private Logger log = Logger.getLogger(VehicleController.class);

    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.GET)
    public String vehicleGet(Model model) {
        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("vehicleModelList", vehicleModelService.listAllVehicleModels());
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMake());
        model.addAttribute("WarningAlert", "visable");

        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.POST)
    public String vehiclePost(VehicleVO vehicleVO, Model model) {

        VehicleMake newVehicleMake = vehicleVO.getNewVehicleMake();
        VehicleModel newVehicleModel = vehicleVO.getNewVehicleModel();

        newVehicleModel.setVehicleMake(newVehicleMake);

        Vehicle newVehicle = new Vehicle(vehicleVO.getNewVehicleYear(), vehicleVO.getNewVehicleLicensePlate(), vehicleVO.getNewVehicleVin(), vehicleVO.getNewVehicleColor());

        newVehicle.setVehicleModel(newVehicleModel);

        vehicleService.saveVehicle(newVehicle);

        model.addAttribute("vehicleVO", new VehicleVO());

        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle/list", method = RequestMethod.GET)
    public String vehicleList(Model model) {

        model.addAttribute("vehicleList", vehicleService.listAllVehicles());
        return "admin/vehicle/vehicle_list";
    }

    @RequestMapping(value = "/admin/vehicle/edit/{id}", method = RequestMethod.GET)
    public String vehicleEdit(@PathVariable int id, Model model) {
        Vehicle vehicle = vehicleService.getVehicleById(id);

        model.addAttribute("vehicle", vehicle);
        return "admin/vehicle/vehicle_edit";
    }

    @RequestMapping(value = "/admin/vehicle/update", method = RequestMethod.POST)
    public String vehicleUpdate(Vehicle vehicle, Model model){
        vehicleMakeService.saveVehicleMake(vehicle.getVehicleModel().getVehicleMake());
        vehicleModelService.saveVehicleModel(vehicle.getVehicleModel());
        vehicleService.saveVehicle(vehicle);

        return  "redirect:/admin/vehicle/edit/" + vehicle.getId();
    }

        @RequestMapping(value = "/admin/vehicle/delete/{id}", method = RequestMethod.GET)
        public String vehicleDelete ( @PathVariable int id){
            vehicleService.deleteVehicle(id);
            return "redirect:/admin/vehicle/list";
        }

    }

