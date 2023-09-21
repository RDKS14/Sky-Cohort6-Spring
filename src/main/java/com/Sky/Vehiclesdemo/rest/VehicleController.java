package com.Sky.Vehiclesdemo.rest;

import com.Sky.Vehiclesdemo.domain.Vehicle;
import com.Sky.Vehiclesdemo.services.VehicleService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
@RestController
public class VehicleController {


    private VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }
    @GetMapping("/get/name/{name}")
    public Vehicle getByName(@PathVariable String name) {
        return this.service.findVehicleByName(name);
    }
    @GetMapping("/hello")
    public String test() {
        return "Hello, World";
    }



    // 'maps' the method to a POST request at /crate
    @PostMapping("/create")
    // The Person will be passed in via the request body
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle a) {
        return new ResponseEntity<>(this.service.createVehicle(a), HttpStatus.CREATED);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable int id) {
        System.out.println("ID: " + id);

        Vehicle found = this.service.getVehicle(id);

        if (found == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(found);
    }

    @GetMapping("/getAll")
    public List<Vehicle> getVehicle() {
        return this.service.getAll();
    }

    @PatchMapping("/update")
    public ResponseEntity<Vehicle> updateVehicle(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "brand", required = false) String brand,
            @RequestParam(name = "wheels", required = false) Integer wheels,
            @RequestParam(name = "doors", required = false) Integer doors,
            @RequestParam(name = "id", required = false) Integer id
    ) {
        System.out.println("NAME: " + name);
        System.out.println("AGE: " + age);
        System.out.println("BRAND: " + brand);
        System.out.println("WHEELS: " + wheels);
        System.out.println("DOORS: " + doors);
        System.out.println("ID: " + id);

        Vehicle updated = this.service.updateVehicle(name, age, brand, wheels, doors, id);
        if (updated == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeVehicle(@PathVariable int id) {
        String result = this.service.removeVehicle(id);
        if ("NOT FOUND".equalsIgnoreCase(result)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return ResponseEntity.ok(result);
    }
}
