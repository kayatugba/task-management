package com.tugbakaya.taskmanagementrepositories.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tugbakaya.taskmanagemententities.entity.TaskEntity;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Integer> {

	List<TaskEntity> findByTaskNameIgnoreCaseContaining(String name);
}
