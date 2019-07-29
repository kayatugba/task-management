package com.tugbakaya.taskmanagementservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tugbakaya.taskmanagemententities.entity.TaskEntity;
import com.tugbakaya.taskmanagementrepositories.repository.TaskRepositoryCustom;

@Service("taskServiceCriteria")
//@Qualifier("taskServiceCriteria")
public class TaskServiceCriteriaImpl implements TaskService {

	@Autowired
	TaskRepositoryCustom taskRepositoryCustom;

	@Override
	public Iterable<TaskEntity> findAllTasks() {

		return taskRepositoryCustom.findAllTasks();
	}

	@Override
	public TaskEntity saveTask(TaskEntity task) {
	return taskRepositoryCustom.saveTask(task);
	}

	@Override
	public List<TaskEntity> findByTaskNameIgnoreCaseContaining(String name) {
		return taskRepositoryCustom.findByTaskNameIgnoreCaseContaining(name);
	}

	@Override
	public TaskEntity getTaskById(Integer id) {
		return taskRepositoryCustom.getTaskById(id);
	}

	@Override
	public void endTask(Integer id) {
		taskRepositoryCustom.endTask(id);

	}

}
