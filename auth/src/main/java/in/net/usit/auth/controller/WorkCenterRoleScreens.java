package in.net.usit.auth.controller;

import in.net.usit.auth.repo.WorkCenterRoleScreenRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "wc-role-screens")
public class WorkCenterRoleScreens {
	
	@Autowired
	public WorkCenterRoleScreenRepo repo;
	
	
	
	@GetMapping
	public ResponseEntity<Object> loadAll() {
		return ResponseEntity.ok(repo.findAll());
	}

}
