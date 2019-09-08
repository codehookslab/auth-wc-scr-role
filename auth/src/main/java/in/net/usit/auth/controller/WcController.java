package in.net.usit.auth.controller;

import java.util.List;

import in.net.usit.auth.repo.WcRepo;
import in.net.usit.auth.repo.WcRoleRepo;
import in.net.usit.auth.repo.WorkCenterRoleScreenRepo;
import in.net.usit.auth.to.WorkCenterRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/wc")
public class WcController {
	
	@Autowired
	private WcRepo wcRepo;
	
	@Autowired
	private WcRoleRepo wcRoleRepo;
	@Autowired
	private WorkCenterRoleScreenRepo wcRoleScreenRepo;
	
	@GetMapping(path = "")
	public ResponseEntity<?> loadWcs() {
		return ResponseEntity.ok(wcRepo.findAll());
	}
	
	@GetMapping(path = "/wc-role-screens")
	public ResponseEntity<?> loadWcRoleScreens() {
		List<WorkCenterRole> wcRoles = wcRoleRepo.findAll();
//		wcRoles.forEach(wcr -> {
//			wcr.setScreens(wcRoleScreenRepo.findByIdWcRoleId(wcr));
//		});
		return ResponseEntity.ok(wcRoles);
	}
	
	@PostMapping(path = "/wc-role-screens")
	public ResponseEntity<?> saveWcRoleScreens(@RequestBody List<WorkCenterRole> maps) {
		wcRoleRepo.saveAll(maps);
		return ResponseEntity.ok(wcRoleRepo.findAll());
	}

}
