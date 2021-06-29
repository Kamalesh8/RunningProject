package com.ProjectManagement.ProjectManagement.Controllers;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ProjectManagement.ProjectManagement.DAO.ProjectsDAO;
import com.ProjectManagement.ProjectManagement.Model.Project;
import com.ProjectManagement.ProjectManagement.Model.Projects;

@RestController
@RequestMapping("/Project")// defines a context...project is a container
public class ProjectController {
	
	@Autowired
	private ProjectsDAO projectsdao; // good practise to make autowiring private
	
	Logger logger = Logger.getLogger("customLogger");
	
	@GetMapping(value = "/listProjects",produces="application/json")
	// All end points implementations should be non private
	// ANd none of them return type should be void
	public Projects getProjects(HttpServletRequest request) { 	//HttpServletRequest is automaticaaly passed
		String clientAddress = request.getRemoteAddr();
		Locale clientLocation = request.getLocale();
		System.err.println("Client Country:"+clientLocation.getCountry());
		System.err.println("Client IPAddress:"+clientAddress);
		System.err.println("Client Language:"+clientLocation.getLanguage());
		System.err.println("Client ServerName:"+request.getServerName()+" Server Port:"+request.getServerPort());
		String clienttool = request.getHeader("user-agent");
		System.err.println("Client Tool : "+clienttool);
		String from = request.getHeader("from");
		System.err.println("Username :"+from);
		/*
		 * ...write the code for blocking the code or for forwarding the client 
		 * Ip filtering or ip forwarding
		 * Fool Proof Security - to fool the hacker and send to another false website
		 */
		logger.info("Returned list of projects");
		return projectsdao.getAllProjects();
	}
	
	@GetMapping(value="/addProject")
	public ModelAndView addProject() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addProject");
		return mv;		
	}
	
	@PostMapping(value = "/addProject",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE},produces = "application/json")
	public ResponseEntity<Object> addProject(@RequestBody Project p){
		// Data we are getting it from requestbody sent by the browser
		projectsdao.addProject(p);
		logger.info("Added Project");
		// keep track of request-response pair
		// Those request sending data are chained to the response
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{ProjectName}")
				.buildAndExpand(p.getProjectName()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/deleteProject")
	public ResponseEntity<Object> deleteProject(@RequestBody String projectname){
		projectsdao.deleteProject(projectname);
		logger.info("project deleted....");
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{ProjectName}")
				.buildAndExpand(projectname).toUri();
		return ResponseEntity.created(location).build();		
	}	
}
