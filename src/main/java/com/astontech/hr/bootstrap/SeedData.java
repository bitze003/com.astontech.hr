package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.*;
import com.astontech.hr.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private ElementService elementService;

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private AddressService addressService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){

        generatedElement();
//        generateElementAndElementTypes();
        generatedMake();
        generatedContact();

    }

    private void generatedContact(){
        Address address1 = new Address();

        address1.setStreet("Target St.");
        address1.setAddressNumber("123");
        addressService.saveAddress(address1);

        Contact contact1 = new Contact();

        contact1.setCompanyName("Target");
        contact1.setAddress(address1);


        contactService.saveContact(contact1);

        Address address2 = new Address();

        address2.setStreet("Best Buy St.");
        address2.setAddressNumber("666 6969");
        addressService.saveAddress(address2);

        Contact contact2 = new Contact();

        contact2.setCompanyName("BestBuy");
        contact2.setAddress(address2);

        contactService.saveContact(contact2);

    }

    private void generatedElement(){

        Employee employee = new Employee();
        employee.setFirstName("Bipin");
        employee.setLastName("Butala");
        employee.setBackground("Java Developer");

        employeeService.saveEmployee(employee);

        Employee employee1 = new Employee();
        employee1.setFirstName("Kenny");
        employee1.setLastName("Bitzer");
        employee1.setBackground("Java kid");

        employeeService.saveEmployee(employee1);

        Employee employee2 = new Employee();
        employee2.setFirstName("Steve");
        employee2.setLastName("Wood");
        employee2.setBackground("Java Boy");

        employeeService.saveEmployee(employee2);

        Employee employee3 = new Employee();
        employee3.setFirstName("Alex");
        employee3.setLastName("Crystler");
        employee3.setBackground("Java Guy");

        employeeService.saveEmployee(employee3);

    }

    private void generateElementAndElementTypes(){

        ElementType phoneType = new ElementType("Phone");

        ElementType laptopType = new ElementType("Laptop");

        List<Element> phoneList = new ArrayList<>();

        phoneList.add(new Element("Samsung"));
        phoneList.add(new Element("Google Pixel"));
        phoneList.add(new Element("Iphone"));

        phoneType.setElementList(phoneList);
        elementTypeService.saveElementType(phoneType);

        List<Element> elementList = new ArrayList<>();

        elementList.add(new Element("Acer"));
        elementList.add(new Element("Dell"));
        elementList.add(new Element("Samsung"));
        elementList.add(new Element("Apple"));
        elementList.add(new Element("Asus"));

        laptopType.setElementList(elementList);

        elementTypeService.saveElementType(laptopType);
    }

    private void generatedMake(){

        VehicleMake vehicleMakeHonda = new VehicleMake();

        vehicleMakeHonda.setVehicleMakeName("Honda");
        vehicleMakeService.saveVehicleMake(vehicleMakeHonda);

        VehicleMake vehicleMakeToyota = new VehicleMake();

        vehicleMakeToyota.setVehicleMakeName("Toyota");
        vehicleMakeService.saveVehicleMake(vehicleMakeToyota);

        VehicleMake vehicleMakeTesla = new VehicleMake();

        vehicleMakeTesla.setVehicleMakeName("Tesla");
        vehicleMakeService.saveVehicleMake(vehicleMakeTesla);


        VehicleModel vehicleModelCivic = new VehicleModel();

        vehicleModelCivic.setVehicleModelName("Civic");
        vehicleModelCivic.setVehicleMake(vehicleMakeHonda);
        vehicleModelService.saveVehicleModel(vehicleModelCivic);

        VehicleModel vehicleModelAccord = new VehicleModel();

        vehicleModelAccord.setVehicleModelName("Accord");
        vehicleModelAccord.setVehicleMake(vehicleMakeHonda);
        vehicleModelService.saveVehicleModel(vehicleModelAccord);

        VehicleModel vehicleModelCorolla = new VehicleModel();

        vehicleModelCorolla.setVehicleModelName("Corolla");
        vehicleModelCorolla.setVehicleMake(vehicleMakeToyota);
        vehicleModelService.saveVehicleModel(vehicleModelCorolla);

        VehicleModel vehicleModelPrius = new VehicleModel();

        vehicleModelPrius.setVehicleModelName("Prius");
        vehicleModelPrius.setVehicleMake(vehicleMakeToyota);
        vehicleModelService.saveVehicleModel(vehicleModelPrius);

        VehicleModel vehicleModelX = new VehicleModel();

        vehicleModelX.setVehicleModelName("Model X");
        vehicleModelX.setVehicleMake(vehicleMakeTesla);
        vehicleModelService.saveVehicleModel(vehicleModelX);

        VehicleModel vehicleModelS = new VehicleModel();

        vehicleModelS.setVehicleModelName("Model S");
        vehicleModelS.setVehicleMake(vehicleMakeTesla);
        vehicleModelService.saveVehicleModel(vehicleModelS);


        Vehicle vehicleOneHonda = new Vehicle() ;

        vehicleOneHonda.setColor("Yellow");
        vehicleOneHonda.setvIN("5N1AR2MM1EC711775");
        vehicleOneHonda.setLicensePlate("ABC-123");
        vehicleOneHonda.setYear("2019");
        vehicleOneHonda.setVehicleModel(vehicleModelCivic);

        vehicleService.saveVehicle(vehicleOneHonda);

        Vehicle vehicleTwoToyota = new Vehicle() ;

        vehicleTwoToyota.setColor("Black");
        vehicleTwoToyota.setvIN("KM8SC83D01U108752");
        vehicleTwoToyota.setLicensePlate("ZXY-987");
        vehicleTwoToyota.setYear("2011");
        vehicleTwoToyota.setVehicleModel(vehicleModelCorolla);

        vehicleService.saveVehicle(vehicleTwoToyota);

        Vehicle vehicleThreeTesla = new Vehicle() ;

        vehicleThreeTesla.setColor("Red");
        vehicleThreeTesla.setvIN("JHMED6304JS831210");
        vehicleThreeTesla.setLicensePlate("XXX-666");
        vehicleThreeTesla.setYear("2018");
        vehicleThreeTesla.setVehicleModel(vehicleModelX);

        vehicleService.saveVehicle(vehicleThreeTesla);

    }


}
