package com.cybr406.basics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class Controller
{
    @Value("${app.environment}")
    String environment;

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.setValidator(new UserValidator());
    }

    @RequestMapping("/helloworld")
    public String pathGreeting()
    {
        return "Hello, world.";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam String name)
    {
        return "Hello, " + name + ".";
    }

    @RequestMapping("/path/to/{name}")
    public String path(@PathVariable String name)
    {
        return String.format("You're on the path to %s!", name);
    }

    @RequestMapping("/map")
    public String map(@RequestParam MultiValueMap<String, String> params)
    {
        // Possibility 1 - steams api
        return params.entrySet().stream()
                .map(entry -> String.format("%s values = %s", entry.getKey(), String.join(", ", entry.getValue())))
                .collect(Collectors.joining("\n"));
    }

    @PostMapping("/register")
    public ResponseEntity<User> createUser (@Valid @RequestBody User user)
    {
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

//    @RequestMapping("/register")
//    public String userValid(@RequestParam String username, String password)
//    {
//        User user = new User();
//
//        user.setUsername("test");
//        user.setPassword("secret");
//
//        return "{ \"username\" : \"" + username + "\", \"password\" : \"" + password + "\" }";
//
//    }

    @RequestMapping("/env")
    public String localEnv() {
        return environment;
    }





}
