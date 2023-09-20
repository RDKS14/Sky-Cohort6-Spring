package com.Sky.Vehiclesdemo.services;

import com.Sky.Vehiclesdemo.domain.Vehicle;
import com.Sky.Vehiclesdemo.repo.VehicleRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class VehicleServiceDB implements VehicleService {

    private VehicleRepo repo;

    public VehicleServiceDB(VehicleRepo repo){
        this.repo = repo;
    }


    @Override
    public Vehicle createVehicle(Vehicle a) {
        return this.repo.save(a);
    }

    @Override
    public Vehicle getVehicle(int id) {
        Optional<Vehicle> found = this.repo.findById(id);

        return found.get();
    }
    @Override
    public Vehicle findVehicleByName(String name) {
        return this.repo.findByNameIgnoreCase(name);
    }
    @Override
    public List<Vehicle> getAll() {
        return this.repo.findAll();
    }

    @Override
    public Vehicle updateVehicle(Integer id, String name, Integer age, String brand, Integer wheels, Integer doors) {
        Vehicle vToUpdate = getVehicle(id);
        if (name != null) vToUpdate.setName(name);
        if (age != null) vToUpdate.setAge(age);
        if (brand != null) vToUpdate.setBrand(brand);
        if (wheels != null) vToUpdate.setWheels(wheels);
        if (doors != null) vToUpdate.setDoors(doors);
        return this.repo.save(vToUpdate);

    }

    @Override
    public String removeVehicle(int id) {
        if (this.repo.existsById(id)) {
            this.repo.deleteById(id);
            return "Vehicle Removed";
        }else {
            return "Not Found";
        }
    }
}