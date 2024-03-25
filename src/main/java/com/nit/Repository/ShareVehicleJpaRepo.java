package com.nit.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.Entity.ShareVehicle;

public interface ShareVehicleJpaRepo extends JpaRepository<ShareVehicle, Serializable> {

}
