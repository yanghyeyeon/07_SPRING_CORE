package com.ohgiraffers.section01.aop;

import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class MemberService {
    private final MemberDAO memberDAO;

    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    public Map<Long, MemberDTO> selectMembers() {
        System.out.println("전체조회 : selectMembers 메소드 실행");
        return memberDAO.selectMembers();
    }

    public MemberDTO selectMember(Long id) {
        System.out.println("단일조회 : selectMember 메소드 실행");
        return memberDAO.selectMember(id);
    }
}
