package com.test.prodain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.prodain.entity.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, String>{
	Optional<UserInfo> findByName(String username);
	
	@Query("SELECT COUNT(u) FROM UserInfo u WHERE u.email=?1")
	public Integer countEmailUser(String email);
}
