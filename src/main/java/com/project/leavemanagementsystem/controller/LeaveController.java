package com.project.leavemanagementsystem.controller;

import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.project.leavemanagementsystem.model.LeaveModel;
import com.project.leavemanagementsystem.service.LeaveServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/lms")
public class LeaveController {

	@Autowired
	private LeaveServiceImpl LeaveService;

	// Create New Leave
	@PostMapping(value = "createLeave")
	public ResponseEntity<LeaveModel> newLeave(@RequestBody LeaveModel requestBody, HttpServletRequest req) {
		return LeaveService.newLeave(requestBody, req);
	}

	// List All Leaves
	@GetMapping(value = "showLeave/{userId}")
	public ResponseEntity<List<LeaveModel>> getAllLeaves(@PathVariable int userId) throws Throwable {
		return LeaveService.getAllLeavesResponse(userId);
	}

	// Delete Leave
	@DeleteMapping(value = "removeLeave/{leaveID}")
	public ResponseEntity<LeaveModel> deleteLeave(@PathVariable Integer leaveID) {
		System.out.println("API CALLED");
		System.out.println(leaveID);
		return LeaveService.deleteLeavesResponse(leaveID);
	}

	@PutMapping("/updateLeave/{leaveID}")
	public ResponseEntity<LeaveModel> UpdateLeave(@PathVariable(value = "leaveID") Integer leaveID, @Validated @RequestBody LeaveModel update)
	{
		return LeaveService.UpdateLeave(leaveID, update);
	}
	
	@PutMapping("/leaveStatusChange/{leaveID}")
	public ResponseEntity<LeaveModel> approveLeave(@PathVariable(value = "leaveID") Integer leaveID, @Validated @RequestBody LeaveModel update)
	{
		return LeaveService.approveLeave(leaveID, update);
	}
}
