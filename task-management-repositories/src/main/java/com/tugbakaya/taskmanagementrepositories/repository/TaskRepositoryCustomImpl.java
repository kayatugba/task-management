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
import javax.transaction.Transactional;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

import com.tugbakaya.taskmanagemententities.entity.TaskEntity;
import com.tugbakaya.taskmanagemententities.enumeration.TaskState;

@Repository
public class TaskRepositoryCustomImpl implements TaskRepositoryCustom {

	@PersistenceContext
	EntityManager em;

	@Override
	public Iterable<TaskEntity> findAllTasks() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<TaskEntity> cq = builder.createQuery(TaskEntity.class);
		Root<TaskEntity> taskEntity = cq.from(TaskEntity.class);

		TypedQuery<TaskEntity> query = em.createQuery(cq);
		return query.getResultList();

	}

	@Override
	public TaskEntity saveTask(TaskEntity task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskEntity> findByTaskNameIgnoreCaseContaining(String name) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<TaskEntity> cq = builder.createQuery(TaskEntity.class);
		Root<TaskEntity> taskEntity = cq.from(TaskEntity.class);

		Predicate taskNamePredicate = builder.like(taskEntity.get("taskName"), "%" + name + "%");
		cq.where(taskNamePredicate);

		TypedQuery<TaskEntity> query = em.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public TaskEntity getTaskById(Integer id) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<TaskEntity> cq = builder.createQuery(TaskEntity.class);
		Root<TaskEntity> taskEntity = cq.from(TaskEntity.class);

		Predicate taskIdPredicate = builder.equal(taskEntity.get("id"), id);
		cq.where(taskIdPredicate);
		TypedQuery<TaskEntity> query = em.createQuery(cq);
		return query.getResultList().get(0);
	}

	@Override
	@Transactional
	public void endTask(Integer id) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaUpdate<TaskEntity> cq = builder.createCriteriaUpdate(TaskEntity.class);
		Root<TaskEntity> taskEntity = cq.from(TaskEntity.class);
		cq.set("taskState", TaskState.DONE);
		Predicate taskIdPredicate = builder.equal(taskEntity.get("id"), id);
		cq.where(taskIdPredicate);
		em.createQuery(cq).executeUpdate();
	

	}

}
