package bcntec.training.mappers.mapstuct;


import bcntec.training.mappers.dto.PersonDTO;
import bcntec.training.mappers.entity.Person;
import bcntec.training.mappers.mapper.PersonMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapstruct extends PersonMapper {

    PersonMapstruct INSTANCE = Mappers.getMapper(PersonMapstruct.class);

    @Override
    @Mapping(target = "id", source = "person.id", defaultExpression = "java(java.util.UUID.randomUUID().toString())")
    PersonDTO personToPersonDTO(Person person);

}
