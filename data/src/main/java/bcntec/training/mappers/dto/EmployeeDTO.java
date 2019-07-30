package bcntec.training.mappers.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {

    private Integer id;
    private String name;
    private DivisionDTO division;
    private String startDt;

}
