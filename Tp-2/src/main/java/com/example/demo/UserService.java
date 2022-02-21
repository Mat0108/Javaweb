package com.example.demo;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service("userDetailsService")
public class UserService implements UserDetailsService {
	private UserRepository userRepository;
 	@Autowired
 	public UserService(UserRepository userRepository) {
 		this.userRepository = userRepository;
 	}
 	
 	@Override
 	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 	 Objects.requireNonNull(username);
 	 User user = userRepository.findUserWithName(username); 
 	 // orElseThrow(() -> new UsernameNotFoundException("User not found"));
 	 if (user == null) {
 		return null; 
 	 }
 	 else {
 	 	 return user;
 	 }
 	 	
 	 }
	
}


