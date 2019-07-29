package com.tugbakaya.taskmanagementservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tugbakaya.taskmanagemententities.entity.TaskEntity;
import com.tugbakaya.taskmanagemententities.enumeration.TaskState;
import com.tugbakaya.taskmanagementrepositories.repository.TaskRepository;
import com.tugbakaya.taskmanagementrepositories.repository.TaskRepositoryCustom;

@Service("taskService")
//@Qualifier("taskService")
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;


	@Override
	public Iterable<TaskEntity> findAllTasks() {
		return taskRepository.findAll();
	}

	@Override
	public TaskEntity saveTask(TaskEntity task) {
		return taskRepository.save(task);
	}

	@Override
	public List<TaskEntity> findByTaskNameIgnoreCaseContaining(String name) {
		
		return taskRepository.findByTaskNameIgnoreCaseContaining(name);
	}


	@Override
	public TaskEntity getTaskById(Integer id) {
		return taskRepository.findById(id).get();
	}

	@Override
	public void endTask(Integer id) {
		TaskEntity taskEntity = taskRepository.findById(id).get();
		taskEntity.setTaskState(TaskState.DONE);
		taskRepository.save(taskEntity);
		
	}
	
	
	
	
	
	

}
