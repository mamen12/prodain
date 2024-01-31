package com.test.prodain.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.prodain.beans.BaseResponse;
import com.test.prodain.beans.RefrenceDataEntity;
import com.test.prodain.beans.UserRequest;
import com.test.prodain.beans.UserResponse;
import com.test.prodain.entity.DetailUserInfo;
import com.test.prodain.entity.UserInfo;
import com.test.prodain.service.JwtService;
import com.test.prodain.service.UserDetailService;
import com.test.prodain.service.UserService;


@RestController
@RequestMapping("/api") 
public class UserController {
	
    @Autowired
    private UserService service; 
  
    @Autowired
    private JwtService jwtService; 
    
    @Autowired
    private UserDetailService detailService;
  
    @Autowired
    private AuthenticationManager authenticationManager; 
  
    private static final String entityName = "User";
    
    private static final String create= "create";
    private static final String update= "update";
    
    String pattern = "yyyy-MM-dd HH:mm:ss";
    
    @GetMapping("/welcome") 
    public String welcome() { 
        return "Welcome this endpoint is not secure"; 
    } 
  
    @PostMapping("/users") 
    public UserResponse addNewUser(@RequestBody UserRequest userRequest) { 
    	UserResponse rs = new UserResponse();
    	String id = UUID.randomUUID().toString();
    	
    	UserInfo user = new UserInfo();
    	user.setEmail(userRequest.getEmail());
    	user.setPassword(userRequest.getPassword());
    	user.setName(userRequest.getUsername());
    	user.setId(id);
    	user.setCreatedby(id);
    	
    	DetailUserInfo detail = new DetailUserInfo();
    	detail.setFirstName(userRequest.getFirstName());
    	detail.setLastName(userRequest.getLastName());
    	detail.setId(id);
    	
    	String userSaved = service.addUser(user);
    	
    	if (userSaved.equals("User Added Successfully")) {
    		detailService.addUserDetail(detail);
    		rs.setMessage(userSaved);
        	rs.setStatus(true);
        	setReferenceData(id, rs, create);
		}else {
			rs.setMessage(userSaved);
			rs.setStatus(false);
		}
    	return rs;
    } 
  
    
    private void setReferenceData(String id, UserResponse rs, String method) {
    	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		RefrenceDataEntity ref = new RefrenceDataEntity();
		ref.setEntityName(entityName);
		ref.setPk(id);
		
		if (method.equals(create)) {
			ref.setCreatedAt(sdf.format(new Date()));
			ref.setCreatedby(id);
		}else if(method.equals(update)) {
			ref.setUpdatedBy(sdf.format(new Date()));
			ref.setCreatedby(id);
		}else {
			ref.setDeletedAt(sdf.format(new Date()));
			ref.setCreatedby(id);
		}
		rs.setRefrenceDataEntity(ref);
		
	}

	@PostMapping("/login")
    public BaseResponse<String> loginUser(@RequestBody UserRequest userRequest){
    	BaseResponse<String> rs = new BaseResponse<>();
    	rs.setStatus(false);
    	try {
    		Authentication authentication = authenticationManager.authenticate(
        			new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));
    		if (authentication.isAuthenticated()) {
    			rs.setStatus(true);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	
    	if (rs.getStatus()) { 
    		rs.setAccessToken(jwtService.generateToken(userRequest.getUsername()));
    		rs.setRefreshToken(jwtService.generateToken(userRequest.getUsername()));
    		rs.setMessage("Succesfully Login");
    	} else { 
    		rs.setMessage("Unauthorized");
    	} 
    	return rs;
    }
    
//    @PutMapping("/users")

  

  
} 
