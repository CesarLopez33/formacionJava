package bosonit.ejercicio_72.profesor.tests;

import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_72.persona.repository.PersonaRepository;
import bosonit.ejercicio_72.profesor.Profesor;
import bosonit.ejercicio_72.profesor.dtos.input.ProfesorInputDTO;
import bosonit.ejercicio_72.profesor.dtos.output.ProfesorOutputDTO;
import bosonit.ejercicio_72.profesor.repository.ProfesorRepository;
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
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Objects;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ActualizarProfesorTest {
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
        Persona persona = new Persona(new PersonaInputDTO(
                "Juanes",
                "Manuel",
                "Perez",
                "aaa",
                "asdasdasd",
                "asdasdasd2",
                "Madrid",
                true,
                new Date(2001-12-27),
                "asdasdasd.com",
                new Date(2003-11-23)
        ));
        persona = personaRepository.save(persona);
        Profesor profesor = new Profesor(new ProfesorInputDTO(
                1,"Le falta un brazo","mates")
        );
        profesor.setPersona(persona);
        profesorRepository.save(profesor);
    }
    @Test
    void actualizarProfesorTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/profesor/" + 1;
        URI uri = new URI(baseUrl);
        ProfesorInputDTO profesor = new ProfesorInputDTO(1,"Nada","programacion");

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<ProfesorInputDTO> request = new HttpEntity<>(profesor, headers);

        ResponseEntity<ProfesorOutputDTO> result = this.testRestTemplate.exchange(
                uri, HttpMethod.PUT, request, ProfesorOutputDTO.class);

        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals("programacion", Objects.requireNonNull(result.getBody()).getBranch());
    }
}
