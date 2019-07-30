package bcntec.training.mappers.modelmapper.test;


import bcntec.training.mappers.dto.PersonDTO;
import bcntec.training.mappers.entity.Person;
import bcntec.training.mappers.mapper.PersonMapper;
import bcntec.training.mappers.test.AbstractPersonMapperUnitTest;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.util.UUID;

public class PersonMapperUnitTest extends AbstractPersonMapperUnitTest {

    private static ModelMapper modelMapper = new ModelMapper();
    private static TypeMap<Person, PersonDTO> typeMap =
            modelMapper.createTypeMap(Person.class, PersonDTO.class);

    {
        typeMap.addMappings(mapper -> {
            mapper.map(src -> UUID.randomUUID().toString(),
                    PersonDTO::setId);
            mapper.map(Person::getName, PersonDTO::setName);
        });

    }

    @Override
    public PersonMapper getMapper() {
        return (o) -> modelMapper.map(o, PersonDTO.class);
    }

}