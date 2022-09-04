package com.ttm.admin.task.service;

import java.util.List;

import com.ttm.admin.common.model.entity.task.Task;

public interface TaskManagerService {
	
	Task createTask(Task task);
	
	Task updateTask(Task task);
	
	Task deleteTask(String id);
	
	Task readTask(String id);
	
	List<Task> listTask(Task task);

}
