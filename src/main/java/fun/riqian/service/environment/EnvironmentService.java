package fun.riqian.service.environment;

import fun.riqian.domain.Environment;

import java.util.List;

public interface EnvironmentService {

    List<Environment> findAll();

    Environment getEnvById(Integer id);
}
