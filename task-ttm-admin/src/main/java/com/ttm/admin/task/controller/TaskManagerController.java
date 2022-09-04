package com.ttm.admin.task.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttm.admin.common.model.entity.task.Task;
import com.ttm.admin.common.model.vo.task.FilterTaskRequest;
import com.ttm.admin.common.model.vo.task.TaskRequest;
import com.ttm.admin.common.model.vo.task.TaskResponse;
import com.ttm.admin.task.service.TaskManagerService;

@RestController
@RequestMapping(value = "/api/task")
public class TaskManagerController {
	
	@Autowired
	private TaskManagerService taskManagerService;

	@GetMapping(value = "/ping")
	public ResponseEntity<String> ping() {
		return new ResponseEntity<String>("pong", HttpStatus.OK);
	}

	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest taskRequest) {
		Task task = TaskManagerConverter.requestToEntityToCreate(taskRequest);
		task = taskManagerService.createTask(task);
		TaskResponse response = TaskManagerConverter.entityToResponse(task);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TaskResponse> updateTask(@RequestBody TaskRequest taskRequest) {

		Task task = TaskManagerConverter.requestToEntityToUpdate(taskRequest);
		task = taskManagerService.updateTask(task);
		TaskResponse response = TaskManagerConverter.entityToResponse(task);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TaskResponse> deleteTask() {

		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TaskResponse> readTask(@PathVariable String id) {

		Task task = taskManagerService.readTask(id);
		TaskResponse response = TaskManagerConverter.entityToResponse(task);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TaskResponse>> listTask(@RequestBody FilterTaskRequest filter) {

		List<TaskResponse> taskRespList = new ArrayList<>();
		
		Task task = TaskManagerConverter.filterRequestToEntity(filter);
		List<Task> taskList = taskManagerService.listTask(task);
		
		taskList.stream().forEach(t -> taskRespList.add(TaskManagerConverter.entityToResponse(t)));
		
		return new ResponseEntity<>(taskRespList, HttpStatus.OK);
	}

}
