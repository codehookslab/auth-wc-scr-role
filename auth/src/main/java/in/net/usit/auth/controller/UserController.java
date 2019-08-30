package in.net.usit.auth.controller;

import in.net.usit.auth.repo.UserRepo;
import in.net.usit.auth.to.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping
	public ResponseEntity<Object> getUsers() {
		return ResponseEntity.ok(userRepo.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		userRepo.save(user);
		return ResponseEntity.ok(userRepo.findAll());
	}

}
