package com.tugbakaya.taskmanagementrepositories.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tugbakaya.taskmanagemententities.entity.TaskEntity;

@Repository
public interface TaskRepositoryCustom {

	Iterable<TaskEntity> findAllTasks();

	TaskEntity saveTask(TaskEntity task);

	List<TaskEntity> findByTaskNameIgnoreCaseContaining(String name);

	TaskEntity getTaskById(Integer id);

	void endTask(Integer id);

}
