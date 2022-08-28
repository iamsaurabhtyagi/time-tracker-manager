package com.ttm.admin.pomodoro.controller.activate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttm.admin.common.model.entity.pomodoro.Pomodoro;
import com.ttm.admin.common.model.vo.pomodoro.PomodoroRequest;
import com.ttm.admin.common.model.vo.pomodoro.PomodoroResponse;
import com.ttm.admin.pomodoro.service.activate.PomodoroActivateService;

@RestController
@RequestMapping(value = "/pomodoro/api")
public class PomodoroActivateController {
	
	@Autowired
	private PomodoroActivateService service;
	
	@GetMapping(value = "/ping")
	public ResponseEntity<String> ping() {
		return new ResponseEntity<>("pong..", HttpStatus.OK);
	}
	
	@PostMapping(value = "/start/step", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PomodoroResponse> startPomodoroStep(@RequestBody PomodoroRequest request) {
		
		//required user information will be in JWT token
		
		PomodoroActivateValidator.validatePomodoroRequest(request);
		Pomodoro pomodoro = PomodoroActivateConverter.requestToEntity(request);
		
		pomodoro = service.startPomodoroStep(pomodoro);
		
		PomodoroResponse response = PomodoroActivateConverter.entityToResponse(pomodoro);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(value = "/stop/step/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PomodoroResponse> stopPomodoroStep(@PathVariable String id) {
		
		Pomodoro pomodoro = service.completePomodoroStep(id);
		
		PomodoroResponse response = PomodoroActivateConverter.entityToResponse(pomodoro);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
