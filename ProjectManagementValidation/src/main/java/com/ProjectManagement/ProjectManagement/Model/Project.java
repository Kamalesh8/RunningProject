package com.ProjectManagement.ProjectManagement.Model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;

public class Project {
	
	@Range(min=100,max=10000,message="Project ID must be between 100 & 10000")
	@NotNull(message = "Project ID is mandatory")
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int projectId;
	
	@Size(min=5,message = "Project Name must be more than 5 characters")
	String projectName;
	
	//@NotEmpty(message="StartDate is Mandatory")
	LocalDateTime startDate;
	
	//@NotEmpty(message="EndDate is Mandatory")
	LocalDateTime endDate;	
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime ldt) {
		this.startDate = ldt;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime localDateTime) {
		this.endDate = localDateTime;
	}
	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}	
	
}
