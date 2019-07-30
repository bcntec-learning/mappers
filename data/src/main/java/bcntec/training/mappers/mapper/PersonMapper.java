package bcntec.training.mappers.mapper;


import bcntec.training.mappers.dto.PersonDTO;
import bcntec.training.mappers.entity.Person;

@FunctionalInterface
public interface PersonMapper {
    
    PersonDTO personToPersonDTO(Person person);
}
