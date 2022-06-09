package fun.riqian.service.environment;

import fun.riqian.dao.environment.EnvironmentDao;
import fun.riqian.domain.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvironmentServiceImpl implements EnvironmentService {

    @Autowired
    private EnvironmentDao envDao;

    @Override
    public List<Environment> findAll() {
        return envDao.findALl();
    }

    @Override
    public Environment getEnvById(Integer id) {
        return envDao.getEnvById(id);
    }
}
