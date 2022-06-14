package com.example.appbient_microservice_usuarios.StepsDefinitions;
import com.example.appbient_microservice_usuarios.api.resource.Ong.CreateOngResource;
import com.example.appbient_microservice_usuarios.api.resource.Ong.OngResource;
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
public class USA02Steps {
    @LocalServerPort
    private RestTemplate restTemplate = new RestTemplate();
    private String baseUrl = "http://localhost:8080/api/v1/";
    private CreateOngResource ong;
    @Given("el usuario se encuentra en el formulario de registro")
    public void el_usuario_se_encuentra_en_el_formulario_de_registro() {
        baseUrl = baseUrl+ "ong/";
    }


    @When("complete el formulario con name {name}, Descripcion {Descripcion} y email {email}")
    public void completeElFormularioConnamenameDescripcionDescripcionLocalLocals(String name, String description, String email) {

    }

    @And("le de click al boton de crear ong")
    public void leDeClickAlBotonDeCrearOng() {
        OngResource response = restTemplate.postForObject(baseUrl, ong, OngResource.class);
        log.info(response);
        assertNotNull(response);
    }

    @Then("se mostrar el mensaje {string}")
    public void seMostrarElMensaje(String arg) {
        log.info(arg);
    }

}