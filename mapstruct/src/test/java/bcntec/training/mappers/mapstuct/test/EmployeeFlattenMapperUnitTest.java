package bcntec.training.mappers.mapstuct.test;

import bcntec.training.mappers.mapper.EmployeeFlattenMapper;
import bcntec.training.mappers.mapstuct.EmployeeFlattenMapstruct;
import bcntec.training.mappers.test.AbstractEmployeeFlattenMapperUnitTest;
import bcntec.training.mappers.test.AbstractEmployeeMapperUnitTest;
import lombok.Getter;

public class EmployeeFlattenMapperUnitTest extends AbstractEmployeeFlattenMapperUnitTest {

    @Getter
    EmployeeFlattenMapper mapper = EmployeeFlattenMapstruct.INSTANCE;

}
