package com.ttm.admin.common.model.entity.pomodoro;

import com.ttm.admin.common.enums.pomodoro.POMODORO_ON;
import com.ttm.admin.common.enums.pomodoro.POMODORO_STATUS;

public class PomodoroCycle {

	/**
	 * Default value for work = 25 min and for break = 5 min and 15 min after 4
	 * cycle. If user updated these values in profile then value must be used as per
	 * profile
	 */
	private int duration;

	/**
	 * User can be on WORK or BREAK
	 */
	private POMODORO_ON on;

	/**
	 * Cycle Start Time
	 */
	private String startTime;

	/**
	 * Cycle End Time
	 */
	private String endTime;

	/**
	 * one cycle is equal to 2 steps, one step of WORK and one of BREAK
	 */
	private int cycle;

	/**
	 * Step represent to a step of cycle
	 */
	private int step;

	private POMODORO_STATUS status;

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public POMODORO_ON getOn() {
		return on;
	}

	public void setOn(POMODORO_ON on) {
		this.on = on;
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

	public POMODORO_STATUS getStatus() {
		return status;
	}

	public void setStatus(POMODORO_STATUS status) {
		this.status = status;
	}

}
