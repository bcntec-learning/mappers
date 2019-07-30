package bcntec.training.mappers.test;

import bcntec.training.mappers.dto.DivisionDTO;
import bcntec.training.mappers.dto.EmployeeDTO;
import bcntec.training.mappers.dto.EmployeeFlattenDTO;
import bcntec.training.mappers.entity.Division;
import bcntec.training.mappers.entity.Employee;
import bcntec.training.mappers.mapper.EmployeeFlattenMapper;
import bcntec.training.mappers.mapper.EmployeeMapper;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class AbstractEmployeeFlattenMapperUnitTest {

    private static final String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";

    public abstract EmployeeFlattenMapper getMapper();

    @Test
    public void givenEmployeeDTOwithDiffNametoEmployee_whenMaps_thenCorrect() {
        EmployeeFlattenDTO dto = new EmployeeFlattenDTO();
        dto.setEmployeeId(1);
        dto.setEmployeeName("John");

        Employee entity = getMapper().employeeDTOtoEmployee(dto);

        assertEquals(dto.getEmployeeId(), entity.getId());
        assertEquals(dto.getEmployeeName(), entity.getName());
    }

    @Test
    public void givenEmployeewithDiffNametoEmployeeDTO_whenMaps_thenCorrect() {
        Employee entity = new Employee();
        entity.setId(1);
        entity.setName("John");

        EmployeeFlattenDTO dto = getMapper().employeeToEmployeeDTO(entity);

        assertEquals(dto.getEmployeeId(), entity.getId());
        assertEquals(dto.getEmployeeName(), entity.getName());
    }

    @Test
    public void givenEmployeeDTOwithNestedMappingToEmployee_whenMaps_thenCorrect() {
        EmployeeFlattenDTO dto = new EmployeeFlattenDTO();
        dto.setDivisionId(1);
        dto.setDivisionName("Division1");

        Employee entity = getMapper().employeeDTOtoEmployee(dto);

        assertEquals(dto.getDivisionId(), entity.getDivision().getId());
        assertEquals(dto.getDivisionName(), entity.getDivision().getName());
    }

    @Test
    public void givenEmployeeWithNestedMappingToEmployeeDTO_whenMaps_thenCorrect() {
        Employee entity = new Employee();
        entity.setDivision(new Division(1, "Division1"));

        EmployeeFlattenDTO dto = getMapper().employeeToEmployeeDTO(entity);

        assertEquals(dto.getDivisionId(), entity.getDivision().getId());
        assertEquals(dto.getDivisionName(), entity.getDivision().getName());
    }

    @Test
    public void givenEmployeeListToEmployeeDTOList_whenMaps_thenCorrect() {
        List<Employee> employeeList = new ArrayList<>();
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("EmpName");
        emp.setDivision(new Division(1, "Division1"));
        employeeList.add(emp);

        List<EmployeeFlattenDTO> employeeDtoList = getMapper().convertEmployeeListToEmployeeDTOList(employeeList);
        EmployeeFlattenDTO employeeDTO = employeeDtoList.get(0);
        assertEquals(employeeDTO.getEmployeeId(), emp.getId());
        assertEquals(employeeDTO.getEmployeeName(), emp.getName());
        assertEquals(employeeDTO.getDivisionId(), emp.getDivision().getId());
        assertEquals(employeeDTO.getDivisionName(), emp.getDivision().getName());
    }

    @Test
    public void givenEmployeeDTOListToEmployeeList_whenMaps_thenCorrect() {
        List<EmployeeFlattenDTO> employeeDTOList = new ArrayList<>();
        EmployeeFlattenDTO empDTO = new EmployeeFlattenDTO();
        empDTO.setEmployeeId(1);
        empDTO.setEmployeeName("EmpName");
        empDTO.setDivisionId(1);
        empDTO.setDivisionName("Division1");
        employeeDTOList.add(empDTO);

        List<Employee> employeeList = getMapper().convertEmployeeDTOListToEmployeeList(employeeDTOList);
        Employee employee = employeeList.get(0);
        assertEquals(employee.getId(), empDTO.getEmployeeId());
        assertEquals(employee.getName(), empDTO.getEmployeeName());
        assertEquals(employee.getDivision().getId(), empDTO.getDivisionId());
        assertEquals(employee.getDivision().getName(), empDTO.getDivisionName());
    }

    @Test
    public void givenEmployeeWithStartDateMappingToEmployeeDTO_whenMaps_thenCorrect() throws ParseException {
        Employee entity = new Employee();
        entity.setStartDt(new Date());

        EmployeeFlattenDTO dto = getMapper().employeeToEmployeeDTO(entity);
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        assertEquals(format.parse(dto.getEmployeeStartDt()).toString(), entity.getStartDt().toString());
    }

    @Test
    public void givenEmployeeDTOWithStartDateMappingToEmployee_whenMaps_thenCorrect() throws ParseException {
        EmployeeFlattenDTO dto = new EmployeeFlattenDTO();
        dto.setEmployeeStartDt("01-04-2016 01:00:00");

        Employee entity = getMapper().employeeDTOtoEmployee(dto);
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        assertEquals(format.parse(dto.getEmployeeStartDt()).toString(), entity.getStartDt().toString());
    }
}
