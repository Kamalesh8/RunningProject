package com.ProjectManagement.ProjectManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.logging.Logger;
@SpringBootApplication
public class ProjectManagementApplication {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger("MainLogger");
		SpringApplication.run(ProjectManagementApplication.class, args);
		logger.info("Started Application");
	}

}
