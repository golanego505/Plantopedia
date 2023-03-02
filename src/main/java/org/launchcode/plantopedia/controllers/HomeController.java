package org.launchcode.plantopedia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "logout")
    public String logout() {
        return "logout";
    }

    @GetMapping(value = "photos")
    public String photos() {
        return "photos";
    }

    @GetMapping(value = "settings")
    public String settings() {
        return "settings";
    }

    @GetMapping(value = "favorites")
    public String favorites() {
        return "favorites";
    }

    @GetMapping(value = "updates")
    public String updates() {
        return "updates";
    }
}
