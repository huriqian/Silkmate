package fun.riqian.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String empName;
    private String gender;
    private Integer age;

}
