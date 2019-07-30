package bcntec.training.mappers.mapstuct;


import bcntec.training.mappers.mapper.CarMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapstruct extends CarMapper {

    CarMapstruct INSTANCE = Mappers.getMapper(CarMapstruct.class);

}
