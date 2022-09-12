package ejercicios;
import java.util.Optional;


public class Person {
    private String name;
    private String town;
    private Optional<Integer> age = null;

    public Person(String name, String town, Optional<Integer> age) {
        this.name = name;
        this.town = town;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Optional<Integer> getAge() {
        return age;
    }

    public void setAge(Optional<Integer> age) {
        this.age = age;
    }
}
