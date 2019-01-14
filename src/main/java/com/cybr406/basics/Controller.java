package com.cybr406.basics;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class Controller
{
    @RequestMapping("/helloworld")
    public String pathGreeting() {
        return "Hello, world.";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam String name)
    {
        return "Hello, " + name + ".";
    }

    @RequestMapping("/path/to/{victory}")
    public String path(@PathVariable String victory)
    {
       // victory = "You're on the path to victory!";
       // return victory;
        return "You're on the path to victory!";
    }

    @RequestMapping("/map?key1=aaa&key2=bbb")
    public String multiValue(@RequestParam MultiValueMap <String,String> multiValue)
    {
        String multivalue = "key1 values = aaa\n" +
                "key2 values = bbb";

        return multivalue;

    }

    @RequestMapping("/map?key1=aaa&key2=bbb&key2=ccc")
    public String multiValueParam(@RequestParam List<String> multiParam)
    {
        return "Parameters are" + multiParam;

    }

    /*@RequestMapping("/register")
    public String userCreation(@RequestParam User nate)
    {
        nate.setUsername(nate.getUsername());
        nate.setPassword(nate.getPassword());

        return nate.getUsername() + nate.getPassword();

    }
    */

    @RequestMapping("/register")
    public String userValid(@RequestParam String username, String password)
    {
        User user = new User();

        user.setUsername("test");
        user.setPassword("secret");

        return "{ \"username\" : \"" + username + "\", \"password\" : \"" + password + "\" }";


    }

    @RequestMapping("/env")
    public String localEnv() {
        return "local";
    }





}
