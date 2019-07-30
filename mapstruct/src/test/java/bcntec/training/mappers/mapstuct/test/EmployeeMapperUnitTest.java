package bcntec.training.mappers.mapstuct.test;

import bcntec.training.mappers.mapper.EmployeeMapper;
import bcntec.training.mappers.mapstuct.EmployeeMapstruct;
import bcntec.training.mappers.test.AbstractEmployeeMapperUnitTest;
import lombok.Getter;

public class EmployeeMapperUnitTest extends AbstractEmployeeMapperUnitTest {

    @Getter
    EmployeeMapper mapper = EmployeeMapstruct.INSTANCE;

}
