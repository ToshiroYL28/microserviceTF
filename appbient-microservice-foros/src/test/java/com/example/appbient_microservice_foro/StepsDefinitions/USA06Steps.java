package com.example.appbient_microservice_foro.StepsDefinitions;
import com.example.appbient_microservice_foro.api.resource.ComentarioForo.CreateComentarioForoResource;
import com.example.appbient_microservice_foro.api.resource.ComentarioForo.ComentarioForoResource;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
public class USA06Steps {
    @LocalServerPort
    private RestTemplate restTemplate = new RestTemplate();
    private String baseUrl = "http://localhost:8080/api/v1/";
    private CreateComentarioForoResource comentario;
    @Given("el voluntario se encuentra en el cuadro de texto del <foro> que desea comentar")
    public void el_voluntario_se_encuentra_en_el_cuadro_de_texto_que_desea_comentar() {
        baseUrl = baseUrl+ "comentario/";
    }



    @When("el voluntario rellene el cuadro con su <comentario>")
    public void elVoluntarioRelleneElCuadroConSuComentario( String descripcion) {
        comentario = new CreateComentarioForoResource( descripcion);

    }

    @And("le de click en el boton de comentar")
    public void leDeClickEnElCotonDeComentar() {
        ComentarioForoResource response = restTemplate.postForObject(baseUrl, comentario, ComentarioForoResource.class);
        log.info(response);
        assertNotNull(response);
    }

    @Then("el voluntario vera un mensaje de {string}")
    public void seMostrarElMensaje(String arg) {
        log.info(arg);
    }

}
