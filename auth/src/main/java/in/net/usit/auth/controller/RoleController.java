package in.net.usit.auth.controller;

import in.net.usit.auth.repo.RoleRepo;
import in.net.usit.auth.to.Role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {
	
	@Autowired
	private RoleRepo roleRepo;
	
	@GetMapping
	public ResponseEntity<Object> getRoles() {
		return ResponseEntity.ok(roleRepo.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Object> saveRoles(@RequestBody List<Role> roles) {
		roleRepo.saveAll(roles);
		return ResponseEntity.ok(roleRepo.findAll());
	}

}
