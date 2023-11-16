package com.project.step_definitions;


import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

public class ListUserStepDef {

    String endPoint ="";
    RequestSpecification reqSpec = given()
            .accept(ContentType.JSON);

    Response response;



    @BeforeAll
    public static void init() {
        RestAssured.baseURI = "https://reqres.in";
    }




    @Given("I use this path {string}")
    public void i_use_this_path(String path) {
        endPoint +="/"+path;
    }
    @Given("I use this query {string} {string}")
    public void i_use_this_query(String keyword, String value) {

        reqSpec = given().spec(reqSpec)
                .queryParam(keyword, value);

    }
    @When("I use get method")
    public void i_use_get_method() {
        response = given().spec(reqSpec)
                .when().get(endPoint);
    }


    @Then("status code should be {int}")
    public void status_code_should_be(int statusCodeValue) {
        response = response.then().statusCode(statusCodeValue).extract().response();
    }



    @Then("headers {string} should have this value {string}")
    public void headers_should_have_this_value(String header, String value) {
        response = response.then().header(header, value).extract().response();
    }


    @Then("host should be {string}")
    public void host_should_be(String value) {
        given().spec(reqSpec).request().header("Host",value);
    }


    @Then("check response time less than {int} ms")
    public void check_response_time_less_than_ms(int responseTime) {
        assertThat(response.getTime(),lessThan((long)responseTime));
    }




}
