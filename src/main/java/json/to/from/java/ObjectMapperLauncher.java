package json.to.from.java;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ObjectMapperLauncher {
    static ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) throws IOException {
        Car tataNexon = new Car("black", "tata_nexon");
        String carAsString = objectMapper.writeValueAsString(tataNexon);
        System.out.println("carAsString - "+ carAsString);

        String json = "{ \"color\" : \"Black\", \"model\" : \"BMW\" }";
        Car bmw = objectMapper.readValue(json, Car.class);
        System.out.println(bmw);

        objectMapper.writeValue(new File("car.json"),carAsString);
    }
}
