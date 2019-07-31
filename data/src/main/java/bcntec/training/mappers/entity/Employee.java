package bcntec.training.mappers.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Employee {

    private Integer id;
    private String name;
    private Division division;
    private LocalDateTime startDt;


}
