package com.Sky.Vehiclesdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Sky.Vehiclesdemo.domain.Vehicle;
@Repository
public interface VehicleRepo extends JpaRepository <Vehicle, Integer> {

    Vehicle findByNameIgnoreCase(String name);

}
