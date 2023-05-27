package AnywrTest.controller;

import AnywrTest.configurations.MainConfig;
import AnywrTest.repositories.IUserRepository;
import AnywrTest.security.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import AnywrTest.security.services.JwtUtil;
import AnywrTest.security.services.MyUserDetails;
import AnywrTest.security.services.UserDetailsServicesImpl;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private UserDetailsServicesImpl userDetailService;
	@Autowired
	private IUserRepository userRepo;




	@GetMapping("")
	public ResponseEntity<?> generateToken(){
		Map<String, Object> response = new HashMap<>();

		User user = userRepo.findByUsername(MainConfig.ADMIN_USERNAME).get(0);
		authManager.authenticate(new UsernamePasswordAuthenticationToken(MainConfig.ADMIN_USERNAME,MainConfig.ADMIN_PASSWORD));
		MyUserDetails mud = (MyUserDetails) userDetailService.loadUserByUsername(MainConfig.ADMIN_USERNAME);

		response.put("role",user.getRole());
		response.put("token", jwtUtil.generateToken(mud));

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}



}
