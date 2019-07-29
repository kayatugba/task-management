package com.tugbakaya.taskmanagemententities.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import lombok.Data;

@Entity
@Data
@Audited
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@CreationTimestamp
	private Date createTime;

	@UpdateTimestamp
	private Date lastUpdateTime;

	private String name;

	@OneToMany(cascade=CascadeType.ALL)
	List<TaskEntity> tasks;

}
