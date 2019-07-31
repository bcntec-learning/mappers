package bcntec.training.mappers.test;

import bcntec.training.mappers.dto.CarDTO;
import bcntec.training.mappers.entity.Car;
import bcntec.training.mappers.mapper.CarMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class AbstractCarMapperUnitTest {

    public abstract CarMapper getMapper();

    @Test
    public void givenCarEntitytoCar_whenMaps_thenCorrect() {

        Car entity = new Car();
        entity.setId(1);
        entity.setName("Toyota");

        CarDTO carDto = getMapper().convert(entity);

        assertEquals(carDto.getId(), entity.getId());
        assertEquals(carDto.getName(), entity.getName());
    }
}
