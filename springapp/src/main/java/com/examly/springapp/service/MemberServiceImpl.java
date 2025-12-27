package com.examly.springapp.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Member;
import com.examly.springapp.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository repository;

    public MemberServiceImpl(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Member> getMembersByPage(int page, int size) {
        return repository.findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    public Member createMember(Member member) {
        return repository.save(member);
    }

    @Override
    public Member getMemberById(Long id) {
        return repository.findById(id).orElse(new Member());
    }

    @Override
    public Member updateMember(Long id, Member member) {
        Member existing = repository.findById(id).orElse(new Member());
        existing.setName(member.getName());
        existing.setEmail(member.getEmail());
        return repository.save(existing);
    }
}
