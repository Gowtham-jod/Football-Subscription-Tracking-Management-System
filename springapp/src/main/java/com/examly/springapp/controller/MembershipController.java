package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membership")
public class MembershipController {

    @GetMapping("/{id}")
    public String getMembership(@PathVariable int id) {
        return "Membership ID: " + id;
    }
}
