package org.tc.timesheet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.tc.timesheet.model.AssignmentModel;

@Repository
public interface AssignmentRepository extends JpaRepository<AssignmentModel, Long> {

	
	@Query("from AssignmentModel where ((:employeeId is NULL or employee.id=:employeeId) AND status='Active')")
	List<AssignmentModel> findAssignments(@Param(value = "employeeId") Long employeeId);

}
