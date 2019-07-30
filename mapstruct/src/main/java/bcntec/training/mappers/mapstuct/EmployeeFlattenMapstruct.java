package bcntec.training.mappers.mapstuct;

import bcntec.training.mappers.dto.EmployeeFlattenDTO;
import bcntec.training.mappers.entity.Employee;
import bcntec.training.mappers.mapper.EmployeeFlattenMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeFlattenMapstruct extends EmployeeFlattenMapper {

    EmployeeFlattenMapstruct INSTANCE = Mappers.getMapper(EmployeeFlattenMapstruct.class);

    @Override
    @Mappings({
            @Mapping(target = "employeeId", source = "entity.id"),
            @Mapping(target = "employeeName", source = "entity.name"),
            @Mapping(target = "employeeStartDt", source = "entity.startDt", dateFormat = "dd-MM-yyyy HH:mm:ss"),

            @Mapping(target = "divisionId", source = "division.id"),
            @Mapping(target = "divisionName", source = "division.name")})
    EmployeeFlattenDTO employeeToEmployeeDTO(Employee entity);

    @Override
    @Mappings({
            @Mapping(target = "id", source = "dto.employeeId"),
            @Mapping(target = "name", source = "dto.employeeName"),
            @Mapping(target = "startDt", source = "dto.employeeStartDt", dateFormat = "dd-MM-yyyy HH:mm:ss"),

            @Mapping(target = "division.id", source = "dto.divisionId"),
            @Mapping(target = "division.name", source = "dto.divisionName")})
    Employee employeeDTOtoEmployee(EmployeeFlattenDTO dto);

    @Override
        //@Mappings({
        //        @Mapping(target="divisionId", source="division.id"),@Mapping(target="divisionName", source="division.name")})
    List<EmployeeFlattenDTO> convertEmployeeListToEmployeeDTOList(List<Employee> list);

}
