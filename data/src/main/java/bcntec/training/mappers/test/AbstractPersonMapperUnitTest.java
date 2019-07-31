package bcntec.training.mappers.test;

import bcntec.training.mappers.dto.PersonDTO;
import bcntec.training.mappers.entity.Person;
import bcntec.training.mappers.mapper.PersonMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractPersonMapperUnitTest {

    public abstract PersonMapper getMapper();

    @Test
    public void givenPersonEntitytoPersonWithExpression_whenMaps_thenCorrect() {

        Person entity = new Person();
        entity.setName("Micheal");

        PersonDTO personDto = getMapper().personToPersonDTO(entity);

        assertNull(entity.getId());
        assertNotNull(personDto.getId());
        assertEquals(personDto.getName(), entity.getName());
    }
}