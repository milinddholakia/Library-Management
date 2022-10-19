package com.greatlearning.LibraryManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.LibraryManagement.entity.User;
import com.greatlearning.LibraryManagement.repository.UserRepository;
import com.greatlearning.LibraryManagement.security.MyUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository ;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =  userRepository.getUserByUsername(username) ;
		if(user == null) 
			throw new UsernameNotFoundException("Could not find user with given name");
		return new MyUserDetails(user);
	}

}
