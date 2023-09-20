package com.Sky.Vehiclesdemo.services;

import com.Sky.Vehiclesdemo.domain.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.ArrayList;


@Service
public class VehicleServiceList  implements VehicleService {

    private List<Vehicle> vehicles = new ArrayList<>();


    @Override
    public Vehicle createVehicle(Vehicle a) {
        vehicles.add(a);
        Vehicle created = this.vehicles.get(this.vehicles.size() - 1);
        return created;
    }

    public Vehicle getVehicle(int id) {
        if (id < this.vehicles.size())
            return this.vehicles.get(id);
        else
            return null;
    }

    @Override
    public List<Vehicle> getAll() {
        return this.vehicles;
    }

    @Override
    public Vehicle updateVehicle(
            Integer id,
            String name,
            Integer age,
            String brand,
            Integer wheels,
            Integer doors) {
        Vehicle vToUpdate = getVehicle(id);
        if (name != null) vToUpdate.setName(name);
        if (age != null) vToUpdate.setAge(age);
        if (brand != null) vToUpdate.setBrand(brand);
        if (wheels != null) vToUpdate.setWheels(wheels);
        if (doors != null) vToUpdate.setDoors(doors);
        return vToUpdate;
    }
    public String removeVehicle( int id) {
        if(this.vehicles.remove(id) != null)
            return "Vehicle Removed";
        else return "Please try Again";
    }

    @Override
    public Vehicle findVehicleByName(String name){
        return null;
    }
}


