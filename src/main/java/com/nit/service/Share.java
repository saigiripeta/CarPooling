package com.nit.service;

import java.util.List;

import com.nit.Entity.ShareVehicle;

public interface Share {
	public  List<ShareVehicle> get();

	public ShareVehicle get(String Name);

	public Boolean save(ShareVehicle sv);

	public void delete(int id);

}
