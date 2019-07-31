package bcntec.training.mappers.modelmapper.test;

import bcntec.training.mappers.dto.CarDTO;
import bcntec.training.mappers.mapper.CarMapper;
import bcntec.training.mappers.test.AbstractCarMapperUnitTest;
import org.modelmapper.ModelMapper;

public class CarModelMapperUnitTest extends AbstractCarMapperUnitTest {

    @Override
    public CarMapper getMapper() {
        return car -> new ModelMapper().map(car, CarDTO.class);
    }
}
