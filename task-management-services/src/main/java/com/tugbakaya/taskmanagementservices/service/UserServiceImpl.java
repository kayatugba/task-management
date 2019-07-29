package com.tugbakaya.taskmanagementservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugbakaya.taskmanagemententities.entity.TaskEntity;
import com.tugbakaya.taskmanagemententities.entity.UserEntity;
import com.tugbakaya.taskmanagemententities.enumeration.TaskState;
import com.tugbakaya.taskmanagementrepositories.repository.TaskRepository;
import com.tugbakaya.taskmanagementrepositories.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TaskRepository taskRepository;

	@Override
	public Iterable<UserEntity> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity saveUser(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}

	@Override
	public void assignTask(Integer userId, Integer taskId) {
		UserEntity userEntity = userRepository.findById(userId).get();
		TaskEntity taskEntity = taskRepository.findById(taskId).get();
		userEntity.getTasks().add(taskEntity);
		userRepository.save(userEntity);
		taskEntity.setTaskState(TaskState.PROCESS);
		taskRepository.save(taskEntity);

	}

	@Override
	public List<TaskEntity> listUserTasks(Integer userId) {
		return userRepository.findById(userId).get().getTasks();
	}
	
	

}
