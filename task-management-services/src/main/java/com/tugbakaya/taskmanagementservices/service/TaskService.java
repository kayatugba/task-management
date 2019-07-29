package com.tugbakaya.taskmanagementservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tugbakaya.taskmanagemententities.entity.TaskEntity;
import com.tugbakaya.taskmanagementrepositories.repository.TaskRepository;


public interface TaskService {

	
	
	Iterable<TaskEntity> findAllTasks();
	
	TaskEntity saveTask(TaskEntity task);
	
	List<TaskEntity> findByTaskNameIgnoreCaseContaining(String name);
	
	TaskEntity getTaskById(Integer id);
	
	void endTask(Integer id);
	
	
	

}
