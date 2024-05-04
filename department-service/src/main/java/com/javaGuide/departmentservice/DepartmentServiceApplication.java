package com.javaGuide.departmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class DepartmentServiceApplication {

	/* to make run  department service instance with differnt port run the below cmd
	 make the department-service as jar
	  java -jar -Dserver.port=8181 target/department-service-0.0.1-SNAPSHOT.jar

	 */
	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
