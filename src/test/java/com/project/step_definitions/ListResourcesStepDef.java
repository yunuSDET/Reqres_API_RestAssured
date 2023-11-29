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





    @Then("verify that {string} list starts with {string} and have {int} characters")
    public void verify_that_list_starts_with_and_have_characters(String path, String startsWithValue, int size) {

        List<Object> colors = response.path(path);

        for (Object eachColor : colors) {
            String each = eachColor.toString();
            Assert.assertTrue(each.startsWith(startsWithValue) && each.length()==size );
        }
    }


    @Then("verify that each element of {string} is in the following format NN-NNNN")
    public void verify_that_each_element_of_is_in_the_following_format_nn_nnnn(String path) {
        List<String> pantoneValues = response.path(path);

        for (String each : pantoneValues) {
            Assert.assertTrue(each.matches("\\d{2}-\\d{4}"));
        }

    }



    @Then("verify the value of {string} lists {int}. element is {int}")
    public void verify_the_value_of_lists_element_is(String path, Integer index, Integer value) {

       List<Integer> values = response.path(path);
        System.out.println(values.get(index-1) +"  "+value);
        Assert.assertEquals(values.get(index - 1), value);


    }




}




