package com.nit.service;

import java.util.List;

import com.nit.Entity.Transactions;

public interface Transations {

	public  List<Transactions> get();
	public void save(Transactions ts);
    public Boolean delete(int id);
	public Boolean saveToDb(Transactions ts) ;
// public void delete(String name);
}
