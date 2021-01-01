package org.tc.timesheet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.tc.timesheet.model.EmployeeModel;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

	@Query("from EmployeeModel where ((userName=:userName OR mobile=:mobileNo) AND password=:password)")
	public List<EmployeeModel> getEmployeeInformation(@Param("userName")String userName,@Param("password") String password,@Param("mobileNo") String mobileNo);
}
