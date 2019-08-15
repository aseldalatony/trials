package trials.java.spring.boot.UserRegisterationSystem.dto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserDTO, Long> {
	UserDTO findByName(String name);
}
