package bcntec.training.mappers.mapstuct.test;

import bcntec.training.mappers.mapper.EmployeeFlattenMapper;
import bcntec.training.mappers.mapstuct.EmployeeFlattenMapstruct;
import bcntec.training.mappers.test.AbstractEmployeeFlattenMapperUnitTest;
import lombok.Getter;

public class EmployeeFlattenMapstuctUnitTest extends AbstractEmployeeFlattenMapperUnitTest {

    @Getter
    EmployeeFlattenMapper mapper = EmployeeFlattenMapstruct.INSTANCE;

}
