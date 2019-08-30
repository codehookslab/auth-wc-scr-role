package in.net.usit.auth.repo;

import in.net.usit.auth.to.Screen;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScreenRepo extends JpaRepository<Screen, Long> {
	
	List<Screen> findAllScreensByModule(Screen moduleId);
	
	@Query("SELECT s from Screen s where s.module = :screen")
	List<Screen> loadAllScreensByParentModule(@Param("screen") Screen screen);
	
	List<Screen> findAllByIsRootModule(boolean flag);
	
	List<Screen> findAllByRouterPathNotNull();
	
	List<Screen> findAllByIsModule(Boolean flag);
}
