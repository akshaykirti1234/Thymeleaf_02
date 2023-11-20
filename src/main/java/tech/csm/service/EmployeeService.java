package tech.csm.service;

import java.util.List;

import tech.csm.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmp();

	Employee saveEmployee(Employee employee);

	void deleteEmpById(String empId);

	Employee getEmployeeById(String empId);

	void softDelete(String empId);

}
