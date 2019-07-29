package com.tugbakaya.taskmanagementservices.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tugbakaya.taskmanagemententities.entity.TaskEntity;
import com.tugbakaya.taskmanagemententities.entity.UserEntity;
import com.tugbakaya.taskmanagemententities.enumeration.TaskState;
import com.tugbakaya.taskmanagementservices.service.TaskService;
import com.tugbakaya.taskmanagementservices.service.UserService;



@RestController
@RequestMapping("/task-management")
public class TaskManagementRestController {
	
	@Autowired
	@Qualifier("taskService")
	TaskService taskService;
	
	
	@Autowired
	UserService userService;
	
	@GetMapping(path = "/task/list")
	public ResponseEntity<List<TaskEntity>> findAllTasks()
	{
		Iterator it = taskService.findAllTasks().iterator();
		List<TaskEntity> taskList = new ArrayList<>();
		while(it.hasNext())
		{
			taskList.add((TaskEntity) it.next());
		}
		 
		return new ResponseEntity<List<TaskEntity>>(taskList, HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/task/save")
	public ResponseEntity<TaskEntity> saveTask(@RequestBody TaskEntity taskEntity)
	{
		return new ResponseEntity<TaskEntity>(taskService.saveTask(taskEntity),HttpStatus.OK);
	}
	
	@GetMapping(path = "/task/find")
	public ResponseEntity<List<TaskEntity>> findTaskByTaskName(@RequestParam String taskName)
	{
		List<TaskEntity> taskList = taskService.findByTaskNameIgnoreCaseContaining(taskName);
		return new ResponseEntity<List<TaskEntity>>(taskList, HttpStatus.OK);
	}

	
	
	@GetMapping(path = "/user/list")
	public ResponseEntity<List<UserEntity>> findAllUsers()
	{
		Iterator it = userService.findAllUsers().iterator();
		List<UserEntity> userList = new ArrayList<>();
		while(it.hasNext())
		{
			userList.add((UserEntity)it.next());
		}
		if(userList.isEmpty())
		{
			return new ResponseEntity<List<UserEntity>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserEntity>>(userList,HttpStatus.OK);
		
		
	}
	
	@PostMapping(path = "/user/save")
	public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity userEntity)
	{
		return new ResponseEntity<UserEntity>(userService.saveUser(userEntity),HttpStatus.OK);
	}
	
	@GetMapping(path="/assignTask")
	public ResponseEntity<String> assignTask(@RequestParam Integer userId, @RequestParam Integer taskId)
	{
		userService.assignTask(userId, taskId);
		return new ResponseEntity<String>("taskAssigned",HttpStatus.OK);
	}
	
	@GetMapping(path = "/endTask")
	public ResponseEntity<String> endTask(@RequestParam Integer taskId)
	{
		TaskEntity taskEntity = taskService.getTaskById(taskId);
		if(taskEntity==null)
		{
			return new ResponseEntity<String>("Task bulunamadi",HttpStatus.BAD_REQUEST);
		}
		if(taskEntity.getTaskState()!=TaskState.PROCESS)
		{
			return new ResponseEntity<String>("Task bulunamadi",HttpStatus.BAD_REQUEST);
		}
		taskService.endTask(taskId);
		return new ResponseEntity<String>("Task Sonlandirildi",HttpStatus.OK);
	}
	
	@GetMapping(path="/listUserTasks")
	public ResponseEntity<List<TaskEntity>> listUserTasks(@RequestParam Integer userId)
	{

		return new ResponseEntity<List<TaskEntity>>(userService.listUserTasks(userId),HttpStatus.OK);
		
	}

	
}
