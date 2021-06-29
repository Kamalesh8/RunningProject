package com.ProjectManagement.ProjectManagement.Model;

import java.time.LocalDateTime;
import java.util.Date;

public class Project {
	
	String projectName;
	LocalDateTime startDate;
	LocalDateTime endDate;
	
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
		return "Project [projectName=" + projectName + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}	
	
}
