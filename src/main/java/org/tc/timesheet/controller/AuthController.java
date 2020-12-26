package org.tc.timesheet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tc.timesheet.dto.TimeSheetDto;
import org.tc.timesheet.service.TimeSheetService;

@RestController
@RequestMapping("/login")
public class AuthController {

	@Autowired TimeSheetService timeSheetService;
	
	
	@GetMapping
	public List<TimeSheetDto> getEmpInfo(@RequestParam(name = "userName",required = true) String userName,
			@RequestParam(name = "password", required = true) String password) {
		List<TimeSheetDto> list = timeSheetService.getEmployeeInformation(userName, password);
		return list;
	}
}
