package com.project.leavemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.leavemanagementsystem.model.LeaveModel;

public interface LeaveRepository extends JpaRepository<LeaveModel, Integer> {

	LeaveModel findByLeaveID(Integer leaveID);
	
	List<LeaveModel> findByuserName(String userName);
	List<LeaveModel> findByUserId(int userId);
}
