package com.tugbakaya.taskmanagementservices.service;

import java.util.List;

import com.tugbakaya.taskmanagemententities.entity.TaskEntity;
import com.tugbakaya.taskmanagemententities.entity.UserEntity;


public interface UserService {
	
	Iterable<UserEntity> findAllUsers();
	
	UserEntity saveUser(UserEntity userEntity);
	
	void assignTask(Integer userId, Integer taskId);
	
	List<TaskEntity> listUserTasks(Integer userId);

}
