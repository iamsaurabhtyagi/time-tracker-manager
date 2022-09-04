package com.ttm.admin.task.controller;

import java.util.Date;

import com.ttm.admin.common.config.CommonDateFormatter;
import com.ttm.admin.common.enums.task.TASK_STATUS;
import com.ttm.admin.common.model.entity.task.Task;
import com.ttm.admin.common.model.vo.task.FilterTaskRequest;
import com.ttm.admin.common.model.vo.task.TaskRequest;
import com.ttm.admin.common.model.vo.task.TaskResponse;

public class TaskManagerConverter {

	public static Task requestToEntityToCreate(TaskRequest request) {

		Task task = requestToEntity(request);
		task.setStatus(TASK_STATUS.TODO);		
		task.setCreatedAt(CommonDateFormatter.dateTimeZoneFormatterToString(new Date()));

		return task;
	}
	
	public static Task requestToEntityToUpdate(TaskRequest request) {
		return requestToEntity(request);
	}
	
	public static Task requestToEntity(TaskRequest request) {
		Task task = new Task();

		task.setTitle(request.getTitle());
		task.setDescription(request.getDescription());
		task.setUrgent(request.isUrgent());
		task.setImportant(request.isImportant());

		return task;
	}

	public static TaskResponse entityToResponse(Task task) {
		TaskResponse response = new TaskResponse();

		response.setId(task.getId().toHexString());
		response.setTitle(task.getTitle());
		response.setDescription(task.getDescription());
		response.setImportant(task.isImportant());
		response.setUrgent(task.isUrgent());

		return response;
	}
	
	public static Task filterRequestToEntity(FilterTaskRequest filter) {
		Task task = new Task();

		task.setTitle(filter.getTitle());
		task.setDescription(filter.getDescription());
		task.setUrgent(filter.isUrgent());
		task.setImportant(filter.isImportant());

		return task;
	}

}
