package com.test.prodain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.prodain.entity.DetailUserInfo;
import com.test.prodain.repository.UserDetailRepository;

@Service
public class UserDetailService {

	@Autowired
	private UserDetailRepository userDetailRepo;
	
	
	public String addUserDetail(DetailUserInfo detail) {
		userDetailRepo.save(detail);
        return "User Detail Added"; 
	}
}
