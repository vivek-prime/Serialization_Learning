package bytes.to.from.java;

import java.io.*;

public class SerializationLauncher {
    public static void serializeLink(Person inputPerson, String fileName) throws IOException, FileNotFoundException {

        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(inputPerson);
        out.close();
        file.close();
    }

    public static Person deserializeLink(String fileName) throws IOException, ClassNotFoundException {

        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream on = new ObjectInputStream(file);
        return (Person) on.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = Person.builder().name("Vivek").age(26).job("Engineer").build();
        String fileName = "person.bin";
        System.out.println(person);

        serializeLink(person,fileName);

        Person result = deserializeLink(fileName);
        System.out.println(person);
    }
}
