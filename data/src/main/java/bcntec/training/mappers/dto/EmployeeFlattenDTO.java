package bcntec.training.mappers.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeFlattenDTO {

    private Integer employeeId;
    private String employeeName;
    private Integer divisionId;
    private String divisionName;
    private String employeeStartDt;



}
