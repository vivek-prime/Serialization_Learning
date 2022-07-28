package bytes.to.from.java;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
class Person implements Serializable {
    private String name;
    private Integer age;
    private String job;
}