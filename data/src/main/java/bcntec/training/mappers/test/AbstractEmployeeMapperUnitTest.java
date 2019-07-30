package bcntec.training.mappers.test;

import bcntec.training.mappers.dto.DivisionDTO;
import bcntec.training.mappers.dto.EmployeeDTO;
import bcntec.training.mappers.entity.Division;
import bcntec.training.mappers.entity.Employee;
import bcntec.training.mappers.mapper.EmployeeMapper;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class AbstractEmployeeMapperUnitTest {

    private static final String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";
    public abstract EmployeeMapper getMapper();

    @Test
    public void givenEmployeeDTOwithDiffNametoEmployee_whenMaps_thenCorrect() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(1);
        dto.setName("John");

        Employee entity = getMapper().employeeDTOtoEmployee(dto);

        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getName(), entity.getName());
    }

    @Test
    public void givenEmployeewithDiffNametoEmployeeDTO_whenMaps_thenCorrect() {
        Employee entity = new Employee();
        entity.setId(1);
        entity.setName("John");

        EmployeeDTO dto = getMapper().employeeToEmployeeDTO(entity);

        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getName(), entity.getName());
    }

    @Test
    public void givenEmployeeDTOwithNestedMappingToEmployee_whenMaps_thenCorrect() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setDivision(new DivisionDTO(1,"Division1"));

        Employee entity = getMapper().employeeDTOtoEmployee(dto);

        assertEquals(dto.getDivision().getId(), entity.getDivision().getId());
        assertEquals(dto.getDivision().getName(), entity.getDivision().getName());
    }

    @Test
    public void givenEmployeeWithNestedMappingToEmployeeDTO_whenMaps_thenCorrect() {
        Employee entity = new Employee();
        entity.setDivision(new Division(1, "Division1"));

        EmployeeDTO dto = getMapper().employeeToEmployeeDTO(entity);

        assertEquals(dto.getDivision().getId(), entity.getDivision().getId());
        assertEquals(dto.getDivision().getName(), entity.getDivision().getName());
    }

    @Test
    public void givenEmployeeListToEmployeeDTOList_whenMaps_thenCorrect() {
        List<Employee> employeeList = new ArrayList<>();
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("EmpName");
        emp.setDivision(new Division(1, "Division1"));
        employeeList.add(emp);

        List<EmployeeDTO> employeeDtoList = getMapper().convertEmployeeListToEmployeeDTOList(employeeList);
        EmployeeDTO employeeDTO = employeeDtoList.get(0);
        assertEquals(employeeDTO.getId(), emp.getId());
        assertEquals(employeeDTO.getName(), emp.getName());
        assertEquals(employeeDTO.getDivision().getId(), emp.getDivision().getId());
        assertEquals(employeeDTO.getDivision().getName(), emp.getDivision().getName());
    }

    @Test
    public void givenEmployeeDTOListToEmployeeList_whenMaps_thenCorrect() {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        EmployeeDTO empDTO = new EmployeeDTO();
        empDTO.setId(1);
        empDTO.setName("EmpName");
        empDTO.setDivision(new DivisionDTO(1, "Division1"));
        employeeDTOList.add(empDTO);

        List<Employee> employeeList = getMapper().convertEmployeeDTOListToEmployeeList(employeeDTOList);
        Employee employee = employeeList.get(0);
        assertEquals(employee.getId(), empDTO.getId());
        assertEquals(employee.getName(), empDTO.getName());
        assertEquals(employee.getDivision().getId(), empDTO.getDivision().getId());
        assertEquals(employee.getDivision().getName(), empDTO.getDivision().getName());
    }

    @Test
    public void givenEmployeeWithStartDateMappingToEmployeeDTO_whenMaps_thenCorrect() throws ParseException {
        Employee entity = new Employee();
        entity.setStartDt(new Date());

        EmployeeDTO dto = getMapper().employeeToEmployeeDTO(entity);
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        assertEquals(format.parse(dto.getStartDt()).toString(), entity.getStartDt().toString());
    }

    @Test
    public void givenEmployeeDTOWithStartDateMappingToEmployee_whenMaps_thenCorrect() throws ParseException {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setStartDt("01-04-2016 01:00:00");

        Employee entity = getMapper().employeeDTOtoEmployee(dto);
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        assertEquals(format.parse(dto.getStartDt()).toString(), entity.getStartDt().toString());
    }
}
