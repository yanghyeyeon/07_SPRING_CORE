package com.ohgiraffers.section01.autowired.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class BookDTO {

    private int sequence;
    private int isbn;
    private String title;
    private String author;
    private String publisher;
    private LocalDate createDate;
}
