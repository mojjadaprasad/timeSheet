package org.tc.timesheet.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.tc.timesheet.model.TimeSheetModel;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheetModel, Long> {

	@Query("from TimeSheetModel where (assignment.manager.id = :managerId or :managerId is null) AND date between :from AND :to")
	public List<TimeSheetModel> getEmployeeTimesheets(@Param("managerId") Long managerId, @Param("from") Date from, @Param("to") Date to);
	
	@Query("from TimeSheetModel where (assignment.employee.userName=:userName AND assignment.employee.password=:password)")
	public List<TimeSheetModel> getEmployeeInformation(@Param("userName")String userName,@Param("password") String password);

	@Query("from TimeSheetModel where (assignment.id = :assignmentId AND date between :fromDate AND :toDate)")
	public List<TimeSheetModel> findByAssignmentIdAndDateRange(@Param("assignmentId")Long assignmentId, @Param("fromDate")Date fromDate,@Param("toDate") Date toDate);
	
	

}
