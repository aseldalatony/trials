package trials.java.spring.boot.UserRegisterationSystem;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import trials.java.spring.boot.UserRegisterationSystem.dto.UserDTO;
import trials.java.spring.boot.UserRegisterationSystem.dto.UserJpaRepository;

@RestController
@RequestMapping("/api/users")
public class UserRegistrationRestController {
	public static final Logger logger = LoggerFactory.getLogger(UserRegistrationRestController.class);

	private UserJpaRepository userJpaRepository;

	@Autowired
	public void setUserJpaRepository(UserJpaRepository userJpaRepository) {
		this.userJpaRepository = userJpaRepository;
	}

	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> listAllUsers() {
		List<UserDTO> users = userJpaRepository.findAll();
		return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> createUser(@RequestBody final UserDTO user) {
		userJpaRepository.save(user);
		return new ResponseEntity<UserDTO>(user, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") final Long id) {
		userJpaRepository.deleteById(id);
		return new ResponseEntity<UserDTO>(HttpStatus.NO_CONTENT);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> updateUser(@PathVariable("id") final Long id, @RequestBody UserDTO user) {

		// fetch user based on id and set it to currentUser object of type UserDTO
		UserDTO currentUser = userJpaRepository.findById(id).get();

		// update currentUser object data with user object data
		currentUser.setName(user.getName());
		currentUser.setAddress(user.getAddress());
		currentUser.setEmail(user.getEmail());

		// save currentUser obejct
		userJpaRepository.saveAndFlush(currentUser);

		// return ResponseEntity object
		return new ResponseEntity<UserDTO>(currentUser, HttpStatus.OK);
	}
}