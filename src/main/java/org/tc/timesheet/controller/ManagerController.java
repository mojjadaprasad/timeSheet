package org.tc.timesheet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import org.tc.timesheet.dto.ManagerDto;
import org.tc.timesheet.service.ManagerService;

@RestController
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	ManagerService service;

	@GetMapping
	@RequestMapping
	public List<ManagerDto> list() {
		List<ManagerDto> list = new ArrayList<>();
		list = service.findAll();
		return list;
	}

	@PostMapping
	@ResponseBody
	public ManagerDto addManager(@RequestBody ManagerDto managerModel) {
		ManagerDto addManager = service.save(managerModel);
		return addManager;
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ManagerDto getById(@PathVariable(value = "id") Long id) {
		ManagerDto manager = service.findById(id);
		return manager;
	}

	@PutMapping
	@ResponseBody
	public ManagerDto updateManagerDetails(ManagerDto managerDto) {
		ManagerDto updateManager = service.updateManagerDetails(managerDto);
		return updateManager;
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public Map<String, Object> deleteAssignment(@PathVariable(value = "id") Long id) {
		Map<String, Object> responseMap = service.deleteManager(id);
		return responseMap;
	}
}
