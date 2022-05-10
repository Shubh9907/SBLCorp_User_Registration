package com.sbl.user_registration.service;

import java.util.List;

import com.sbl.user_registration.dto.UserDto;
import com.sbl.user_registration.models.User;

public interface IUserService {
	
	String registerUser(UserDto userDto);
	
	List<User> getAllUsers();
	
	String deleteByEmailId(String email);
	
	User getByUserName(String userName);

}
