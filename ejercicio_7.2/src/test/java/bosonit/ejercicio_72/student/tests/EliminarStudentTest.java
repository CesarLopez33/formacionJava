package bosonit.ejercicio_72.student.tests;

import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_72.persona.repository.PersonaRepository;
import bosonit.ejercicio_72.profesor.Profesor;
import bosonit.ejercicio_72.profesor.dtos.input.ProfesorInputDTO;
import bosonit.ejercicio_72.profesor.repository.ProfesorRepository;
import bosonit.ejercicio_72.student.Student;
import bosonit.ejercicio_72.student.dtos.input.StudentInputDTO;
import bosonit.ejercicio_72.student.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;


@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EliminarStudentTest {
    @Autowired
    TestRestTemplate testRestTemplate;
    @LocalServerPort
    int randomServerPort;
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    StudentRepository studentRepository;

    @BeforeAll
    void init(){
        Persona persona = new Persona(new PersonaInputDTO("Juanes", "Manuel", "Perez",
                "aaa", "asdasdasd", "asdasdasd2", "Madrid", true,
                new Date(2001-12-27), "asdasdasd.com", new Date(2003-11-23)
        ));
        persona = personaRepository.save(persona);

        Profesor profesor = new Profesor(new ProfesorInputDTO(
                1,"Le falta un brazo","mates")
        );
        profesor.setPersona(persona);
        profesor = profesorRepository.save(profesor);

        Student student = new Student(new StudentInputDTO(2, 20, "No trabaja mañanas",
                "1", "Front"));
        student.setPersona(persona);
        student.setProfesor(profesor);
        studentRepository.save(student);
    }
    @Test
    void eliminarStudentTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/student/"+1;
        URI uri = new URI(baseUrl);
        this.testRestTemplate.delete(uri);

        Assertions.assertFalse(studentRepository.findById("1").isPresent());
    }
}
