package bcntec.training.mappers.mapper;

import bcntec.training.mappers.dto.EmployeeFlattenDTO;
import bcntec.training.mappers.entity.Employee;

import java.util.List;

public interface EmployeeFlattenMapper {

    EmployeeFlattenDTO employeeToEmployeeDTO(Employee entity);

    Employee employeeDTOtoEmployee(EmployeeFlattenDTO dto);

    List<Employee> convertEmployeeDTOListToEmployeeList(List<EmployeeFlattenDTO> list);

    List<EmployeeFlattenDTO> convertEmployeeListToEmployeeDTOList(List<Employee> list);


}
