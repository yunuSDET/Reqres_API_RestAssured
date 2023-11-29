package com.project.step_definitions;


import com.project.utilities.API;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.velocity.runtime.parser.node.SimpleNode;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;
import java.util.Map;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ListUserStepDef extends BaseStepDef {


    @Given("I use this path {string}")
    public void i_use_this_path(String path) {
        endPoint += "/" + path;
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
        response.then().statusCode(statusCodeValue);
    }

    @Then("print the user list")
    public void print_the_user_list() {
        List<Object> users = response.path("data");
        System.out.println(users);

    }


    @Then("response headers {string} should have this value {string}")
    public void response_headers_should_have_this_value(String headerName, String value) {
        response.then().header(headerName, value);
    }


    @Then("request headers {string} should have this value {string}")
    public void request_headers_should_have_this_value(String headerName, String value) {
        given().spec(reqSpec).request().then().header(headerName, value);
    }


    @Then("check response time less than {int} ms")
    public void check_response_time_less_than_ms(int responseTime) {
        assertThat(response.getTime(), lessThan((long) responseTime));


    }


    @Then("verify the value of {string} element from response is {string}")
    public void verify_the_value_of_element_from_response_is(String element, String value) {

        response.then().body(element, is(value));

    }

    @Then("verify the value of {string} element from response is {int}")
    public void verify_the_value_of_element_from_response_is(String element, int value) {

        response.then().body(element, is(value));

    }


    @Then("print each element of {string} array from response")
    public void print_each_element_of_array_from_response(String pathOfList) {

        List<Object> data = response.path(pathOfList);
        for (Object eachData : data) {
            System.out.println(eachData);
        }


    }


    @Then("{string} url should be working")
    public void url_should_be_working(String path) {
        given().get(response.path(path) + "").then().statusCode(200);
    }


    @Then("print {string} from response")
    public void print_from_response(String path) {

        System.out.println(response.path(path).toString());
    }

    @Then("list each element of {string} array from response whose {string} is odd")
    public void list_each_element_of_array_from_response_whose_is_odd(String keyword1, String keyword2) {
        List<Map<Object, Object>> elements = response.path(keyword1);

        elements.stream()
                .filter(i -> ((Integer) i.get(keyword2) % 2 == 1))
                .forEach(System.out::println);
    }



    @Then("check each {string} contains user's name {string} under {string} from response")
    public void check_each_contains_user_s_name_under_from_response(String firstData, String secondData, String thirdData) {

        List<String> firstNames = response.path(thirdData + "." + secondData);

        List<String> emails = response.path(thirdData + "." + firstData);

        for (int i = 0; i < emails.size(); i++) {
            String eachMail = emails.get(i);
            String eachFirstName = firstNames.get(i).toLowerCase();
            assertThat(eachMail, containsString(eachFirstName));
        }
    }


    @Then("check {string} equals to {string} and {string} equals to {string} inside {string}")
    public void check_equals_to_and_equals_to_inside(String keyword1, String expected1, String keyword2, String expected2, String listName) {

        List<String> keyword1s = API.integerToStringListFromResponse(response.path(listName + "." + keyword1));


        List<String> keyword2s = API.integerToStringListFromResponse(response.path(listName + "." + keyword2));


        if (keyword1s.contains(expected1)) {

            int index = keyword1s.indexOf(expected1);
            assertThat(keyword2s.get(index).equals(expected2), is(true));

        } else {
            throw new RuntimeException(keyword1 + " is not found");
        }

    }


}
