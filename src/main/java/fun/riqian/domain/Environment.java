package fun.riqian.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Environment {
    private Integer id;
    private String cameraId;
    private Float envTemperature;
    private Float envHumidness;
    private Integer envAqi;
    private Date updateTime;
}
