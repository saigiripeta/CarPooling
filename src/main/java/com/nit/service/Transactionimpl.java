package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nit.Entity.Transactions;
import com.nit.Repository.TransactionJpaRepo;
import com.nit.Repository.Transactionrepo;

@Service
public class Transactionimpl implements Transations {
	@Autowired
	private Transactionrepo tr;
	@Autowired
	private TransactionJpaRepo repo;

	@Override
	public Boolean saveToDb(Transactions ts) {
	return  repo.save(ts).getPhoneNumber()!=null;
	}

	@Transactional
	@Override
	public List<Transactions> get() {
		return tr.get();
	}

	@Transactional
	@Override
	public void save(Transactions ts) {
		tr.save(ts);
	}

	@Override
	public Boolean delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
