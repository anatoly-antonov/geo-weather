package main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeoController {

    @RequestMapping("/")
    public String index() {
        return "test";
    }
}

