package com.ohgiraffers.practice01.field;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.practice01.field");


        MemberController memberController = context.getBean(MemberController.class);

        System.out.println(memberController.selectMember());



    }
}
