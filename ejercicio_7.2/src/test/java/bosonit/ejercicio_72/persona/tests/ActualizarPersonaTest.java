package bosonit.ejercicio_72.persona.tests;

import bosonit.ejercicio_72.exceptions.CustomError;
import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_72.persona.dtos.PersonaOutputDTO;
import bosonit.ejercicio_72.persona.repository.PersonaRepository;
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
import java.util.Date;
import java.util.Objects;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ActualizarPersonaTest {
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
    void actualizarPersonaTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/persona/"+1;
        URI uri = new URI(baseUrl);
        PersonaInputDTO persona = new PersonaInputDTO("Miguel33",
                "miguelito02",
                "miguel",
                "lopez",
                "miguel@bosonit.com",
                "miguelito02@gmail.com",
                "Burgos",
                false,
                new Date(2002-12-27),
                "rrrwerrrwrrwrwr.com",
                new Date(2005-11-23));

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<PersonaInputDTO> request = new HttpEntity<>(persona,headers);

        ResponseEntity<PersonaOutputDTO> result = this.testRestTemplate.exchange(
                uri, HttpMethod.PUT, request, PersonaOutputDTO.class);

        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals("miguel", Objects.requireNonNull(result.getBody()).getName());
    }

    @Test
    void atualizarPersonaBadInputTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/persona/1";
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        PersonaInputDTO persona = new PersonaInputDTO();

        HttpEntity<PersonaInputDTO> request = new HttpEntity<>(persona,headers);
        ResponseEntity<CustomError> result =
                this.testRestTemplate.exchange(uri,HttpMethod.PUT, request, CustomError.class);
        Assertions.assertEquals(200, result.getStatusCodeValue());

        persona.setUsuario("aaaaaaaaaaa");

        request = new HttpEntity<>(persona,headers);
        result = this.testRestTemplate.exchange(uri,HttpMethod.PUT, request, CustomError.class);
        Assertions.assertEquals(422, result.getStatusCodeValue());

        persona.setUsuario("aaa");

        request = new HttpEntity<>(persona,headers);
        result = this.testRestTemplate.exchange(uri,HttpMethod.PUT, request, CustomError.class);
        Assertions.assertEquals(422, result.getStatusCodeValue());
    }
}
