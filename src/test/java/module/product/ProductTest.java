package module.product;

import dataFactory.ProductDataFactory;
import dataFactory.UserDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.ComponentPojo;
import pojo.ProductPojo;
import pojo.UserPojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


@DisplayName("Testes de API Rest do modulo de Produto")
public class ProductTest {
    private String token;

    @BeforeEach
    public void beforeEach(){
        //Configurar os dados da API Rest da lojinha
        baseURI = "http://165.227.93.41";
        basePath = "/lojinha";
        //Caso necessario informar a porta utilize port: 8080 por exemplo

        //Obter o token do usuario admin
        this.token = given()
                .contentType(ContentType.JSON)
                .body(UserDataFactory.createAdminUser())
            .when()
                .post("/v2/login")
            .then()
                .extract()
                    .path("data.token");
    }

    @Test
    @DisplayName("Validar que o valor do produto igual a 0.00 nao e permitido")
    public void testValidateThatValuesLowerThanAllowedCannotBeEnteredInTheProduct(){

        //Tentar inserir um produto com valor 0.00 e validar que a mensagem de erro foi apresentada e o status code retornado foi 422
        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProductDataFactory.createdCommonProductWithTheValueEqualTo(0.00))
        .when()
                .post("/v2/produtos")
        .then()
                .assertThat()
                .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                .statusCode(422);

    }

    @Test
    @DisplayName("Validar que o valor do produto igual a 7000.01 nao e permitido")
    public void testValidateThatValuesGreaterThanAllowedCannotBeEnteredIntoTheProduct(){
        //Tentar inserir um produto com valor 7.000.01 e validar que a mensagem de erro foi apresentada e o status code retornado foi 422

        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProductDataFactory.createdCommonProductWithTheValueEqualTo(7000.01))
        .when()
                .post("/v2/produtos")
        .then()
                .assertThat()
                .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                .statusCode(422);
    }



}
