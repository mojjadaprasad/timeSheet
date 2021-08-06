package org.tc.timesheet.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.tc.timesheet.dto.EmployeeDto;
import org.tc.timesheet.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
static final Logger logg = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	EmployeeService service;

	@GetMapping
	@ResponseBody
	public List<EmployeeDto> getList() {
		List<EmployeeDto> list = service.findAll();
		logg.info("Responce:{}",list);
		return list;
	}

	@PostMapping
	@ResponseBody
	public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeModel) {
		EmployeeDto employee = service.save(employeeModel);
		logg.info("Responce:{{}}",employee);
		return employee;
	}

	@GetMapping("/{id}")
	@ResponseBody
	public EmployeeDto getById(@PathVariable(value = "id") Long id) {
		EmployeeDto employeeModel = service.findById(id);
		logg.info("Responce:{{}}",employeeModel);
		return employeeModel;
	}

	@PutMapping
	@ResponseBody
	public EmployeeDto empDetailsUpdate(@RequestBody EmployeeDto employeeModel) {
		EmployeeDto updateData = service.update(employeeModel);
		logg.info("Responce:{{}}",updateData);
		return updateData;
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public Map<String, Object> deleteEmployee(@PathVariable(value = "id") Long id) {
		Map<String, Object> responseMap = service.deleteEmployee(id);
		logg.info("Responce:{{}}",responseMap);
		return responseMap;
	}
}
