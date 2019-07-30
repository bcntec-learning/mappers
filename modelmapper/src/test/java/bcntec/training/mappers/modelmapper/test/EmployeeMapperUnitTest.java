package bcntec.training.mappers.modelmapper.test;

import bcntec.training.mappers.dto.EmployeeDTO;
import bcntec.training.mappers.entity.Employee;
import bcntec.training.mappers.mapper.EmployeeMapper;
import bcntec.training.mappers.test.AbstractEmployeeMapperUnitTest;
import org.modelmapper.ModelMapper;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class EmployeeMapperUnitTest extends AbstractEmployeeMapperUnitTest {
    private static ModelMapper modelMapper = new ModelMapper();

    @Override
    public EmployeeMapper getMapper() {
        return new EmployeeMapper() {

            @Override
            public EmployeeDTO employeeToEmployeeDTO(Employee entity) {
                return modelMapper.map(entity, EmployeeDTO.class);
            }

            @Override
            public Employee employeeDTOtoEmployee(EmployeeDTO dto) {
                return modelMapper.map(dto, Employee.class);
            }


            @Override
            public List<Employee> convertEmployeeDTOListToEmployeeList(List<EmployeeDTO> list) {
                return list.stream().map(e -> modelMapper.map(e, Employee.class)).collect(toList());
            }

            @Override
            public List<EmployeeDTO> convertEmployeeListToEmployeeDTOList(List<Employee> list) {
                return list.stream().map(e -> modelMapper.map(e, EmployeeDTO.class)).collect(toList());
            }
        };
    }
}
