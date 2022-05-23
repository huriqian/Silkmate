package fun.riqian.dao;

import fun.riqian.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {

    List<Employee> findAll();

    Employee getEmployeeById(Integer id);

    void insertEmployee(Employee employee);

    void deleteEmployee(Integer id);

    void updateEmployee(Employee employee);
}
