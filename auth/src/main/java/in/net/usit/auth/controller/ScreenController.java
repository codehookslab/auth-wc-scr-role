package in.net.usit.auth.controller;

import in.net.usit.auth.repo.ScreenRepo;
import in.net.usit.auth.to.Screen;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/screens")
public class ScreenController {
	
	@Autowired
	private ScreenRepo screenRepo;
	
	@GetMapping(path = "")
	public ResponseEntity<Object> loadModulesWithScreen() {
		List<Screen> rootModules = screenRepo.findAllByIsRootModule(true);
		rootModules.forEach( module -> module.setScreens(getScreens(module)));
		return ResponseEntity.ok(rootModules);
	}
	
	List<Screen> getScreens (Screen module) {
		if(module.getRouterPath() == null) {
			List<Screen> screens = screenRepo.loadAllScreensByParentModule(module);
			screens.forEach( screen -> screen.setScreens(getScreens(screen)));
			return screens;
		}
		return Collections.emptyList();
	}
	
	@GetMapping(path = "/screen-only")
	public ResponseEntity<Object> loadScreensOnly() {
		List<Screen> screens = screenRepo.findAllByRouterPathNotNull();
		for(Screen mod: screens) {
			if(!mod.getIsRootModule()) {
				mod.setParentModuleId(mod.getModule().getUid());
				mod.setParentModuleName(mod.getModule().getName());
			}
		}
		return ResponseEntity.ok(screens);
	}
	
	@GetMapping(path = "/modules-only")
	public ResponseEntity<Object> loadModulesOnly() {
		List<Screen> modules = screenRepo.findAllByIsModule(Boolean.TRUE);
		for(Screen mod: modules) {
			if(!mod.getIsRootModule()) {
				mod.setParentModuleId(mod.getModule().getUid());
				mod.setParentModuleName(mod.getModule().getName());
			}
		}
		return ResponseEntity.ok(modules);
	}
	
	@PostMapping(path="/save-modules")
	public ResponseEntity<Object> saveModules(@RequestBody List<Screen> modulesToSave) {
		
		for(Screen mod: modulesToSave) {
			if( !mod.getIsRootModule()) {
				Screen parentModule = modulesToSave
						.stream()
						.filter( m -> !mod.getIsRootModule() && isFilterCondition(mod, m))
						.findAny()
						.orElse(null);
				if(parentModule != null) {
					parentModule = screenRepo.save(parentModule);
					mod.setModule(parentModule);
				}
			}
			screenRepo.save(mod);
		}
		return loadModulesOnly();
	}
	
	@PostMapping(path = "/save-screens")
	public ResponseEntity<Object> saveScreens(@RequestBody List<Screen> screensToSave) {
		screensToSave.forEach( screen -> {
			Screen s = screenRepo.findById(screen.getParentModuleId()).orElse(null);
			if(s != null) {
				screen.setModule(s);
			}
			screenRepo.save(screen);
		});
		
		return ResponseEntity.ok(screenRepo.findAllByRouterPathNotNull());
	}

	private boolean isFilterCondition(Screen currentModule,Screen traversingModule) {
		if(currentModule.getParentModuleId() != null) {
			return !currentModule.getIsRootModule() && currentModule.getParentModuleId().equals(traversingModule.getUid());
		}
		
		if(currentModule.getParentModuleName() != null) {
			return !currentModule.getIsRootModule() && currentModule.getParentModuleName().equals(traversingModule.getName());
		}
		
		return false;
	}
	

}
