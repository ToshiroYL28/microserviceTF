package com.example.appbient_microservice_foro.StepsDefinitions;

import com.example.appbient_microservice_foro.api.resource.PublicacionForo.CreatePublicacionForoResource;
import com.example.appbient_microservice_foro.api.resource.PublicacionForo.PublicacionForoResource;
import io.cucumber.java.en.*;
import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class USA04Steps {
    @LocalServerPort
    private RestTemplate restTemplate = new RestTemplate();
    private String baseUrl = "http://localhost:8080/api/v1/";
    private CreatePublicacionForoResource publicacion;
    @Given("el voluntario se encuentra en el formulario de creacion de publicacion")
    public void el_voluntario_se_encuentra_en_el_formulario_de_creacion_de_publicacion() {
       baseUrl = baseUrl+ "publicacion/";
    }


    @When("complete el formulario con nombre {string}, descripcion {string}, voluntaioId {string}, ongId {string} y topicoId {string}")
    public void completeElFormularioConNombreNombreDescripcionDescripcionVoluntaioIdVoluntarioIdOngIdOngIdYTopicoIdTopicoId(String nombre, String descripcion, String voluntarioId, String ongId, String topicoId) {
        publicacion = new CreatePublicacionForoResource(true, nombre, descripcion, Long.parseLong(voluntarioId), null, Long.parseLong(topicoId));

    }

    @And("le de click al boton de crear publicacion")
    public void leDeClickAlBotonDeCrearPublicacion() {
        PublicacionForoResource response = restTemplate.postForObject(baseUrl, publicacion, PublicacionForoResource.class);
        log.info(response);
        assertNotNull(response);
    }

    @Then("se mostrar el mensaje {string}")
    public void seMostrarElMensaje(String arg) {
        log.info(arg);
    }

}
