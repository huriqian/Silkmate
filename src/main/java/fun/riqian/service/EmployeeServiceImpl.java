package fun.riqian.service;

import fun.riqian.dao.EmployeeDao;
import fun.riqian.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> findAll() {
        System.out.println("Service业务层: 查询所有用户......");
        return employeeDao.findAll();
    }

    @Override
    public void insertEmployee(Employee employee) {
        System.out.println("Service业务层: 增加用户信息......");
        employeeDao.insertEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        System.out.println("Service业务层: 删除id为" + id + "的用户......");
        employeeDao.deleteEmployee(id);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        System.out.println("Service业务层: 修改id为" + employee.getId() + "的用户信息......");
        employeeDao.updateEmployee(employee);
    }
}
