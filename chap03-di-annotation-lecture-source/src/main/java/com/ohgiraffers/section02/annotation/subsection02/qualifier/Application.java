package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        String[] beanNames = context.getBeanDefinitionNames();
        for(String name : beanNames) {
            System.out.println(name);
        }

        // 스프링 컨텍스트에 등록된 같은타입의 bean이 3개나 있다는 뜻
        // 한개만 필요하다
        //expected single matching bean but found 3: charmander,pikachu,squirtle

        PokemonService pokemonService = context.getBean("pokemonServiceQualifier", PokemonService.class);

        pokemonService.pokemonAttack();
    }
}
