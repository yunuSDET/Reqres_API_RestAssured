package com.project.step_definitions;


import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;

public class Hooks {

    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "https://reqres.in";
    }

}
