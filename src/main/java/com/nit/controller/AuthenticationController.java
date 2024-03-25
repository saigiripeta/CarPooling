package com.nit.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nit.Entity.User;
import com.nit.Repository.UserRepository;
import com.nit.config.ResourceNotFoundException;

@RestController
public class AuthenticationController {

	@Autowired
	private UserRepository ur;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) throws ResourceNotFoundException {
		System.out.println(user);
		User userObj = ur.loginValidation(user);
		if (userObj != null)
			return new ResponseEntity<>("login Successful", HttpStatus.OK);
		else
			return new ResponseEntity<>("Authentcation Failed", HttpStatus.NOT_FOUND);

	}

	@GetMapping("/users")
	public List<User> get() {
		return ur.get();
	}

	@PostMapping("/signup")
	public ResponseEntity<HashMap<String, String>> signUp(@RequestBody User user) {
		System.out.println(user);
		HashMap<String, String> response = new HashMap<>();
		if (ur.signUp(user)) {
			response.put("status", "Signup successful, you can login into your account now");
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} else {
			response.put("status", "Could not register");
			return new ResponseEntity<>(response, HttpStatus.FOUND);
		}
	}

	/*
	 * @PutMapping("/update") public ResponseEntity<User> update(@RequestBody User
	 * user) { System.out.println("To update in DB:\n" + user); User response =
	 * ur.update(user); return ResponseEntity.ok().body(response); }
	 */
	/*
	 * @PutMapping("/users/{id}") public ResponseEntity<User>
	 * updateUser(@PathVariable long id, @RequestBody User user) { user.setId(id);
	 * // Set the ID from the path variable to ensure the correct user is updated
	 * UserRepository userRepository = null; User updatedUser =
	 * userRepository.update(user); if (updatedUser != null) { return
	 * ResponseEntity.ok(updatedUser); } else { return
	 * ResponseEntity.notFound().build(); } }
	 */

	@DeleteMapping("/users/{id}")
	public boolean delete(@PathVariable long id) {
		try {
			ur.delete(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
