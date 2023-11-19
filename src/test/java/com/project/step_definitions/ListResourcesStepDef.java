package com.project.step_definitions;

import io.cucumber.java.en.Then;


import java.util.List;
import java.util.Map;

public class ListResourcesStepDef extends BaseStepDef{


    @Then("print each element of {string} array from response with this condition {string} {string} {string}")
    public void print_each_element_of_array_from_response_with_this_condition(String pathOfList, String elementOfList, String operator, String value) {

        String className =response.path(pathOfList+"."+elementOfList).getClass().getSimpleName();


        List<Map<Object,Object>> list =response.path(pathOfList);

        if(operator.equals("=")){
        //    list.stream().filter(i->i.get(value))
        }

    }



}
