package com.greatlearning.stumanagement.StudentManagement1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.stumanagement.StudentManagement1.entity.User;
import com.greatlearning.stumanagement.StudentManagement1.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("Username" + username + "not found");
		else {
			MyUserDetails myUserDetails = new MyUserDetails(user);
			return myUserDetails;
		}
	}
}
