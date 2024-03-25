package com.nit.Repository;

import java.util.List;

import com.nit.Entity.Transactions;

public interface Transactionrepo {
	public  List<Transactions> get();
	public  void save(Transactions ts);
	public void delete(int id);
}
