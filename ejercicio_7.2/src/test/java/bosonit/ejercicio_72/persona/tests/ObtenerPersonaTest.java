package bosonit.ejercicio_72.persona.tests;

import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_72.persona.dtos.PersonaOutputDTO;
import bosonit.ejercicio_72.persona.repository.PersonaRepository;
import org.junit.jupiter.api.*;
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
class ObtenerPersonaTest {
    @Autowired
    TestRestTemplate testRestTemplate;
    @LocalServerPort
    int randomServerPort;
    @Autowired
    PersonaRepository personaRepository;

    @BeforeAll
    void init() throws URISyntaxException {
        PersonaInputDTO persona = new PersonaInputDTO("Juanes",
                "Manuel",
                "Perez",
                "aaa",
                "asdasdasd",
                "asdasdasd2",
                "Madrid",
                true,
                new Date(2001-12-27),
                "asdasdasd.com",
                new Date(2003-11-23));
        personaRepository.save(new Persona(persona));
    }

    @Test
    void obtenerPersonaIdTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/persona/"+1;
        URI uri = new URI(baseUrl);

        ResponseEntity<PersonaOutputDTO> result = this.testRestTemplate.getForEntity(uri, PersonaOutputDTO.class);

        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals("Perez", result.getBody().getName());
    }

    @Test
    void obtenerPersonaIdInexistenteTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/persona/"+8;
        URI uri = new URI(baseUrl);

        ResponseEntity<PersonaOutputDTO> result = this.testRestTemplate.getForEntity(uri, PersonaOutputDTO.class);

        //Verify request succeed
        Assertions.assertEquals(404, result.getStatusCodeValue());
    }

    @Test
    void obtenerPersonaNombreTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/persona/nombre/Perez";
        URI uri = new URI(baseUrl);

        ResponseEntity<PersonaOutputDTO[]> result = this.testRestTemplate.getForEntity(uri, PersonaOutputDTO[].class);

        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals("Madrid", Objects.requireNonNull(result.getBody())[0].getCity());
    }

    @Test
    void obtenerPersonaNombreInexistenteTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/persona/nombre/JuanJose";
        URI uri = new URI(baseUrl);

        ResponseEntity<PersonaOutputDTO> result = this.testRestTemplate.getForEntity(uri, PersonaOutputDTO.class);

        //Verify request succeed
        Assertions.assertEquals(404, result.getStatusCodeValue());
    }

    @Test
    void obtenerPersonaTodasTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/persona/all";
        URI uri = new URI(baseUrl);

        ResponseEntity<PersonaOutputDTO[]> result = this.testRestTemplate.getForEntity(uri, PersonaOutputDTO[].class);

        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals("aaa",result.getBody()[0].getSurname());
    }

    @Test
    void obtenerPersonaIdBadRequest() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/persona/"+8+"?outputType=salsa";
        URI uri = new URI(baseUrl);
        ResponseEntity<Void> result = this.testRestTemplate.getForEntity(uri, Void.class);
        Assertions.assertEquals(400, result.getStatusCodeValue());
    }
    @Test
    void obtenerPersonaNombreBadRequest() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/persona/nombre/a?outputType=salsa";
        URI uri = new URI(baseUrl);
        ResponseEntity<Void> result = this.testRestTemplate.getForEntity(uri, Void.class);
        Assertions.assertEquals(400, result.getStatusCodeValue());
    }
    @Test
    void obtenerPersonaTodasBadRequest() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/persona/all?outputType=salsa";
        URI uri = new URI(baseUrl);
        ResponseEntity<Void> result = this.testRestTemplate.getForEntity(uri, Void.class);
        Assertions.assertEquals(400, result.getStatusCodeValue());
    }

}
