package bosonit.ejercicio_72.student.tests;

import bosonit.ejercicio_72.asignaturas.Asignatura;
import bosonit.ejercicio_72.asignaturas.dtos.AsignaturaInputDTO;
import bosonit.ejercicio_72.asignaturas.dtos.AsignaturaOutputDTO;
import bosonit.ejercicio_72.asignaturas.repositories.AsignaturaRepository;
import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_72.persona.repository.PersonaRepository;
import bosonit.ejercicio_72.profesor.Profesor;
import bosonit.ejercicio_72.profesor.dtos.input.ProfesorInputDTO;
import bosonit.ejercicio_72.profesor.repository.ProfesorRepository;
import bosonit.ejercicio_72.student.Student;
import bosonit.ejercicio_72.student.dtos.input.IdsAsignaturasInputDTO;
import bosonit.ejercicio_72.student.dtos.input.StudentInputDTO;
import bosonit.ejercicio_72.student.repository.StudentRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GestionAsignaturasStudentTest {
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
                new Date(2001-12-27), "asdasdasd.com", new Date(2003-11-23)
        ));
        Persona persona2 = new Persona(new PersonaInputDTO("Juanes", "Manuel", "Juan",
                "aaa", "asdasdasd", "asdasdasd2", "Madrid", true,
                new Date(2001-12-27), "asdasdasd.com", new Date(2003-11-23)
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

        //Student
        Student student = new Student(new StudentInputDTO(2, 20, "No trabaja mañanas",
                "1", "Front"));
        student.setPersona(persona2);
        student.setProfesor(profesor);
        student.setAsignaturas(asignaturaList);
        studentRepository.save(student);
    }

    @Test
    @Order(3)
    void obtenerAsignaturasStudent() throws URISyntaxException {
        final String url = "http://localhost:"+randomServerPort+"/asignatura/student/1";
        URI uri = new URI(url);

        ResponseEntity<AsignaturaOutputDTO[]> result =
                this.testRestTemplate.getForEntity(uri, AsignaturaOutputDTO[].class);
        Assertions.assertEquals(200,result.getStatusCodeValue());
        Assertions.assertEquals("computadores",result.getBody()[0].getAsignatura());

    }

    @Test
    @Order(2)
    void addAsignaturas() throws URISyntaxException {
        final String url = "http://localhost:"+randomServerPort+"/student/add/1";
        URI uri = new URI(url);

        IdsAsignaturasInputDTO ids = new IdsAsignaturasInputDTO();
        List<String> id = new ArrayList<>();
        id.add("1");
        ids.setIds(id);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<IdsAsignaturasInputDTO> request = new HttpEntity<>(ids, headers);

        ResponseEntity<Void> result = this.testRestTemplate.exchange(uri, HttpMethod.POST,request,void.class);
        Assertions.assertEquals(200,result.getStatusCodeValue());
    }

    @Test
    @Order(1)
    void deleteAsignaturas() throws URISyntaxException {
        final String url = "http://localhost:"+randomServerPort+"/student/remove/1";
        URI uri = new URI(url);

        IdsAsignaturasInputDTO ids = new IdsAsignaturasInputDTO();
        List<String> id = new ArrayList<>();
        id.add("1");
        ids.setIds(id);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<IdsAsignaturasInputDTO> request = new HttpEntity<>(ids, headers);

        ResponseEntity<Void> result = this.testRestTemplate.exchange(uri, HttpMethod.DELETE, request,void.class);

        Assertions.assertEquals(200,result.getStatusCodeValue());
    }
}
