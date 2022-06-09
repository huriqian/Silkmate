package fun.riqian.dao.environment;

import fun.riqian.domain.Environment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvironmentDao {

    List<Environment> findALl();

    Environment getEnvById(Integer id);

}
