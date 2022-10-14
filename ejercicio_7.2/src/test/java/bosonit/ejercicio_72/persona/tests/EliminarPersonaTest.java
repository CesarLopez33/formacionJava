package bosonit.ejercicio_72.persona.tests;

import bosonit.ejercicio_72.persona.Persona;
import bosonit.ejercicio_72.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_72.persona.repository.PersonaRepository;
import org.junit.jupiter.api.*;
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
class EliminarPersonaTest {
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
    void eliminarPersonaTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/persona/"+1;
        URI uri = new URI(baseUrl);
        this.testRestTemplate.delete(uri);

        Assertions.assertFalse(personaRepository.findById(1).isPresent());
    }
}
