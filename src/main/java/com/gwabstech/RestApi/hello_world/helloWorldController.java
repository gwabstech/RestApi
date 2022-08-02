package com.gwabstech.RestApi.hello_world;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldController {

    //Get
    // uri - /hello-
    @GetMapping( path = "/hello-world")
    public String helloWorld(){
        return "Hello Abubakar";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean (){
        return new HelloWorldBean("Hello Abubakar");
    }

    //adding a perimeter
    @GetMapping("/hello-world-bean/{name}")
    public HelloWorldBean helloWorldBean_p (@PathVariable String name){
        return new HelloWorldBean(String.format("Hello, %s",name));
    }

}
