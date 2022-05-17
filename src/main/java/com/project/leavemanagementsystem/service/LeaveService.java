package com.project.leavemanagementsystem.service;

import org.springframework.http.ResponseEntity;

import com.project.leavemanagementsystem.model.LeaveModel;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

public interface LeaveService {

	public ResponseEntity<LeaveModel> newLeave(LeaveModel RequestBody, HttpServletRequest request);

    public ResponseEntity<List<LeaveModel>> getAllLeavesResponse(int userId);
    
    public ResponseEntity<LeaveModel> deleteLeavesResponse(Integer leaveID);
    
    public ResponseEntity<LeaveModel> UpdateLeave(Integer leaveID, LeaveModel update);
    
    public ResponseEntity<LeaveModel> approveLeave(Integer leaveID, LeaveModel update);
}
