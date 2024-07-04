package com.ohgiraffers.practice02.javaconfig;

import com.ohgiraffers.common.BoardDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        BoardDTO member = context.getBean("getMember",BoardDTO.class);

//        BoardDTO member2 = context.getBean("member",BoardDTO.class);

        System.out.println(member);
    }
}
