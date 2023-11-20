package tech.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.model.Employee;
import tech.csm.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public List<Employee> getAllEmp() {
		return employeeRepo.getAllEmp();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public void deleteEmpById(String empId) {
		employeeRepo.deleteById(empId);
	}

	@Override
	public Employee getEmployeeById(String empId) {
		return employeeRepo.findById(empId).get();
	}

	@Override
	public void softDelete(String empId) {
		employeeRepo.softDelete(empId);
	}

}
