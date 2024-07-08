package com.ohgiraffers.section02.reflection;

import java.lang.reflect.*;

public class Application {

    public static void main(String[] args) {

        /*
        * 리플렉션
        * - 컴파일된 자바 코드에서 역으로 클래스를 불러 메소드 및 필드 정보를 구해오는 방법을 제공
        * - 스프링, 마이바티스. 하이버네이트, jackson 등의 라이브러리에서 사용
        * */

        /*
        * 리플렉션의 주의사항
        *
        * 1. 오버헤드 발생 : 성능 저하를 발생시킬 수 있다. 서능에 민감한 어플리케이션의 경우 사용하지 않는다.
        * 2. 캡슐화를 저해 : private로 설정한 member에 접근 가능하기 때문에 코드 기능이 저하되며 여러가지 문제 야기
        * */

        Class class1 = Account.class;

        System.out.println("class1 : " + class1);

        // Object 클래스의 getClass() 메소드를 이용하면 class 타입으로 리턴받아 이용 가능하다.
        Class class2 = new Account().getClass();
        System.out.println("class2 : " + class2);

        try {
            // Class.forName() 메소드를 이용해 런타임시 로딩을 하고 그 클래스 메타정보를
            // Class 타입으로 받을 수 있다.

            // 동적 로딩 (런타임시 로딩)
            Class class3 = Class.forName("com.ohgiraffers.section02.reflection.Account");
            System.out.println("class3 : " + class3);

            // Double 자료형의 배열 클래스 로딩
            System.out.println("============= Double 자료형 배열 클래스 =============");
            Class class4 = Class.forName("[D");
            Class class5 = double[].class;

            System.out.println("class4 : " + class4);
            System.out.println("class5 : " + class5);

            System.out.println("============= String 자료형 배열 클래스 =============");
            Class class6 = Class.forName("[Ljava.lang.String;"); // 문자열 배열 타입
            Class class7 = String[].class;

            System.out.println("class6 : " + class6);
            System.out.println("class7 : " + class7);

            // Account 부모타입
            System.out.println("============= Account 의 부모 클래스 =============");
            Class superClass = class1.getSuperclass();

            System.out.println("superClass = " + superClass);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // 필드 정보 반환
        System.out.println("============= Account 의 필드에 대한 정보 =============");

        // 필드에 대한 메타정보를 받을 수 있음
        Field[] fields = Account.class.getDeclaredFields();

        for (Field field : fields) {
            System.out.println("modifiers = " + Modifier.toString(field.getModifiers())); // 접근제어자
            System.out.println("type = " + field.getType()); // 타입
            System.out.println("name = " + field.getName()); // 변수명
        }

        // 생성자 정보 반환
        System.out.println("============= Account 의 생성자에 대한 정보 =============");
        Constructor[] constructors = Account.class.getConstructors();
        for (Constructor con : constructors) {
            System.out.println("name : " + con.getName());

            Class[] params = con.getParameterTypes();
            for (Class param : params) {
                System.out.println("paramType : " + param.getTypeName());
            }
        }

        // 생성자를 이용해서 인스턴스 생성 가능
        System.out.println("============= 생성자로 인스턴스 생성하기 =============");

        try {
            Account acc = (Account) constructors[0].newInstance("20","110-223-123456","1234",10000);
            System.out.println(acc.getBalance());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 메소드 정보 반환
        System.out.println("============= 메소드 정보 확인하기 =============");
        Method[] methods = Account.class.getMethods();

        Method getBalanceMethod = null;
        for(Method method : methods) {
            System.out.println(
                    Modifier.toString(method.getModifiers()) + " " +
                            method.getReturnType().getSimpleName() + " " +
                            method.getName());

            if ("getBalance".equals(method.getName())) {
                getBalanceMethod = method;
            }
        }

        // invoke : 타겟 메소드를 호출하는 역할

        try {

            System.out.println(getBalanceMethod.invoke((Account)constructors[2].newInstance()));

        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
