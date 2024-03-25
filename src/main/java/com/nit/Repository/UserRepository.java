package com.nit.Repository;

import com.nit.Entity.User;

import java.util.List;

public interface UserRepository {

	public List<User> get();

	public User login(User user);

	public boolean signUp(User user);

	public User update(User user);

	public void delete(long id);

	public User loginValidation(User user);

}
