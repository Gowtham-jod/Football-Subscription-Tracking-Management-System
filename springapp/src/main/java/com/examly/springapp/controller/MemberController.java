package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Member;
import com.examly.springapp.service.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<List<Member>> getMembersByPage(
            @PathVariable int page,
            @PathVariable int size) {
        return ResponseEntity.ok(service.getMembersByPage(page, size));
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        return new ResponseEntity<>(service.createMember(member), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getMemberById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(
            @PathVariable Long id,
            @RequestBody Member member) {
        return ResponseEntity.ok(service.updateMember(id, member));
    }
}
