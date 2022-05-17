package com.project.leavemanagementsystem.model;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "leave")
@DynamicInsert
public class LeaveModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Integer leaveID;
	
	
	@Column(name = "user_id", nullable = false)
	private int userId;
	
	@Column(name = "user_name", nullable = false)
	private String userName;

	@Column(name = "from_date", nullable = false)
	private String fromDate;

	@Column(name = "to_date", nullable = false)
	private String toDate;

	@Column(name = "type_of_leave", nullable = false)
	private String typeOfLeave;

	@Column(name = "reason_of_leave", nullable = false)
	private String reasonOfLeave;
	
	@JsonProperty(defaultValue = "Pending")
	@Column(name = "status_of_leave")
	//@Column(name = "status_of_leave", columnDefinition = "varchar(50) default 'Pending'")
	//@ColumnDefault(value = "'Pending'")
	private String statusOfLeave;

	public Integer getLeaveID() {
		return leaveID;
	}

	public void setLeaveID(Integer leaveID) {
		this.leaveID = leaveID;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getTypeOfLeave() {
		return typeOfLeave;
	}

	public void setTypeOfLeave(String typeOfLeave) {
		this.typeOfLeave = typeOfLeave;
	}

	public String getReasonOfLeave() {
		return reasonOfLeave;
	}

	public void setReasonOfLeave(String reasonOfLeave) {
		this.reasonOfLeave = reasonOfLeave;
	}
	
	public String getStatusOfLeave() {
		return statusOfLeave;
	}

	public void setStatusOfLeave(String statusOfLeave) {
		this.statusOfLeave = statusOfLeave;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	String message;
	String code;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
}
