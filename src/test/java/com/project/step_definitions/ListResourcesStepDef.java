package com.project.step_definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;


import java.util.List;
import java.util.Map;


public class ListResourcesStepDef extends BaseStepDef {


    @Then("print each element of {string} array from response with this condition {string} {string} {int}")
    public void print_each_element_of_array_from_response_with_this_condition(String pathOfList, String elementOfList, String operator, int value) {

        List<Map<Object, Object>> list = response.path(pathOfList);

        //TODO make this method flexible enough with another operators

        for (Map<Object, Object> eachMap : list) {

            if (operator.equals("=")) {
                if (Integer.parseInt(eachMap.get(elementOfList) + "") == value) {
                    System.out.println(eachMap);
                }
            }

        }
    }


    @Then("{string} starts with {string} and have {int} characters")
    public void starts_with_and_have_characters(String path, String startsWithValue, Integer size) {

       List<Object> colors = response.path(path);

        for (Object eachColor : colors) {
            String each = eachColor.toString();
            Assert.assertTrue(each.startsWith(startsWithValue) && each.length()==size );
        }

    }




}




