package com.tugbakaya.taskmanagemententities.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import com.tugbakaya.taskmanagemententities.enumeration.TaskState;

import lombok.Data;

@Entity
@Data
@Audited
public class TaskEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@CreationTimestamp
	private Date createTime;

	@UpdateTimestamp
	private Date lastUpdateTime;

	private String taskName;

	private String eventDescription;

	private TaskState taskState;

}
