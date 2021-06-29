package com.ProjectManagement.ProjectManagement.DAO;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ProjectManagement.ProjectManagement.Model.Project;
import com.ProjectManagement.ProjectManagement.Model.Projects;

@Repository
public class ProjectsDAO {
	
	static Projects plist = new Projects();
	static {
		LocalDateTime ldt = LocalDateTime.now();
		Project p1 = new Project();
		p1.setProjectName("HSBC");
		p1.setStartDate(ldt);		
		p1.setEndDate(ldt.plusDays(300));
		
		Project p2 = new Project();
		p2.setProjectName("Shell Corporation");
		p2.setStartDate(ldt);		
		p2.setEndDate(ldt.plusDays(300));
		
		plist.getProjectsList().add(p1);
		plist.getProjectsList().add(p2);
		
		System.err.println("Project List Initialized...");
	}
	
	public Projects getAllProjects() {
		return plist;
	}
	
	public void addProject(Project p) {
		plist.getProjectsList().add(p);
	}
	
	public void deleteProject(String projectname) {
		List<Project> l = plist.getProjectsList();
		for(Project p : l) {
			if(p.getProjectName().equalsIgnoreCase(projectname)) {
				l.remove(p);
			}
			System.out.println("Project Stopped...");
		}
	}
	
	
	
	
}
