package com.ohgiraffers.section01.scope.subsection01.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {


    /*
    * bean scope
    * 스프링 빈이 생성될 때 생기는 인스턴스의 범위를 위미한다.
    * 스프링에서는 다양한 bean scope를 제공한다. default = Singleton
    *
    * singleton     하나의 인스턴스만을 생성하고, 모든 빈이 해당 인스턴스를 공유하여 사용한다.
    * prototype     매번 새로운 인스턴스를 생성한다
    * request       HTTP 요청을 처리할 때마다 새로운 인스턴스를 생성하고,
    *               요청처리가 끝나면 인스턴스를 폐기한다. 웹 어플리케이션 컨택스트에만 해당한다.
    * session       HTTP 세션 당 하나의 인스턴스를 생성하고
    *               세션이 종료되면 인스턴스를 폐기한다. 웹어플리케이션 컨텍스트에만 해당한다.
    * globalSession 전역 세션 당 하나의 인스턴스를 생성하고
    *               전역 세션이 종료되면 인스턴스를 폐기한다. 포털 어플리케이션 컨텍스트에만 해당된다.
    *
    * */
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName: " + beanName);
        }

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        // 첫번째 손님이 쇼핑 카트를 꺼낸다.
        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);

        // 빵이랑 우유를 담는다.
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        // 담긴내용 확인
        System.out.println("cart1에 담긴 내용 : " + cart1.getItem());

        // 두번째 손님이 쇼핑 카트를 꺼낸다.
        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);

        // 물을 담는다.
        cart2.addItem(water);

        //담긴내용 확인
        System.out.println("cart2에 담긴 내용 : " + cart2.getItem());

        System.out.println("cart1의 hashCode : " + cart1.hashCode());
        System.out.println("cart2의 hashCode : " + cart2.hashCode());
    }
}
