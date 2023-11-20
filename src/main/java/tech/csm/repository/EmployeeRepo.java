package tech.csm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tech.csm.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {

	@Query("from Employee where isActive='yes'")
	List<Employee> getAllEmp();

	@Transactional
	@Modifying
	@Query("update Employee set isActive='no' where empId= :empId")
	void softDelete(String empId);
}
