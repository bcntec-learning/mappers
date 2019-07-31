package bcntec.training.mappers.mapper;

import bcntec.training.mappers.dto.EmployeeDTO;
import bcntec.training.mappers.entity.Employee;

import java.util.List;

public interface EmployeeMapper {

    EmployeeDTO employeeToEmployeeDTO(Employee entity);

    Employee employeeDTOtoEmployee(EmployeeDTO dto);

    List<Employee> convertEmployeeDTOListToEmployeeList(List<EmployeeDTO> list);

    List<EmployeeDTO> convertEmployeeListToEmployeeDTOList(List<Employee> list);

}
