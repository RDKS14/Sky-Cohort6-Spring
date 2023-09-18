package com.Sky.Vehiclesdemo.rest;

import com.Sky.Vehiclesdemo.domain.Vehicle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class VehicleController {

private List<Vehicle> vehicles = new ArrayList<>();

    @GetMapping("/hello")
    public String test() {
        return "Hello, World";
    }


    // 'maps' the method to a POST request at /crate
    @PostMapping("/create")
    // The Person will be passed in via the request body
    public Vehicle createVehicle(@RequestBody Vehicle a) {
        vehicles.add(a);
        return this.vehicles.get(this.vehicles.size() - 1); // return the last element in the list
    }

    @GetMapping("/get/{id}")
    public Vehicle getVehicle(@PathVariable int id ) {
        System.out.println("ID: " + id);
        return this.vehicles.get(id);
    }

    @GetMapping("/getAll")
    public List<Vehicle> getVehicle() {
        return vehicles;
    }

    @PatchMapping("/update")
    public Vehicle updateVehicle(
            @RequestParam(name = "id", required = false)  Integer id,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "brand", required = false) String brand,
            @RequestParam(name = "wheels", required = false) Integer wheels,
            @RequestParam(name = "doors", required = false) Integer doors
    ) {
        System.out.println("ID: " + id);
        System.out.println("NAME: " + name);
        System.out.println("AGE: " + age);
        System.out.println("BRAND: " + brand);
        System.out.println("WHEELS: " + wheels);
        System.out.println("DOORS: " + doors);

        Vehicle vToUpdate = getVehicle(id);
        if (name != null) vToUpdate.setName(name);
        if (age != null) vToUpdate.setAge(age);
        if (brand != null) vToUpdate.setBrand(brand);
        if (wheels != null) vToUpdate.setWheels(wheels);
        if (doors != null) vToUpdate.setDoors(doors);

        return vToUpdate;
    }


    @DeleteMapping("/remove/{id}")
    public String removeVehicle(@PathVariable int id) {
        if(this.vehicles.remove(id) != null)
        return "Vehicle Removed";
        else return "Please try Again";
    }
}
