package fun.riqian.controller.environment;

import fun.riqian.domain.Environment;
import fun.riqian.service.environment.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/environment")
public class EnvironmentController {

    /**
     * 自动装填来自 Service 的对象
     */
    @Autowired
    private EnvironmentService envSrv;

    /**
     * @return 返回小程序所需要的 JSON 数据
     */
    @RequestMapping("/findAll")
    // @RequestBody可以获取请求体，需要在控制器方法设置一个形参，使用@RequestBody进行标识，
    // 当前请求的请求体就会为当前注解所标识的形参赋值
    public @ResponseBody List<Environment> findAll() {
        return envSrv.findAll();
    }
}
