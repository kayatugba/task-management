package com.tugbakaya.taskmanagementrepositories.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tugbakaya.taskmanagemententities.entity.TaskEntity;
import com.tugbakaya.taskmanagemententities.entity.UserEntity;

@Repository
public interface UserRepositoryCustom {

	Iterable<UserEntity> findAllUsers();

	UserEntity saveUser(UserEntity userEntity);

	void assignTask(Integer userId, Integer taskId);

	List<TaskEntity> listUserTasks(Integer userId);

}
