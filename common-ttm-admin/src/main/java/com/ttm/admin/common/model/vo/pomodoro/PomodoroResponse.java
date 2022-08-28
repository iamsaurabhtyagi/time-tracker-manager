package com.ttm.admin.common.model.vo.pomodoro;

import java.util.ArrayList;
import java.util.List;

public class PomodoroResponse {

	private String id;
	private String taskId;
	private String status;
	private String stage;
	private String startTime;
	private List<PomodoroCycleResponse> pomodoroCycle = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public List<PomodoroCycleResponse> getPomodoroCycle() {
		return pomodoroCycle;
	}

	public void setPomodoroCycle(List<PomodoroCycleResponse> pomodoroCycle) {
		this.pomodoroCycle = pomodoroCycle;
	}

	public void addPomodoroCycle(PomodoroCycleResponse pomodoroCycle) {
		this.pomodoroCycle.add(pomodoroCycle);
	}

}
