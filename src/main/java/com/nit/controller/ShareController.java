package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nit.Entity.ShareVehicle;
import com.nit.service.Share;

@RestController
public class ShareController {

	@Autowired
	private Share service;

	@PostMapping("/user")
	public ShareVehicle save(@RequestBody ShareVehicle Obj) {
		System.out.println(Obj);
		service.save(Obj);
		return Obj;
	}

	@GetMapping("/userdetails")
	public List<ShareVehicle> get() {
		return service.get();
	}

//    @GetMapping("/destination/{Destination}")
//    public List<ShareVehicle> get(@PathVariable String Destination) {
//        List<ShareVehicle> shareVehicleList = service.getUsingDestination(Destination);
//        return shareVehicleList;
//    }

	@PutMapping("/user")
	public String update(@RequestBody ShareVehicle Obj) {
		Boolean status = service.save(Obj);
		return status ? "Vehicle details saved" : "Failed to save";
	}

	@DeleteMapping("/vehicleDelete/{id}")
	public boolean delete(@PathVariable int id) {
		try {
			service.delete(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
