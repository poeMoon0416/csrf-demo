package com.example.trap_site_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class TrapSiteAppController {
    @GetMapping("/")
    public String index() {
        return "csrf";
    }

}
