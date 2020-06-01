package com.example.authorizationserver.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.authorizationserver.Model.User;
import com.example.authorizationserver.Repository.UserDetailRepository;

public class UserDetailServiceImpl implements UserDetailsService {
	
	
	@Autowired
	UserDetailRepository userDetailRepository;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		Optional<User> optionalUser = userDetailRepository.findByUsername(name);
		
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username or password wrong"));
		
		return userDetail;
	}

}
