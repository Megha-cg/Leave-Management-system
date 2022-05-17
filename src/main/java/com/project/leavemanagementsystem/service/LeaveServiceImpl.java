package com.project.leavemanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import com.project.leavemanagementsystem.model.LeaveModel;
import com.project.leavemanagementsystem.repository.LeaveRepository;
import com.project.leavemanagementsystemLmsException.LeaveNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
	private LeaveRepository leaveRepository;
     
	public ResponseEntity<LeaveModel> newLeave(LeaveModel RequestBody, HttpServletRequest request) {

		LeaveModel newLeave = leaveRepository.saveAndFlush(RequestBody);
		newLeave.setCode("SUCCESS");
		newLeave.setMessage("Leave Added");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Location", contactUrlHelper(newLeave, request));

		return new ResponseEntity<LeaveModel>(newLeave, responseHeaders, HttpStatus.CREATED);

	}

	/*@Override
	public ResponseEntity<List<LeaveModel>> getAllLeavesResponse(String userName) {

		List<LeaveModel> allLeaves = leaveRepository.findByuserName(userName);

		return new ResponseEntity<List<LeaveModel>>(allLeaves, HttpStatus.OK);

	}*/
	
	public ResponseEntity<List<LeaveModel>> getAllLeavesResponse(int userId) {

		List<LeaveModel> allLeaves = leaveRepository.findByUserId(userId);

		return new ResponseEntity<List<LeaveModel>>(allLeaves, HttpStatus.OK);

	}
	
    public ResponseEntity<LeaveModel> deleteLeavesResponse(Integer leaveID) {
    	LeaveModel existing = findIfExists(leaveID);
    	leaveRepository.deleteById(leaveID);
        return new ResponseEntity<LeaveModel>(HttpStatus.OK);
    }

    public ResponseEntity<LeaveModel> UpdateLeave(Integer leaveID, LeaveModel update) {
    	LeaveModel existing;
		
		    existing = findIfExists(leaveID);
			existing.setFromDate(update.getFromDate());
	    	existing.setReasonOfLeave(update.getReasonOfLeave());
	    	existing.setToDate(update.getToDate());
	    	existing.setTypeOfLeave(update.getTypeOfLeave());
	    	//existing.setCode("SUCCESS");
	    	//existing.setMessage("Leave Updated");
	    	leaveRepository.save(existing);
	        return new ResponseEntity<LeaveModel>(existing,HttpStatus.OK);
    }
    
    public ResponseEntity<LeaveModel> approveLeave(Integer leaveID, LeaveModel update) {
    	LeaveModel existing;
		
		    existing = findIfExists(leaveID);
			//existing.setFromDate(update.getFromDate());
	    	//existing.setReasonOfLeave(update.getReasonOfLeave());
	    	//existing.setToDate(update.getToDate());
	    	//existing.setTypeOfLeave(update.getTypeOfLeave());
		    existing.setStatusOfLeave(update.getStatusOfLeave());
	    	//existing.setCode("SUCCESS");
	    	//existing.setMessage("Leave Status has changed");
	    	leaveRepository.save(existing);
	        return new ResponseEntity<LeaveModel>(existing,HttpStatus.OK);
    	    }
	/*
	 * Private Methods
	 */

	
    private LeaveModel findIfExists(Integer id) {
    	LeaveModel existing =  leaveRepository.findByLeaveID(id);

        if(null != existing) {
            return existing;
        } else {
            throw new LeaveNotFoundException();
        }
    }
    
    
    
    private String contactUrlHelper(LeaveModel leave, HttpServletRequest request) {
		StringBuilder resourcePath = new StringBuilder();

		resourcePath.append(request.getRequestURL());
		resourcePath.append("/");
		resourcePath.append(leave.getLeaveID());

		return resourcePath.toString();
	}

}