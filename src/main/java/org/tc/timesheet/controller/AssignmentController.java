package org.tc.timesheet.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
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
import org.tc.timesheet.dto.AssignmentDto;
import org.tc.timesheet.repository.AssignmentRepository;
import org.tc.timesheet.service.AssignmentService;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {
	@Autowired
	AssignmentRepository assignmentRepository;

	@Autowired
	AssignmentService assignmentService;

	@GetMapping
	@ResponseBody
	public List<AssignmentDto> getList() throws IllegalAccessException, InvocationTargetException {
		List<AssignmentDto> list = assignmentService.findAll();
		return list;
	}

	@GetMapping("/{id}")
	@ResponseBody
	public AssignmentDto getById(@PathVariable(value = "id") Long id) {
		AssignmentDto assignmentDto = assignmentService.findById(id);
		return assignmentDto;
	}

	@PostMapping
	@ResponseBody
	public AssignmentDto addAssignment(@RequestBody AssignmentDto assignmentModel)
			throws IllegalAccessException, InvocationTargetException {
		AssignmentDto assignment = assignmentService.create(assignmentModel);
		return assignment;
	}

	@PutMapping
	@ResponseBody
	public AssignmentDto updateAssignment(@RequestBody AssignmentDto assignmentModel) {
		AssignmentDto updateAssignment = assignmentService.updateAssignment(assignmentModel);
		return updateAssignment;
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public Map<String, Object> deleteAssignment(@PathVariable(value = "id") Long id) {
		Map<String, Object> responseMap = assignmentService.deleteAssignment(id);
		return responseMap;
	}

}
