package com.project.utilities;

import java.util.List;
import java.util.stream.Collectors;

public class API {


    public static List<String> integerToStringListFromResponse(List<Object> list){

        return list.stream().map(Object::toString).collect(Collectors.toList());
    }


}
