package org.tc.timesheet.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tc.timesheet.dto.EmployeeDto;
import org.tc.timesheet.service.EmployeeService;
import org.tc.timesheet.util.Messages;
import org.tc.timesheet.util.ResponceException;

@RestController
@RequestMapping("/login")
public class AuthController {
	static final Logger logg = LoggerFactory.getLogger(AuthController.class);
	@Autowired
	EmployeeService service;

	@PostMapping
	public EmployeeDto getEmpInfo(@RequestBody EmployeeDto dto) throws ResponceException   {
		List<EmployeeDto> list = service.login(dto.getUserName(), dto.getPassword(), dto.getMobile());
		if (list == null || list.isEmpty()) {
			logg.info("Request:{{}}" ,Messages.INVALID_CREDENTIALS);
			throw new ResponceException(Messages.INVALID_CREDENTIALS);
		} else {
			logg.info("Responce:{{}}", Messages.LOGIN_SUCCESS);
		}
		return list.get(0);
	}
}
