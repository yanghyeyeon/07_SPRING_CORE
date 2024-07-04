package com.ohgiraffers.practice02.javaconfig;

import com.ohgiraffers.common.BoardDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public BoardDTO getMember() {
        System.out.println("getMember 호출함...");
        return new BoardDTO(1L,"user01","pass01","홍길동");
    }


}
