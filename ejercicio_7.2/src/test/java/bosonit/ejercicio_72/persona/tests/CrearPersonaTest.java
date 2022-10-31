package bosonit.ejercicio_72.persona.tests;

import bosonit.ejercicio_72.exceptions.CustomError;
import bosonit.ejercicio_72.persona.dtos.PersonaInputDTO;
import bosonit.ejercicio_72.persona.dtos.PersonaOutputDTO;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
class CrearPersonaTest {
    @Autowired
    TestRestTemplate testRestTemplate;
    @LocalServerPort
    int randomServerPort;

    @Test
    void crearPersonaTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/persona/";
        URI uri = new URI(baseUrl);
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
    void crearPersonaBadInputTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:"+randomServerPort+"/persona/";
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        PersonaInputDTO persona = new PersonaInputDTO();

        HttpEntity<PersonaInputDTO> request = new HttpEntity<>(persona,headers);
        ResponseEntity<CustomError> result = this.testRestTemplate.postForEntity(uri, request, CustomError.class);
        Assertions.assertEquals(422, result.getStatusCodeValue());

        persona.setUsuario("aaa");

        request = new HttpEntity<>(persona,headers);
        result = this.testRestTemplate.postForEntity(uri, request, CustomError.class);
        Assertions.assertEquals(422, result.getStatusCodeValue());

        persona.setUsuario("aaaaaaaaaaa");

        request = new HttpEntity<>(persona,headers);
        result = this.testRestTemplate.postForEntity(uri, request, CustomError.class);
        Assertions.assertEquals(422, result.getStatusCodeValue());

        persona.setUsuario("Juaness");

        request = new HttpEntity<>(persona,headers);
        result = this.testRestTemplate.postForEntity(uri, request, CustomError.class);
        Assertions.assertEquals(422, result.getStatusCodeValue());

        persona.setPassword("abc123");

        request = new HttpEntity<>(persona,headers);
        result = this.testRestTemplate.postForEntity(uri, request, CustomError.class);
        Assertions.assertEquals(422, result.getStatusCodeValue());

        persona.setName("Sergio");

        request = new HttpEntity<>(persona,headers);
        result = this.testRestTemplate.postForEntity(uri, request, CustomError.class);
        Assertions.assertEquals(422, result.getStatusCodeValue());

        persona.setCompany_email("Sergio");

        request = new HttpEntity<>(persona,headers);
        result = this.testRestTemplate.postForEntity(uri, request, CustomError.class);
        Assertions.assertEquals(422, result.getStatusCodeValue());

        persona.setPersonal_email("Sergio");

        request = new HttpEntity<>(persona,headers);
        result = this.testRestTemplate.postForEntity(uri, request, CustomError.class);
        Assertions.assertEquals(422, result.getStatusCodeValue());

        persona.setCity("Sergio");

        request = new HttpEntity<>(persona,headers);
        result = this.testRestTemplate.postForEntity(uri, request, CustomError.class);
        Assertions.assertEquals(422, result.getStatusCodeValue());

        persona.setActive(Boolean.TRUE);

        request = new HttpEntity<>(persona,headers);
        result = this.testRestTemplate.postForEntity(uri, request, CustomError.class);
        Assertions.assertEquals(422, result.getStatusCodeValue());
    }


}
