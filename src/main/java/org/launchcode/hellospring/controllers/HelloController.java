package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //Handles request at path /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "example")
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String languages){
        return createMessage(name, languages);

    }

    //Handles request of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    // Handles request at /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                    "<body>" +
                        "<form action='/hello/example' method='post'>" + // submit a request to /hello
                            "<input type='text' name='name'>" +
                               "<select name='languages' id='language-select'>" +
                                   "<option value='french'>French</option>" +
                                   "<option value='portuguese'>Portuguese</option>" +
                                   "<option value='spanish'>Spanish</option>" +
                                   "<option value='italian'>Italian</option>" +
                                   "<option value='english' selected >English</option>" +
                               "</select>" +
                           "<input type='submit' value='Greet me!'>" +
                       "</form>" +
                   "</body>" +
               "</html>";
    }


    public static String createMessage( String name, String languages){
        String greeting = "";
        if (languages.equals("english")){
            greeting = "Hello, " + name + "!";
        } else if (languages.equals("french")) {
            greeting = "Bonjour, " + name + "!";
        } else if (languages.equals("italian")) {
            greeting = "Ciao, " + name + "!";
        } else if (languages.equals("portuguese")) {
            greeting = "Olá, " +name + "!";
        } else if (languages.equals("spanish")) {
            greeting = "¡Hola, " + name + "!";
        }
        return greeting;
    }
}
