package com.project.step_definitions;

import io.cucumber.java.en.Then;


import java.util.List;
import java.util.Map;

public class ListResourcesStepDef extends BaseStepDef{


    @Then("print each element of {string} array from response with this condition {string} {string} {int}")
    public void print_each_element_of_array_from_response_with_this_condition(String pathOfList, String elementOfList, String operator, int value) {

        List<Map<Object,Object>> list =response.path(pathOfList);

        if(operator.equals("=")){
            for (Map<Object, Object> eachMap : list) {
                if(Integer.parseInt(eachMap.get(elementOfList)+"")==value){
                    System.out.println(eachMap);
                }
            }
        }

    }



}
