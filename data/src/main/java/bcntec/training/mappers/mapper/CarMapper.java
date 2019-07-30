package bcntec.training.mappers.mapper;


import bcntec.training.mappers.dto.CarDTO;
import bcntec.training.mappers.entity.Car;

public interface CarMapper {

    CarDTO carToCarDTO(Car car);
}
