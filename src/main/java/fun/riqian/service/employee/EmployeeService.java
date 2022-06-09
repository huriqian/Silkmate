package fun.riqian.service.employee;

import fun.riqian.domain.Employee;

import java.util.List;

public interface EmployeeService {

    // 查询所有用户信息
    List<Employee> findAll();

    Employee getEmployeeById(Integer id);

    // 增加一条用户信息
    void insertEmployee(Employee employee);

    void deleteEmployee(Integer id);

    void updateEmployee(Employee employee);
}
