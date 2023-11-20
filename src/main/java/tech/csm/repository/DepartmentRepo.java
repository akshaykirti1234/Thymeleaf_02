package tech.csm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.csm.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
