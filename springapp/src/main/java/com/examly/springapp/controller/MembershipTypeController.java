package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.MembershipType;
import com.examly.springapp.service.MembershipTypeService;

@RestController
@RequestMapping("/api/membership-types")
public class MembershipTypeController {

    @Autowired
    private MembershipTypeService service;

    @PostMapping
    public ResponseEntity<MembershipType> create(@RequestBody MembershipType type) {
        return new ResponseEntity<>(service.create(type), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MembershipType> update(@PathVariable int id, @RequestBody MembershipType type) {
        return ResponseEntity.ok(service.update(id, type));
    }

    @GetMapping
    public ResponseEntity<List<MembershipType>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembershipType> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name) {
        List<MembershipType> list = service.getByName(name);
        if (list.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("No membership types found");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/price")
    public ResponseEntity<?> getByPriceRange(@RequestParam double min, @RequestParam double max) {
        List<MembershipType> list = service.getByPriceRange(min, max);
        if (list.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("No membership types found");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/price-less/{price}")
    public ResponseEntity<?> getByPriceLess(@PathVariable double price) {
        List<MembershipType> list = service.getByPriceLessThan(price);
        if (list.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("No membership types found");
        return ResponseEntity.ok(list);
    }

       @GetMapping("/duration-greater/{duration}")
    public ResponseEntity<?> getByDuration(@PathVariable int duration) {
        List<MembershipType> list = service.getByDurationGreaterThan(duration);
        if (list.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("No membership types found with duration greater than " + duration);
        return ResponseEntity.ok(list);
    }
}
