package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nit.Entity.ShareVehicle;
import com.nit.Repository.ShareRepo;
import com.nit.Repository.ShareVehicleJpaRepo;

@Service
public class ShareService implements Share {

	@Autowired
	private ShareRepo sr;
	@Autowired
	private ShareVehicleJpaRepo repo;

	@Transactional
	@Override
	public List<ShareVehicle> get() {
		return sr.get();
	}

	@Transactional
	@Override
	public ShareVehicle get(String Name) {
		return sr.get(Name);
	}


	@Override
	public Boolean save(ShareVehicle sv) {
		return repo.save(sv).getId() != null;
	}

	@Transactional
	public void delete(int id) {
		sr.delete(id);
	}


}
