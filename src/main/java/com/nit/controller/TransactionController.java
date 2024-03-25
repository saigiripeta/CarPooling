package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.Entity.Transactions;
import com.nit.service.Transations;

@RestController
public class TransactionController {
	@Autowired
	private Transations service;

	@PostMapping("/sendTransData")
	public Transactions save(@RequestBody Transactions ts) {
		System.out.println(ts);
		service.saveToDb(ts);
		return ts;
	}

	@GetMapping("/GettransDetails")
	public List<Transactions> get() {

		return service.get();
	}

	@DeleteMapping("/Deletetrans/{name}")
	public Boolean delete(@PathVariable Integer id) {
		/*
		 * try { service.delete(id); } catch (Exception e) { return true; } return
		 * false;
		 */
		return (service.delete(id)) ? true : false;

	}
}
