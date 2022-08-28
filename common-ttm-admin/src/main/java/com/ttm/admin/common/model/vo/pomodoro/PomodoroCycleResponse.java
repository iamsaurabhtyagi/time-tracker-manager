package com.ttm.admin.common.model.vo.pomodoro;

import com.ttm.admin.common.enums.pomodoro.ON;

public class PomodoroCycleResponse {

	private ON on;
	private int cycle;
	private int step;
	private int duration;
	private String status;
	private String startTime;
	private String endTime;

	public ON getOn() {
		return on;
	}

	public void setOn(ON on) {
		this.on = on;
	}

	public int getCycle() {
		return cycle;
	}

	public void setCycle(int cycle) {
		this.cycle = cycle;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

}
