package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {


        ApplicationContext context =
                new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

//        MemberDTO member = new MemberDTO();

        MemberDTO member = (MemberDTO) context.getBean("member");

        System.out.println(member);
    }
}