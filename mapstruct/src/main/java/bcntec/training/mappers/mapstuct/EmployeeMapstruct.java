package bcntec.training.mappers.mapstuct;

import bcntec.training.mappers.dto.DivisionDTO;
import bcntec.training.mappers.dto.EmployeeDTO;
import bcntec.training.mappers.entity.Division;
import bcntec.training.mappers.entity.Employee;
import bcntec.training.mappers.mapper.EmployeeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapstruct extends EmployeeMapper {

    EmployeeMapstruct INSTANCE = Mappers.getMapper(EmployeeMapstruct.class);

    @Override
    @Mappings({
            @Mapping(target = "startDt", source = "entity.startDt", dateFormat = "dd-MM-yyyy HH:mm:ss")})
    EmployeeDTO employeeToEmployeeDTO(Employee entity);

    @Override
    @Mappings({
            @Mapping(target = "startDt", source = "dto.startDt", dateFormat = "dd-MM-yyyy HH:mm:ss")})
    Employee employeeDTOtoEmployee(EmployeeDTO dto);

    @Override
    //@Mappings({
    //        @Mapping(target="divisionId", source="division.id"),@Mapping(target="divisionName", source="division.name")})
    List<EmployeeDTO> convertEmployeeListToEmployeeDTOList(List<Employee> list);


    //extra converters e

    DivisionDTO divisionToDivisionDTO(Division entity);

    Division divisionDTOtoDivision(DivisionDTO dto);

}
