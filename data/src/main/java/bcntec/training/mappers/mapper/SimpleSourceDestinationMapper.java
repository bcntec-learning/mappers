package bcntec.training.mappers.mapper;

import bcntec.training.mappers.dto.SimpleSource;
import bcntec.training.mappers.entity.SimpleDestination;

//@Mapper(componentModel = "spring")
public interface SimpleSourceDestinationMapper {

    SimpleDestination sourceToDestination(SimpleSource source);

    SimpleSource destinationToSource(SimpleDestination destination);

}
