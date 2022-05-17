package com.project.leavemanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.leavemanagementsystem.model.User;


@Repository
public interface LoginRepo extends JpaRepository<User, String> {
	User findByUserName(String userName);
}