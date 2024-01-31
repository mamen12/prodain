package com.test.prodain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.prodain.entity.DetailUserInfo;

@Repository
public interface UserDetailRepository extends JpaRepository<DetailUserInfo, String>{

	
	
}
