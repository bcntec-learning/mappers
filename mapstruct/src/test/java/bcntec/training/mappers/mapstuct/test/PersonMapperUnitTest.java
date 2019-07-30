package bcntec.training.mappers.mapstuct.test;

import bcntec.training.mappers.mapper.PersonMapper;
import bcntec.training.mappers.mapstuct.PersonMapstruct;
import bcntec.training.mappers.test.AbstractPersonMapperUnitTest;

public class PersonMapperUnitTest extends AbstractPersonMapperUnitTest {

    @Override
    public PersonMapper getMapper() {
        return PersonMapstruct.INSTANCE;
    }
}