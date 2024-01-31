package com.test.prodain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.prodain.entity.UserInfo;
import com.test.prodain.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
    private UserRepository repository; 
  
    @Autowired
    private PasswordEncoder encoder; 
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userDetail = repository.findByName(username); 
		  
        // Converting userDetail to UserDetails 
        return userDetail.map(UserInfoDetails::new) 
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
	}
	
	public String addUser(UserInfo userInfo) { 
		if (repository.countEmailUser(userInfo.getEmail()) > 0) {
			return "Email Already Exists";
		}else {
			userInfo.setPassword(encoder.encode(userInfo.getPassword())); 
	        repository.save(userInfo); 
	        return "User Added Successfully"; 
		}
    } 
	
}
