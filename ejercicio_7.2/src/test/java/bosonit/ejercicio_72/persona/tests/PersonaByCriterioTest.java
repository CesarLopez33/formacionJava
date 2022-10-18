package bosonit.ejercicio_72.persona.tests;

import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_72.persona.dtos.PersonaOutputDTO;
import bosonit.ejercicio_72.persona.repository.PersonaRepository;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PersonaByCriterioTest {
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
    void CriteriaBuilderTest1() throws URISyntaxException {
        final String url = "http://localhost:"+randomServerPort+"/persona/criterio?" +
                "usuario=Juanes&surname=Perez&" +
                "created_date=2001-12-28&date_condition=less&"+
                "order_by=name&num_page=0&page_size=3";
        URI uri = new URI(url);
        ResponseEntity<PersonaOutputDTO[]> result = this.testRestTemplate.getForEntity(uri, PersonaOutputDTO[].class);
        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals("Alfonso", Objects.requireNonNull(result.getBody())[0].getName());
        Assertions.assertEquals("Perez", result.getBody()[0].getSurname());
        Assertions.assertEquals("Juanes", result.getBody()[0].getUsuario());
        Assertions.assertEquals("Manuel", Objects.requireNonNull(result.getBody())[1].getName());
        Assertions.assertEquals("Perez", result.getBody()[1].getSurname());
        Assertions.assertEquals("Juanes", result.getBody()[1].getUsuario());
    }

    @Test
    void CriteriaBuilderTest2() throws URISyntaxException {
        final String url = "http://localhost:"+randomServerPort+"/persona/criterio?" +
                "usuario=Juanes&surname=Perez&" +
                "created_date=2000-12-28&date_condition=greater&"+
                "order_by=user&num_page=0&page_size=3";
        URI uri = new URI(url);
        ResponseEntity<PersonaOutputDTO[]> result = this.testRestTemplate.getForEntity(uri, PersonaOutputDTO[].class);
        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals("Perez", Objects.requireNonNull(result.getBody())[0].getSurname());
        Assertions.assertEquals("Juanes", result.getBody()[0].getUsuario());
        Assertions.assertEquals("Perez", result.getBody()[1].getSurname());
        Assertions.assertEquals("Juanes", result.getBody()[1].getUsuario());
    }
}
