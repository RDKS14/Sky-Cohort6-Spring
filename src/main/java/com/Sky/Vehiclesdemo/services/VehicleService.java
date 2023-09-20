package com.Sky.Vehiclesdemo.services;

import java.util.List;
import com.Sky.Vehiclesdemo.domain.Vehicle;

public interface VehicleService {

    Vehicle createVehicle(Vehicle a);

    Vehicle getVehicle( int id );

    List<Vehicle> getAll();

    Vehicle updateVehicle(
            Integer id,
            String name,
            Integer age,
            String brand,
            Integer wheels,
            Integer doors);

    String removeVehicle(int id);

    Vehicle findVehicleByName(String name);
}
