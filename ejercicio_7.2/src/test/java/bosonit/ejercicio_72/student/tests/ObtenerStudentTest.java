package bosonit.ejercicio_72.student.tests;

import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_72.persona.repository.PersonaRepository;
import bosonit.ejercicio_72.profesor.Profesor;
import bosonit.ejercicio_72.profesor.dtos.input.ProfesorInputDTO;
import bosonit.ejercicio_72.profesor.repository.ProfesorRepository;
import bosonit.ejercicio_72.student.Student;
import bosonit.ejercicio_72.student.dtos.input.StudentInputDTO;
import bosonit.ejercicio_72.student.dtos.output.StudentOutputDTO;
import bosonit.ejercicio_72.student.dtos.output.StudentPersonaOutputDTO;
import bosonit.ejercicio_72.student.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Objects;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ObtenerStudentTest {
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
    void obtenerStudentTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/student/"+1;
        URI uri = new URI(baseUrl);

        ResponseEntity<StudentOutputDTO> result = this.testRestTemplate.getForEntity(uri, StudentOutputDTO.class);

        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals("Front", Objects.requireNonNull(result.getBody()).getBranch());
    }

    @Test
    void obtenerStudentConTodoTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/student/"+1+"?outputType=full";
        URI uri = new URI(baseUrl);

        ResponseEntity<StudentPersonaOutputDTO> result = this.testRestTemplate
                .getForEntity(uri,StudentPersonaOutputDTO.class);

        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals("Front", Objects.requireNonNull(result.getBody()).getBranch());
        Assertions.assertEquals("asdasdasd", result.getBody().getCompany_email());
    }
    @Test
    void obtenerStudentBadRequestTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/student/"+1+"?outputType=savage";
        URI uri = new URI(baseUrl);

        ResponseEntity<String> result = this.testRestTemplate.getForEntity(uri,String.class);
        Assertions.assertEquals(400, result.getStatusCodeValue());
    }
}
