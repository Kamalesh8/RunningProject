package com.ProjectManagement.ProjectManagement.Model;

import java.util.List;
import java.util.ArrayList;

public class Projects {

	private List<Project> projectsList;

		
	public List<Project> getProjectsList() {
		if(projectsList == null) {
			projectsList = new ArrayList();
		}
		return projectsList;
	}

	public void setProjectsList(List<Project> projectsList) {
		this.projectsList = projectsList;
	}
	
}
