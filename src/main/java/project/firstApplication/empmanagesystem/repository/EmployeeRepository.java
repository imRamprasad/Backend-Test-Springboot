package project.firstApplication.empmanagesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.firstApplication.empmanagesystem.entity.Employee;

import java.util.UUID;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
