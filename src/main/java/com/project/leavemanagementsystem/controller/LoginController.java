package com.project.leavemanagementsystem.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.leavemanagementsystem.model.User;
import com.project.leavemanagementsystem.repository.LoginRepo;
import com.project.leavemanagementsystem.service.LoginService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/lms")
public class LoginController {
	
	@Autowired
	LoginService loginservice;
	
	@Autowired 
	LoginRepo loginrepo;
	
	@PostMapping("/login") 
	 public ResponseEntity<Object> userLogin(@RequestBody User userData){
		Logger log = LoggerFactory.getLogger(LoginService.class);
		log.info(userData.getUserName() + " is logging in...");
		return loginservice.userLogin(userData);
		
	 }
	
	/*@GetMapping("userInfo/{id}")
	public User userData(@PathVariable Integer id) {
		return loginservice.getUserData(id);
	}*/
	
	@GetMapping("userInfo/{userName}")
	public User userData(@PathVariable String userName) {
		return loginservice.getUserData(userName);
	}

}
