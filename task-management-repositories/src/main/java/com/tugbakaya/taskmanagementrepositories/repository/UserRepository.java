package com.tugbakaya.taskmanagementrepositories.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tugbakaya.taskmanagemententities.entity.UserEntity;


@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>{

	
}
