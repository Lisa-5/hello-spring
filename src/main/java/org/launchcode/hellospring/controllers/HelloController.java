package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    //Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model){
        String aGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", aGreeting);
        return "hello";
    }

    //Handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        //String aGreeting = "Hello, " + name + "!";  can be added in one line
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

    // Handles request at /hello/form
    @GetMapping("form")
    public String helloForm(){
       return "form";
    }

    // Handles request at /hello-names
    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> aNames = new ArrayList<>();
        aNames.add("LaunchCode");
        aNames.add("Java");
        aNames.add("JavaScript");
        aNames.add("TypeScript");
        aNames.add("Python");
        model.addAttribute("names", aNames);
        return "hello-list";
    }

}
