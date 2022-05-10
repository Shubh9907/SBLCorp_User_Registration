package com.sbl.user_registration.service;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbl.user_registration.dto.UserDto;
import com.sbl.user_registration.models.User;
import com.sbl.user_registration.repository.UserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String registerUser(UserDto userDto) {
		User registeredUser = userRepository.findByUserName(userDto.getUserName());
		if (registeredUser != null) {
			return "This UserName is already in use";
		}else {
			User user = modelMapper.map(userDto, User.class);
			userRepository.save(user);
			return "User registered successfully";
		}
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList = userRepository.findAll();
		return userList;
	}

	@Override
	public String deleteByEmailId(String email) {
		User registeredUser = userRepository.findByEmailId(email);
		if (registeredUser != null ) {
			userRepository.delete(registeredUser);
			return "User deleted successfully";
		}
		return "Email Id not found";
	}

	@Override
	public User getByUserName(String userName) {
		User registeredUser = userRepository.findByUserName(userName);
		if (registeredUser != null ) {
			return registeredUser;
		}
		return null;
	}

}
