package com.Sky.Vehiclesdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Sky.Vehiclesdemo.domain.Owner;

@Repository
public interface OwnerRepo extends JpaRepository <Owner, Integer> {


}
