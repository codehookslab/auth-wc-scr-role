package in.net.usit.auth.repo;

import in.net.usit.auth.to.WorkCenterRoleScreens;
import in.net.usit.auth.to.WorkCenterRoleScreensCompositeKey;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkCenterRoleScreenRepo extends JpaRepository<WorkCenterRoleScreens, WorkCenterRoleScreensCompositeKey> {
	
}
