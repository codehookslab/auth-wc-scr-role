package in.net.usit.auth.repo;

import in.net.usit.auth.to.WorkCenterRole;
import in.net.usit.auth.to.WorkCenterRoleCompositeKey;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WcRoleRepo extends JpaRepository<WorkCenterRole, WorkCenterRoleCompositeKey> {
	
}
