package com.Sky.Vehiclesdemo.services;

import java.util.List;
import com.Sky.Vehiclesdemo.domain.Vehicle;

public interface VehicleService {

    Vehicle createVehicle(Vehicle a);

    Vehicle getVehicle( int id );

    List<Vehicle> getAll();

    Vehicle updateVehicle(
            String name,
            Integer age,
            String brand,
            Integer wheels,
            Integer doors,
            Integer id);

    String removeVehicle(int id);

    Vehicle findVehicleByName(String name);
}
