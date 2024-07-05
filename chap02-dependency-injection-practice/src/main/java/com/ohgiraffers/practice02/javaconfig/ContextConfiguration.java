package com.ohgiraffers.practice02.javaconfig;

import com.ohgiraffers.common.BoardDTO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean("account")
    public MemberDTO memberGenerator() {
        MemberDTO member = new MemberDTO();

        member.setId(1L);
        member.setNickname("nickname");

        return member;
    }


    @Bean("board")
    public BoardDTO boardGenerator() {

        BoardDTO board = new BoardDTO();
        board.setId(1L);
        board.setContent("11");
        board.setTitle("222");
        board.setWriter(memberGenerator());

        return board;
    }
}
