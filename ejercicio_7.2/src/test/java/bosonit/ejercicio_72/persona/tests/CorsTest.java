package bosonit.ejercicio_72.persona.tests;

import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.persona.dtos.PersonaCorsOutputDTO;
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
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CorsTest {
    @Autowired
    TestRestTemplate testRestTemplate;
    @LocalServerPort
    int randomServerPort;
    @Autowired
    PersonaRepository personaRepository;

    @BeforeAll
    void init() throws URISyntaxException, ParseException {
        PersonaInputDTO persona = new PersonaInputDTO("Juanes",
                "33435",
                "Alfonso",
                "Perez",
                "juan@bosonit.com",
                "asdasdasd2",
                "Madrid",
                true,
                new SimpleDateFormat("yyyy-MM-dd").parse("2001-12-27"),
                "asdasdasd.com",
                new SimpleDateFormat("yyyy-MM-dd").parse("2001-12-26"));
        personaRepository.save(new Persona(persona));
        persona = new PersonaInputDTO("Juanes",
                "122221",
                "Manuel",
                "Perez",
                "juan@bosonit.com",
                "asdasdasd2",
                "Madrid",
                true,
                new SimpleDateFormat("yyyy-MM-dd").parse("2001-12-27"),
                "asdasdasd.com",
                new SimpleDateFormat("yyyy-MM-dd").parse("2001-12-26"));
        personaRepository.save(new Persona(persona));
    }

    @Test
    void addPersonaTest() throws URISyntaxException {
        final String url = "http://localhost:"+randomServerPort+"/addperson";
        URI uri = new URI(url);
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
                new Date(2003-11-23),
                true);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<PersonaInputDTO> request = new HttpEntity<>(persona,headers);

        ResponseEntity<PersonaOutputDTO> result = this.testRestTemplate.postForEntity(uri, request, PersonaOutputDTO.class);

        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals("Perez", Objects.requireNonNull(result.getBody()).getName());
    }

    @Test
    void getAllTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/getall";
        URI uri = new URI(baseUrl);

        ResponseEntity<PersonaCorsOutputDTO[]> result =
                this.testRestTemplate.getForEntity(uri, PersonaCorsOutputDTO[].class);

        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals("Madrid", Objects.requireNonNull(result.getBody())[0].getCity());
        Assertions.assertEquals(2,result.getBody().length);
    }
}
