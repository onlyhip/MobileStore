package fa.training.restful.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.restful.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	/**
	* Sign in
	* @param username
	* @param password
	* @return User
	*/
	public User findByUsernameAndPassword(String username, String password);
}
