package com.project.leavemanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.leavemanagementsystem.model.LoginResponse;
import com.project.leavemanagementsystem.model.User;
import com.project.leavemanagementsystem.repository.LoginRepo;

@Service
public class LoginService {
	@Autowired
	LoginRepo loginrepo;
	
	public ResponseEntity<Object> userLogin(User userData){
		Logger log = LoggerFactory.getLogger(LoginService.class);
		//log.info("Login Begins" + userData.getUserName());
		try {
			User user = loginrepo.findByUserName(userData.getUserName());
			if(user!=null && user.getPassword().equals(userData.getPassword())) {
				log.info("Login Successful");
				return LoginResponse.generateResponse("Successfully login", HttpStatus.OK);
			}
			log.info("Login failed" + " username: " + user.getUserName());
			return LoginResponse.generateResponse("Login failed. Please check your credentials", HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			return LoginResponse.generateResponse("Login failed. Please check your credentials", HttpStatus.BAD_REQUEST);
		}
	}
	
	/*public User getUserData(Integer id)
	{
		return loginrepo.findById(id).get();
	}*/
	
	public User getUserData(String userName)
	{
		return loginrepo.findByUserName(userName);
	}

}
