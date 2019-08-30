package in.net.usit.auth.repo;

import in.net.usit.auth.to.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findByUsernameAndPassword(String username, String password);
}
