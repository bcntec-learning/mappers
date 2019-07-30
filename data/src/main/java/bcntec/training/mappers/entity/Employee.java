package bcntec.training.mappers.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Employee {

    private Integer id;
    private String name;
    private Division division;
    private Date startDt;


}
