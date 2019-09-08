package in.net.usit.auth.controller;

import in.net.usit.auth.repo.WorkCenterRoleScreenRepo;
import in.net.usit.auth.to.WorkCenterRoleScreens;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "wc-role-screens")
public class WorkCenterRoleScreensController {
	
	@Autowired
	public WorkCenterRoleScreenRepo repo;
	
	@GetMapping
	public ResponseEntity<Object> loadAll() {
		List<WorkCenterRoleScreens> screens = repo.findAll();
		screens.forEach( s -> {
			s.getId().getWcRoleId().setScreens(null);
			s.setTransId(s.getId());
		});
		return ResponseEntity.ok(repo.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Object> saveAll(@RequestBody List<WorkCenterRoleScreens> screens) {
//		System.out.println("---------------------------------------");
//		screens.forEach( s -> {
//			System.out.println(s.toString());
//		});
		repo.saveAll(screens);
		System.out.println("Saving SuccessFull");
		return ResponseEntity.ok(repo.findAll());
	}

}
