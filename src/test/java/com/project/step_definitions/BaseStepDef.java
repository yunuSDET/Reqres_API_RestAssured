package com.project.step_definitions;

import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseStepDef {

    String endPoint = "";
    RequestSpecification reqSpec = given()
            .accept(ContentType.JSON);

    static Response response;




}
