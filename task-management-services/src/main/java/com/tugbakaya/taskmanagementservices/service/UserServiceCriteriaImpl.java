package com.tugbakaya.taskmanagementservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugbakaya.taskmanagemententities.entity.TaskEntity;
import com.tugbakaya.taskmanagemententities.entity.UserEntity;
import com.tugbakaya.taskmanagementrepositories.repository.TaskRepositoryCustom;
import com.tugbakaya.taskmanagementrepositories.repository.UserRepositoryCustom;

@Service("userServiceCriteria")
public class UserServiceCriteriaImpl implements UserService {

	@Autowired
	UserRepositoryCustom userRepositoryCustom;

	@Override
	public Iterable<UserEntity> findAllUsers() {
		return userRepositoryCustom.findAllUsers();
	}

	@Override
	public UserEntity saveUser(UserEntity userEntity) {
		return userRepositoryCustom.saveUser(userEntity);
	}

	@Override
	public void assignTask(Integer userId, Integer taskId) {
		userRepositoryCustom.assignTask(userId, taskId);

	}

	@Override
	public List<TaskEntity> listUserTasks(Integer userId) {
		return userRepositoryCustom.listUserTasks(userId);
	}

}
