package bosonit.ejercicio_72.persona.tests;

import bosonit.ejercicio_72.asignaturas.Asignatura;
import bosonit.ejercicio_72.asignaturas.dtos.AsignaturaInputDTO;
import bosonit.ejercicio_72.asignaturas.repositories.AsignaturaRepository;
import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_72.persona.dtos.PersonaProfesorFullOutputDTO;
import bosonit.ejercicio_72.persona.dtos.PersonaStudentFullOutputDTO;
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
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ObtenerPersonaConTodoTests {
    @Autowired
    TestRestTemplate testRestTemplate;
    @LocalServerPort
    int randomServerPort;
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    ProfesorRepository profesorRepository;
    @Autowired
    AsignaturaRepository asignaturaRepository;
    @Autowired
    StudentRepository studentRepository;

    @BeforeAll
    void init(){
        //Creo dos personas(profesor-1/estudiante-2)
        Persona persona1 = new Persona(new PersonaInputDTO("Juanes", "Manuel", "Perez",
                "aaa", "asdasdasd", "asdasdasd2", "Madrid", true,
                new Date(2001-12-27), "asdasdasd.com", new Date(2003-11-23),true
        ));
        Persona persona2 = new Persona(new PersonaInputDTO("Juanes", "Manuel", "Juan",
                "aaa", "asdasdasd", "asdasdasd2", "Madrid", true,
                new Date(2001-12-27), "asdasdasd.com", new Date(2003-11-23),false
        ));
        persona1 = personaRepository.save(persona1);
        persona2 = personaRepository.save(persona2);

        //Profesor
        Profesor profesor = new Profesor(new ProfesorInputDTO(1,"Le falta un brazo","mates"));
        profesor.setPersona(persona1);
        profesor = profesorRepository.save(profesor);

        //Asignatura
        Asignatura asignatura = new Asignatura(new AsignaturaInputDTO("1", "computadores",
                "requiere libro de texto", new Date(2003-11-23), new Date(2006-11-23)));
        asignatura.setProfesor(profesor);
        asignatura = asignaturaRepository.save(asignatura);
        List<Asignatura> asignaturaList = new ArrayList<>();
        asignaturaList.add(asignatura);

        //Student con asignatura anterior
        Student student = new Student(new StudentInputDTO(2, 20, "No trabaja mañanas",
                "1", "Front"));
        student.setPersona(persona2);
        student.setProfesor(profesor);
        student.setAsignaturas(asignaturaList);
        studentRepository.save(student);
    }

    @Test
    void obtenerPersonaConTodoIdTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/persona/"+1+"?outputType=full";
        URI uri = new URI(baseUrl);

        ResponseEntity<PersonaProfesorFullOutputDTO> result =
                this.testRestTemplate.getForEntity(uri, PersonaProfesorFullOutputDTO.class);

        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals("Madrid",result.getBody().getCity()); //Datos persona
        Assertions.assertEquals("mates", result.getBody().getBranch()); //Datos profesor
        //Datos estudiante
        Assertions.assertEquals("No trabaja mañanas", result.getBody().getStudents().get(0).getComments());
        //Datos asignatura
        Assertions.assertEquals("requiere libro de texto",
                result.getBody().getAsignaturas().get(0).getComments());
    }
    @Test
    void obtenerPersonaConTodoIdTest2() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/persona/"+2+"?outputType=full";
        URI uri = new URI(baseUrl);

        ResponseEntity<PersonaStudentFullOutputDTO> result =
                this.testRestTemplate.getForEntity(uri, PersonaStudentFullOutputDTO.class);

        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals("Juan", result.getBody().getName()); //Datos persona
        Assertions.assertEquals("No trabaja mañanas", result.getBody().getComents()); //Datos estudiante
        Assertions.assertEquals("mates",result.getBody().getProfesor().getBranch()); //Datos profesor
        //Datos asignatura
        Assertions.assertEquals("computadores", result.getBody().getAsignaturas().get(0).getAsignatura());
    }

    @Test
    void obtenerPersonaConTodoNombreTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/persona/nombre/Perez?outputType=full";
        URI uri = new URI(baseUrl);

        ResponseEntity<PersonaProfesorFullOutputDTO[]> result =
                this.testRestTemplate.getForEntity(uri, PersonaProfesorFullOutputDTO[].class);

        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals("Madrid",result.getBody()[0].getCity()); //Datos persona
        Assertions.assertEquals("mates", result.getBody()[0].getBranch()); //Datos profesor
        //Datos estudiante
        Assertions.assertEquals("No trabaja mañanas", result.getBody()[0].getStudents().get(0).getComments());
        //Datos asignatura
        Assertions.assertEquals("requiere libro de texto",
                result.getBody()[0].getAsignaturas().get(0).getComments());
    }
    @Test
    void obtenerPersonaConTodoNombreTest2() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/persona/nombre/Juan?outputType=full";
        URI uri = new URI(baseUrl);

        ResponseEntity<PersonaStudentFullOutputDTO[]> result =
                this.testRestTemplate.getForEntity(uri, PersonaStudentFullOutputDTO[].class);

        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals("Juan", result.getBody()[0].getName()); //Datos persona
        Assertions.assertEquals("No trabaja mañanas", result.getBody()[0].getComents()); //Datos estudiante
        Assertions.assertEquals("mates",result.getBody()[0].getProfesor().getBranch()); //Datos profesor
        //Datos asignatura
        Assertions.assertEquals("computadores", result.getBody()[0].getAsignaturas().get(0).getAsignatura());
    }
}
