package bcntec.training.mappers.modelmapper.test;

import bcntec.training.mappers.dto.EmployeeFlattenDTO;
import bcntec.training.mappers.entity.Employee;
import bcntec.training.mappers.mapper.EmployeeFlattenMapper;
import bcntec.training.mappers.test.AbstractEmployeeFlattenMapperUnitTest;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class EmployeeFlattenMapperUnitTest extends AbstractEmployeeFlattenMapperUnitTest {
    private static ModelMapper modelMapper = new ModelMapper();

    private static TypeMap<EmployeeFlattenDTO, Employee> typeMap1 =
            modelMapper.createTypeMap(EmployeeFlattenDTO.class, Employee.class);

    private static TypeMap<Employee, EmployeeFlattenDTO> typeMap2 =
            modelMapper.createTypeMap(Employee.class, EmployeeFlattenDTO.class);

    {
        //modelMapper.getConfiguration().setMatchingStrategy()
        /*
        to avoid this ambiguity error you need determine what method is a map property
        1) The destination property bcntec.training.mappers.entity.Employee.setName() matches multiple source property hierarchies:
	        bcntec.training.mappers.dto.EmployeeFlattenDTO.getEmployeeName()
	        bcntec.training.mappers.dto.EmployeeFlattenDTO.getDivisionName()

         */
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        typeMap1.addMappings(mapper -> {
            mapper.map(EmployeeFlattenDTO::getEmployeeId, Employee::setId);
            mapper.map(EmployeeFlattenDTO::getEmployeeName, Employee::setName);
        });
        typeMap2.addMappings(mapper -> {
            mapper.map(Employee::getId, EmployeeFlattenDTO::setEmployeeId);
            mapper.map(Employee::getName, EmployeeFlattenDTO::setEmployeeName);
        });

        PropertyMap<Employee, EmployeeFlattenDTO> employeeMap = new PropertyMap<Employee, EmployeeFlattenDTO>() {
            protected void configure() {
                map().setDivisionId(source.getDivision().getId());
                map().setDivisionName(source.getDivision().getName());
            }
        };
    }
    @Override
    public EmployeeFlattenMapper getMapper() {
        return new EmployeeFlattenMapper() {

            @Override
            public EmployeeFlattenDTO employeeToEmployeeDTO(Employee entity) {
                return modelMapper.map(entity, EmployeeFlattenDTO.class);
            }

            @Override
            public Employee employeeDTOtoEmployee(EmployeeFlattenDTO dto) {
                return modelMapper.map(dto, Employee.class);
            }

            @Override
            public List<Employee> convertEmployeeDTOListToEmployeeList(List<EmployeeFlattenDTO> list) {
                return list.stream().map(e -> modelMapper.map(e, Employee.class)).collect(toList());
            }

            @Override
            public List<EmployeeFlattenDTO> convertEmployeeListToEmployeeDTOList(List<Employee> list) {
                return list.stream().map(e -> modelMapper.map(e, EmployeeFlattenDTO.class)).collect(toList());
            }
        };
    }
}
