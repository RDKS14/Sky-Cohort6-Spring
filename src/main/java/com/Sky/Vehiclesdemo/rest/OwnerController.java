package com.Sky.Vehiclesdemo.rest;

import com.Sky.Vehiclesdemo.domain.Owner;
import com.Sky.Vehiclesdemo.services.OwnerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    private OwnerService service;

    public OwnerController(OwnerService service){
        this.service = service;
    }

    @PostMapping("/create")
    public Owner createOwner(@RequestBody Owner o) {
        return this.service.createOwner(o);
    }

    @GetMapping("/get")
    public List<Owner>getOwners() {
        return this.service.getOwners();
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeOwner(@PathVariable int id) {
        String result = this.service.removeOwner(id);
        if ("NOT FOUND".equalsIgnoreCase(result)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return ResponseEntity.ok(result);

    }

}
