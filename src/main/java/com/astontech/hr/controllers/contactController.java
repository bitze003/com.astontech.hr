package com.astontech.hr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class contactController {

    @RequestMapping("/contact")
    public String employeePage() {
        return "contact";
    }
}
