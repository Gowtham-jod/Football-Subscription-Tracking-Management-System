package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Member;

public interface MemberService {

    List<Member> getMembersByPage(int page, int size);

    Member createMember(Member member);

    Member getMemberById(Long id);

    Member updateMember(Long id, Member member);
}
