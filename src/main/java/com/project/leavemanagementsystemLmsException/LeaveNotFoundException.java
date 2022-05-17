package com.project.leavemanagementsystemLmsException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "username not found")
public class LeaveNotFoundException extends RuntimeException {
}

