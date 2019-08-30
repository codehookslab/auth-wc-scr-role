package in.net.usit.auth.controller;

import in.net.usit.auth.repo.ScreenRepo;
import in.net.usit.auth.repo.UserRepo;
import in.net.usit.auth.to.Screen;
import in.net.usit.auth.to.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/login")
public class LoginController {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ScreenRepo screenRepo;

	@PostMapping(path = "")
	public ResponseEntity<Object> handleLogin(@RequestBody User user) {

		Optional<User> optionalUser = userRepo.findByUsernameAndPassword(
				user.getUsername(), user.getPassword());

		if (optionalUser.isPresent()) {

			Set<Screen> rootModules = new HashSet<>();
			Set<String> screenNamesSet = new HashSet<>();

			User loggedInUser = optionalUser.get();

			loggedInUser.getWcRolesMap().forEach( wcRole -> {
				wcRole.getScreens().forEach(screen -> {
					screenNamesSet.add(screen.getScreenId().getName());
					rootModules.add(getRootModule(screen.getScreenId(), screenNamesSet));
				});
			});
			
//			loggedInUser.getRole().getScreens().forEach(screen -> {
//				screenNamesSet.add(screen.getName());
//				rootModules.add(getRootModule(screen, screenNamesSet));
//			});

			rootModules.forEach(module -> module.setScreens(getScreens(module,
					screenNamesSet)));

			loggedInUser.setScreenOrModules(rootModules);
			
			return ResponseEntity.ok(loggedInUser);

		}
		return ResponseEntity.badRequest().body(
				"User not found with given crendentials.");
	}

	Screen getRootModule(Screen module, Set<String> screenNamesSet) {
		screenNamesSet.add(module.getName());
		return module.getIsRootModule() ? module : getRootModule(
				module.getModule(), screenNamesSet);
	}

	List<Screen> getScreens(Screen module, Set<String> screenNamesSet) {
		if (module.getRouterPath() == null) {
			List<Screen> screens = screenRepo.loadAllScreensByParentModule(module);

			List<Screen> finalScreens = new ArrayList<>(screens.stream()
					.filter(e -> screenNamesSet.contains(e.getName()))
					.collect(Collectors.toList()));

			finalScreens.forEach(screen -> screen.setScreens(getScreens(screen, screenNamesSet)));
			return finalScreens;
		}
		return Collections.emptyList();
	}

}
