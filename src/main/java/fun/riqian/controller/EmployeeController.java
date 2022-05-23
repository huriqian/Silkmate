package fun.riqian.controller;

import fun.riqian.domain.Employee;
import fun.riqian.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    /**
     * 自动装填来自 Service 的对象
     */
    @Autowired
    private EmployeeService employeeSrv;


    /**
     * @return 返回小程序所需要的 JSON 数据
     */
    @RequestMapping("/findAll")
    // @RequestBody可以获取请求体，需要在控制器方法设置一个形参，使用@RequestBody进行标识，
    // 当前请求的请求体就会为当前注解所标识的形参赋值
    public @ResponseBody List<Employee> findAll() {
        System.out.println("Controller表现层: 查询所有账户......");
        return employeeSrv.findAll();
    }

    /**
     * 进入员工列表视图，在其中完成 CRUD 操作
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showEmployeeList(Model model) {
        Collection<Employee> list = employeeSrv.findAll();
        model.addAttribute("employeeList", list);
        return "employee/employee_list";
    }

    /**
     * 完成员工数据的增加操作（注册）
     */
    @RequestMapping(value = "/registerPage", method = RequestMethod.GET)
    public String register() {
        return "employee/register";
    }

    /**
     * 完成员工数据的修改操作
     * 通过后端获取待修改的员工信息，将对应员工对象回显
     */
    @RequestMapping(value = "/registerPage/{id}", method = RequestMethod.GET)
    public String returnUpdatePage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeSrv.getEmployeeById(id);
        // 将后端传入的 男/女 转换成 1/0
        employee.setGender(employee.getGender().equals("男") ? "1" : "0");
        model.addAttribute("employee", employee);
        return "employee/update";
    }

    /**
     * 通过获取表单提交的信息，将对应员工对象增加入数据库
     * @param employee: 从前端返回的员工对象(id:null, empName:String, gender:0/1. age:Integer)
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmployee(Employee employee) {
        String gender = employee.getGender();
        // 将前端传入的 1/0 转换成 男/女
        employee.setGender(gender.equals("1") ? "男" : "女");
        employeeSrv.insertEmployee(employee);
        // 直接重定向的是上面那个 /employee/list (路径写完全)
        return "redirect:/employee/list";
    }

    /**
     * 修改完成后写入数据库
     * @param employee: 从前端返回的员工对象(id:原id, empName:String, gender:0/1. age:Integer)
     */
    @RequestMapping(value = "/save/{id}", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee) {
        String gender = employee.getGender();
        // 将前端传入的 1/0 转换成 男/女
        employee.setGender(gender.equals("1") ? "男" : "女");
        employeeSrv.updateEmployee(employee);
        // 直接重定向的是上面那个 /employee/list (路径写完全)
        return "redirect:/employee/list";
    }

    /**
     * 通过员工的id对员工数据进行删除
     * @param id: 需要删除的员工ID信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeSrv.deleteEmployee(id);
        // 要用重定向; 如果用转发, 地址栏中会保留 id 信息
        // 如果用重定向, 地址栏就会跳转到同样的 employee_list.html, 用户看起来相同
        // 先删除, 然后再用 GET 方法请求
        return "redirect:/employee/list";
    }
}
