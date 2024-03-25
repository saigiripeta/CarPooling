package com.nit.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.Entity.User;


public interface UserJPARepository extends JpaRepository<User, Serializable> {

	User  findByEmailAddressAndPassword(String emailAddress, String password);
}
