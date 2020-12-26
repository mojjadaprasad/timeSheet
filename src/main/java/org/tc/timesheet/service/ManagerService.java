package org.tc.timesheet.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tc.timesheet.dto.ManagerDto;
import org.tc.timesheet.exception.ResourceNotFoundException;
import org.tc.timesheet.model.AssignmentModel;
import org.tc.timesheet.model.ManagerModel;
import org.tc.timesheet.repository.ManagerRepository;
import org.tc.timesheet.util.MapperUtil;

@Service
public class ManagerService {

	@Autowired
	ManagerRepository repository;

	public List<ManagerDto> findAll() {
		List<ManagerModel> managerList = repository.findAll();
		List<ManagerDto> managerDtoList = MapperUtil.map(managerList, ManagerDto.class);
		return managerDtoList;
	}

	public ManagerDto save(ManagerDto managerDto) {
		ManagerModel manager = MapperUtil.map(managerDto, ManagerModel.class);
		manager.setCreatedOn(new Date());
		manager = repository.save(manager);
		manager.setStatus("Active");
		managerDto = MapperUtil.map(manager, ManagerDto.class);
		return managerDto;
	}

	public ManagerDto findById(Long id) {
		ManagerModel manager = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Manager not found"));
		ManagerDto managerDto = MapperUtil.map(manager, ManagerDto.class);
		return managerDto;
	}

	public ManagerDto updateManagerDetails(ManagerDto managerDto) {
		ManagerModel manager = MapperUtil.map(managerDto, ManagerModel.class);
		manager = repository.save(manager);
		managerDto = MapperUtil.map(manager, ManagerDto.class);
		return managerDto;
	}

	public Map<String, Object> deleteManager(Long id) {
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("response", "Successfully Deleted Record");
		// TODO Auto-generated method stub
		ManagerModel model = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Manager not found:"));
		model.setStatus("InActive");
		model = repository.save(model);
		return responseMap;
	}
}
