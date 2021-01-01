package org.tc.timesheet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tc.timesheet.dto.EmployeeDto;
import org.tc.timesheet.service.EmployeeService;

@RestController
@RequestMapping("/login")
public class AuthController {

	@Autowired EmployeeService service;
	
	
	@PostMapping
	public EmployeeDto getEmpInfo(@RequestBody EmployeeDto dto) {
		List<EmployeeDto> list = service.login(dto.getUserName(), dto.getPassword(),dto.getMobile());
		return list.get(0);
	}
}
