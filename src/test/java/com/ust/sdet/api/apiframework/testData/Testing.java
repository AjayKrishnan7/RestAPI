package com.ust.sdet.api.apiframework.testData;

import com.ust.sdet.api.apiframework.config.Constants;
import com.ust.sdet.api.apiframework.spec.SpecFactory;
import io.restassured.module.jsv.JsonSchemaValidationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

import static com.ust.sdet.api.apiframework.spec.SpecFactory.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Testing {

    public Testing()
    {}

    @Test
    @DisplayName("Checking API Flow")
    void getRecords() {

        var PUTDATA = Map.of("id",0, "name","cat", "status", "available");
        var POSTDATA = Map.of("id",0, "name","doggie", "status", "available");


        int id=given()
                .spec(postReq())
                .when()
                .body(POSTDATA)
                .post()
                .then()
                .spec(postRes())
                .body("name", not(emptyString()))
                .body("name", equalTo((String)POSTDATA.get("name")))
                        .extract().path("id");


        given()
                .spec(getReq())
                .pathParam("petId", 658720)
                .when()
                .get("pet/{petId}")
                .then()
                .log().all()
                .spec(getRes());



        given()
                .spec(putReq())
            .when()
                .body(PUTDATA)
                .put()
            .then()
                .spec(getRes());


        given()
                .spec(getReq())
            .when()
                .delete()
            .then()
                .log().all()
                .spec(deleteRes());
    }
    @Test
    void getFunction(){
        given()
                .spec(getReq())
                .log().all()
                .when()
                .get("/store/inventory")
                .then()
                .log().all()
                .spec(getRes());
    }
}


