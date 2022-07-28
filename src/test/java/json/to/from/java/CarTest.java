package json.to.from.java;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CarTest {
    private ObjectMapper objectMapper;
    @BeforeAll
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void checkObjectMapper() throws IOException {
        Car car = objectMapper.readValue(new File("src/main/resources/tata_nexon.json"), Car.class);
        assertEquals(car.getColor(), "black");
    }

    @Test
    public void checkTypeReference_With_Json_List_Data() throws IOException {
        TypeReference<List<Car>> typeReference = new TypeReference<List<Car>>() {};
        List<Car> carList = objectMapper.readValue(new File("src/main/resources/car_list.json"), typeReference);
        System.out.println(carList);
        assertEquals(carList.size(), 2);
    }
}