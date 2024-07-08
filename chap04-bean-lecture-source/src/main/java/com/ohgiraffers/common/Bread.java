package com.ohgiraffers.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Bread extends Product{

    private LocalDate bakeDate;     //생산시간

    // 부모클래스까지 초기화 하는 생성자
    public Bread(String name, int price, LocalDate bakeDate) {

        super(name, price); //부모클래스의 생성자
        this.bakeDate = bakeDate;
    }

    //    @Override
//    public String toString() {
//        return "Bread{" +
//                super.toString() +
//                "bakeDate=" + bakeDate +
//                '}';
//    }
}
