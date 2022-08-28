package com.ttm.admin.common.model.entity.pomodoro;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pomodoro {

	@Id
	private ObjectId id;

	// userID, groupID, startTime, EndTime, Status, stage, taskId, createdAt,
	// updatedAt

	private List<PomodoroCycle> pomodoroCycle = new ArrayList<>();

	/**
	 * User ID
	 */
	private String userId;

	/**
	 * user can belong to a group or can be individual
	 */
	private String groupId;

	/**
	 * ID of task on which user was working
	 */
	private String taskId;

	/**
	 * ACTIVE OR COMPLETE OR FAILED OR INACTIVE
	 */
	private String status;

	/**
	 * Stage can be complete if task is complete otherwise stage will be in-progress
	 * and if user stopped pomodoro cycle without task complete then stage will be
	 * incomplete Note: for every activity after pomodoro start always new record
	 * will be inserted like if user stopped then new record will be created for
	 * stopped activity with incomplete stage
	 */
	private String stage;

	private String date;

	/**
	 * POMODORO Start Time
	 */
	private String startTime;

	/**
	 * POMODORO End Time
	 */
	private String endTime;

	private String createdBy;

	private String updatedBy;

	private String createdAt;

	private String updatedAt;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public List<PomodoroCycle> getPomodoroCycle() {
		return pomodoroCycle;
	}

	public void setPomodoroCycle(List<PomodoroCycle> pomodoroCycle) {
		this.pomodoroCycle = pomodoroCycle;
	}

	public void addPomodoroCycle(PomodoroCycle pomodoroCycle) {
		this.pomodoroCycle.add(pomodoroCycle);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

}
