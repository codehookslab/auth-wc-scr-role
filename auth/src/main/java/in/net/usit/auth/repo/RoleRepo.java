package in.net.usit.auth.repo;

import in.net.usit.auth.to.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

}
