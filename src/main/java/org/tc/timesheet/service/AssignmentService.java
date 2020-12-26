package org.tc.timesheet.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tc.timesheet.dto.AssignmentDto;
import org.tc.timesheet.exception.ResourceNotFoundException;
import org.tc.timesheet.model.AssignmentModel;
import org.tc.timesheet.repository.AssignmentRepository;
import org.tc.timesheet.util.MapperUtil;

@Service
public class AssignmentService {

	@Autowired
	AssignmentRepository assignmentRepository;

	public List<AssignmentDto> findAll() throws IllegalAccessException, InvocationTargetException {
		List<AssignmentDto> dtoList = new ArrayList<>();
		List<AssignmentModel> list = assignmentRepository.findAll();
		dtoList = MapperUtil.map(list, AssignmentDto.class);
		return dtoList;
	}

	public AssignmentDto create(AssignmentDto assignmentDto) throws IllegalAccessException, InvocationTargetException {

		AssignmentModel assignment = MapperUtil.map(assignmentDto, AssignmentModel.class);
		assignment.setCreatedOn(new Date());
		assignment.setStatus("Active");
		assignment = assignmentRepository.save(assignment);
		assignmentDto = MapperUtil.map(assignment, AssignmentDto.class);
		return assignmentDto;
	}

	public AssignmentDto findById(Long id) {
		AssignmentModel assignmentModel = assignmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Assignment not found:"));
		AssignmentDto assignmentDto = MapperUtil.map(assignmentModel, AssignmentDto.class);
		return assignmentDto;
	}

	public AssignmentDto updateAssignment(AssignmentDto assignmentDto) {
		AssignmentModel assignment = MapperUtil.map(assignmentDto, AssignmentModel.class);
		assignment = assignmentRepository.save(assignment);
		assignmentDto = MapperUtil.map(assignment, AssignmentDto.class);
		return assignmentDto;
	}

	public Map<String, Object> deleteAssignment(Long id) {
		Map<String,Object> responseMap =new HashMap<>();
		responseMap.put("response","Successfully Deleted Record");
		// TODO Auto-generated method stub
	AssignmentModel model=	assignmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Assignment not found:"));
	model.setStatus("InActive");
	model=assignmentRepository.save(model);
		return responseMap;
	}

}
