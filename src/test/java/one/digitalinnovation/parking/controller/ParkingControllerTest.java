package one.digitalinnovation.parking.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import io.restassured.RestAssured;
import one.digitalinnovation.parking.controller.dto.ParkingCreateDTO;

// a aplicação vai subir em uma porta aleatória
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerTest extends AbstractContainerBase {

    // mapeia a porta
    @LocalServerPort
    private int randomPort;

    // configura a porta que vai fazer o teste
    @BeforeEach
    public void setUpTest() {
        RestAssured.port = randomPort;
    }

    // quando fazer o FindAll vai checar o resultado, quando fazer um get no path especificado vai pegar o statusCode
    @Test
    void whenFindAllThenCheckResult() {
        RestAssured.given()
                .auth().basic("user", "12345")
                .when()
                .get("/parking")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    // quando o check for criado
    @Test
    void whenCreateThenCheckIsCreated() {
        var createDTO = new ParkingCreateDTO();
        createDTO.setColor("AMARELO");
        createDTO.setLicense("WRT-5555");
        createDTO.setModel("BRASILIA");
        createDTO.setState("SP");

        // quando colocar um corpo DTO no .post vai retornar criar um HttpStatus e os valores passados
        RestAssured.given()
                .when()
                .auth().basic("user", "12345")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(createDTO)
                .post("/parking")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("license", Matchers.equalTo("WRT-5555"))
                .body("color", Matchers.equalTo("AMARELO"));
    }
}
