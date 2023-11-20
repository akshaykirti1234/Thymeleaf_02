package tech.csm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.csm.model.Department;
import tech.csm.repository.DepartmentRepo;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

}
