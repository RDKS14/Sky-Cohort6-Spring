package com.Sky.Vehiclesdemo.services;

import org.springframework.stereotype.Service;
import com.Sky.Vehiclesdemo.repo.OwnerRepo;
import com.Sky.Vehiclesdemo.domain.Owner;

import java.util.List;

@Service
public class OwnerService {


    private OwnerRepo repo;

    public OwnerService(OwnerRepo repo){
        this.repo = repo;
    }

    public Owner createOwner(Owner o) {
        return this.repo.save(o);
    }

    public List<Owner> getOwners() {
        return this.repo.findAll();
    }

    public String removeOwner(int id) {
        if (this.repo.existsById(id)) {
            this.repo.deleteById(id);
            return "Owner Removed";
        } else {
            return "Not Found";
        }

    }
}
