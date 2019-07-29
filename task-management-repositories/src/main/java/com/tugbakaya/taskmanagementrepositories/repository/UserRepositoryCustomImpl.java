package com.tugbakaya.taskmanagementrepositories.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.tugbakaya.taskmanagemententities.entity.TaskEntity;
import com.tugbakaya.taskmanagemententities.entity.UserEntity;


@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

	@PersistenceContext
	EntityManager em;

	@Override
	public Iterable<UserEntity> findAllUsers() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<UserEntity> cq = builder.createQuery(UserEntity.class);
		Root<UserEntity> userEntity = cq.from(UserEntity.class);

		TypedQuery<UserEntity> query = em.createQuery(cq);
		return query.getResultList();

	}

	@Override
	public UserEntity saveUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignTask(Integer userId, Integer taskId) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaUpdate<UserEntity> cq = builder.createCriteriaUpdate(UserEntity.class);
		Root<UserEntity> userEntity = cq.from(UserEntity.class);
		// cq.set

	}

	@Override
	public List<TaskEntity> listUserTasks(Integer userId) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<UserEntity> cq = builder.createQuery(UserEntity.class);
		Root<UserEntity> userEntity = cq.from(UserEntity.class);
		cq.select(builder.construct(UserEntity.class, userEntity.get("tasks")));
		Predicate userIdPredicate = builder.equal(userEntity.get("id"), userId);
		cq.where(userIdPredicate);

		TypedQuery<UserEntity> query = em.createQuery(cq);
		//List<TaskEntity> a = (List<TaskEntity>) (query.getResultList());
		return null;
	}

}
