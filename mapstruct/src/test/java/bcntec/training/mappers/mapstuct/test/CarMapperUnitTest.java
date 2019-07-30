package bcntec.training.mappers.mapstuct.test;

import bcntec.training.mappers.mapper.CarMapper;
import bcntec.training.mappers.mapstuct.CarMapstruct;
import bcntec.training.mappers.test.AbstractCarMapperUnitTest;

public class CarMapperUnitTest extends AbstractCarMapperUnitTest {

    @Override
    public CarMapper getMapper() {
        return CarMapstruct.INSTANCE;
    }

}
