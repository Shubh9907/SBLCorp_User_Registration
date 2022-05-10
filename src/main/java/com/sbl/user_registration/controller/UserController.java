package com.sbl.user_registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sbl.user_registration.dto.UserDto;
import com.sbl.user_registration.models.User;
import com.sbl.user_registration.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/")
	public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
		String response = userService.registerUser(userDto);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> response = userService.getAllUsers();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/")
	public ResponseEntity<String> deleteUser(@RequestParam String email) {
		String response = userService.deleteByEmailId(email);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/{userName}")
	public ResponseEntity<User> searchUserByUserName(@PathVariable String userName) {
		User response = userService.getByUserName(userName);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
