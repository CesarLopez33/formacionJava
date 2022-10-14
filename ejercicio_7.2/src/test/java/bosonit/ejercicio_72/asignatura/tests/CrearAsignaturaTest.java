package bosonit.ejercicio_72.asignatura.tests;

import bosonit.ejercicio_72.asignaturas.dtos.AsignaturaInputDTO;
import bosonit.ejercicio_72.asignaturas.dtos.AsignaturaOutputDTO;
import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_72.persona.repository.PersonaRepository;
import bosonit.ejercicio_72.profesor.Profesor;
import bosonit.ejercicio_72.profesor.dtos.input.ProfesorInputDTO;
import bosonit.ejercicio_72.profesor.repository.ProfesorRepository;
import bosonit.ejercicio_72.student.dtos.input.StudentInputDTO;
import bosonit.ejercicio_72.student.dtos.output.StudentOutputDTO;
import bosonit.ejercicio_72.student.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Objects;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CrearAsignaturaTest {
    @Autowired
    TestRestTemplate testRestTemplate;
    @LocalServerPort
    int randomServerPort;
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    ProfesorRepository profesorRepository;

    @BeforeAll
    void init(){
        Persona persona = new Persona(new PersonaInputDTO("Juanes", "Manuel", "Perez",
                "aaa", "asdasdasd", "asdasdasd2", "Madrid", true,
                new Date(2001-12-27), "asdasdasd.com", new Date(2003-11-23)
        ));
        persona = personaRepository.save(persona);
        Persona persona2 = new Persona(new PersonaInputDTO("Juanes", "Manuel", "Perez",
                "aaa", "asdasdasd", "asdasdasd2", "Madrid", true,
                new Date(2001-12-27), "asdasdasd.com", new Date(2003-11-23)
        ));
        personaRepository.save(persona2);

        Profesor profesor = new Profesor(new ProfesorInputDTO(
                1,"Le falta un brazo","mates")
        );
        profesor.setPersona(persona);
        profesorRepository.save(profesor);
    }

    @Test
    void crearAsignatura() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/asignatura/";
        URI uri = new URI(baseUrl);
        AsignaturaInputDTO asignatura = new AsignaturaInputDTO("1",
                "mates",
                "requiere libro de texto",
                new Date(2003-11-23),
                new Date(2006-11-23));

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<AsignaturaInputDTO> request = new HttpEntity<>(asignatura,headers);

        ResponseEntity<AsignaturaOutputDTO> result = this.testRestTemplate
                .postForEntity(uri, request, AsignaturaOutputDTO.class);

        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals("mates", Objects.requireNonNull(result.getBody()).getAsignatura());
    }
}
