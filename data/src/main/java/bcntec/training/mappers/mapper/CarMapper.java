package bcntec.training.mappers.mapper;


import bcntec.training.mappers.dto.CarDTO;
import bcntec.training.mappers.entity.Car;
import org.springframework.core.convert.converter.Converter;

public interface CarMapper extends Converter<Car, CarDTO> {

}
