package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.ohgiraffers")
@Configuration("contextConfiguration3")
public class ContextConfiguration {
}
