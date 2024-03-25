package com.nit.Repository;

import java.util.List;

import com.nit.Entity.ShareVehicle;

public interface ShareRepo {
	public List<ShareVehicle> get();

	public ShareVehicle get(String Name);

	public void save(ShareVehicle sv);

	public void delete(int id);

	public List<ShareVehicle> getUsingDestination(String Destination);

}
