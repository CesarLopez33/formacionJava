package ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Metodos {
    public List<Person> leerFichero() throws IOException, InvalidLineFormatException {
        String nombreFichero = "ejercicio_1.1/people.csv";
        FileReader fr = new FileReader(nombreFichero);
        BufferedReader br = new BufferedReader(fr);

        List<Person> people = new ArrayList<>();
        String line = br.readLine();
        while(line!=null){
            long numDelimitadores = line.chars().filter(c->c==':').count();
            if(numDelimitadores==0)
                throw new InvalidLineFormatException("Faltan dos delimitadores de campo");
            if(numDelimitadores==1)
                throw new InvalidLineFormatException("Falta un delimitador de campo");

            String[] personData = line.split(":");
            if(personData[0].isBlank())
                throw new InvalidLineFormatException("El nombre es obligatorio");
            Person p = new Person();
            p.setName(personData[0]);
            p.setTown(personData[1]);
            p.setAge(Optional.ofNullable(personData.length > 2 ?
                    Integer.parseInt(personData[2]) : null));

            people.add(p);
            line = br.readLine();
        }
            return people;
    }
    public void printListOfPeople(List<Person> people){
        people.forEach(p -> System.out.println("Nombre: " + p.getName() +
                "   Ciudad: " + (p.getTown().equals("") ? "unknown" : p.getTown() ) +
                "   Edad: " + (p.getAge().isPresent() ? p.getAge().get() : "Desconocida")
        ));
    }
    public void printPerson(Person person){
        System.out.println("Nombre: " + person.getName() +
                "   Ciudad: " + (person.getTown().equals("") ? "unknown" : person.getTown() ) +
                "   Edad: " + (person.getAge().isPresent() ? person.getAge().get() : "Desconocida"));
    }

    public void printPeople(List<Person> people){
        people.forEach(p -> System.out.println("Nombre: " + p.getName() +
                "   Ciudad: " + (p.getTown().equals("") ? "unknown" : p.getTown() ) +
                "   Edad: " + (p.getAge().isPresent() ? p.getAge().get() : "Desconocida")
        ));

        Stream<Person> flujo = people.stream();
        List<Person> under25 = flujo.filter(p -> (p.getAge().isPresent() ? p.getAge().get()<25 : false))
                .collect(Collectors.toList());
        System.out.println("\nUnder 25:");
        under25.forEach(p -> System.out.println("Nombre: " + p.getName() +
                "   Ciudad: " + p.getTown() +
                "   Edad: " + (p.getAge().isPresent() ? p.getAge().get() : "Desconocida")));

        Stream<Person> flujo2 = people.stream();
        List<Person> listaSinA = flujo2.filter(p -> !p.getName().startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("\nPersonas que no empiezan por A:");
        printListOfPeople(listaSinA);

        System.out.println("\nPrimera persona de Madrid:");
        Stream<Person> flujo3 = under25.stream();
        Optional<Person> residenteMadrid = flujo3.filter(p -> p.getTown().equals("Madrid"))
                .findFirst();
        if(residenteMadrid.isPresent()){
            printPerson(residenteMadrid.get());
        }else{
            System.out.println("No hay ninguna persona de Madrid");
        }

        System.out.println("\nPrimera persona de Barcelona:");
        Stream<Person> flujo4 = under25.stream();
        Optional<Person> residenteBarcelona = flujo4.filter(p -> p.getTown().equals("Barcelona"))
                .findFirst();
        if(residenteBarcelona.isPresent()){
            printPerson(residenteBarcelona.get());
        }else{
            System.out.println("No hay ninguna persona de Barcelona");
        }
    }
}
