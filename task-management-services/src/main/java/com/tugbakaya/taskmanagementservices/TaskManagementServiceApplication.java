package com.tugbakaya.taskmanagementservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"com.tugbakaya.userrepository.entity","com.tugbakaya.userrepository.repository"})
@ComponentScan({"com.tugbakaya.*"})
@EntityScan("com.tugbakaya.taskmanagemententities.entity")
@EnableJpaRepositories("com.tugbakaya.taskmanagementrepositories.repository")
public class TaskManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementServiceApplication.class, args);
	}

}
