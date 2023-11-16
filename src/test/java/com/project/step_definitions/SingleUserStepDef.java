package com.project.step_definitions;

import com.project.utilities.API;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.awt.*;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SingleUserStepDef extends BaseStepDef{

    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "https://reqres.in";
    }



    @Then("verify that following list {string} include this element {string}")
    public void verify_that_following_list_include_this_element(String listFromResponse, String element) {
        List<Object> data = response.path(listFromResponse);

        List<String> collect = API.integerToStringListFromResponse(data);

        Assert.assertTrue(collect.contains(element));


    }




    @Then("verify that listed links {string} is working")
    public void verify_that_listed_links_is_working(String linkList) {

        List<String> data = API.integerToStringListFromResponse(response.path(linkList));

        for (String each : data) {
            given()
                    .contentType(ContentType.JSON)
                    .get(each)
                    .then()
                    .statusCode(200);
        }

    }






}
