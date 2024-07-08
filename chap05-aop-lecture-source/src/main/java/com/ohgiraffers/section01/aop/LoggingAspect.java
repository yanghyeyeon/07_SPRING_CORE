package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // PointCut, Advice

    /*
    * @PointCut : 여러 조인 포인트를 매치하기 위한 표현식
    * execution([수식어] 리턴타입 [클래스이름].이름(파라미터))
    * 수식어 생략 가능 (접근제어자) public private protected default
    * *Service.*(..)    : 매개변수가 0개 이상인 모든 메서드
    * *Service.*(*)     : 매개변수가 1개인 모든 메서드
    * *Service.*(*,..)  : 매개변수가 2개인 모든 메서드
    * */

    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointcut() {}

    /*
    * JoinPoint : 포인트컷으로 패치한 실행 지점
    * JonPoint객체에서 현재 조인 포인트의 메소드명, 인수값 등의 정보를 엑세스 할 수 있다.
    * */

    @Before("logPointcut()")
    public void logBefore(JoinPoint joinPoint) {

        // 조인포인트에서 할 일. Advice
        System.out.println("Before joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("Before joinPoint.getSignature() : " + joinPoint.getSignature());

        if (joinPoint.getArgs().length > 0) { // 매개변수
            System.out.println("Before joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
        }
    }

    @After("logPointcut()")
    public void logAfter(JoinPoint joinPoint){

        // 조인포인트에서 할 일. Advice
        System.out.println("After joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature() : " + joinPoint.getSignature());

        if (joinPoint.getArgs().length > 0) { // 매개변수
            System.out.println("After joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
        }
    }

    // 리턴받은 값을 가공하는 형태로 사용된다.
    @AfterReturning(pointcut = "logPointcut()",returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("AfterReturning result : " + result);
    }

    /*
    * AfterThrowing
    * -> throwing 속성의 이름과 매개변수의 이름이 동일해야한다.
    * */
    @AfterThrowing(pointcut = "logPointcut()" , throwing = "exception")
    public void lofAfterThrowing(Throwable exception) {
        System.out.println("After Throwing exception " + exception);
    }

    /*
    * Around Advice
    * - 조인포인트를 와전히 장악한다.
    * - 앞어서의 어드바이스 모두 around 어드바이스로 조합 가능하다.
    * - AroundAdvice의 조인포인트 매개변수는 ProceedingJoinPoint로 고정되어 있기 때문에
    * JoinPoint의 하위 인터페이스로 원본 조인포인트의 진행 지점을 제어 할 수 있다.
    * - 조인포인트를 진행하는 호출을 잊는 경우가 많이 방생하기 때문에
    * - 최소한의 요건을 충족하면서도 가장 가능이 약한 어드바이스를 쓰는게 바람직 하다.
    * */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        // 사전 로직
        System.out.println("Around Before " + joinPoint.getSignature());

        Object result = joinPoint.proceed();

        // 사후 로직
        System.out.println("Around After " + joinPoint.getSignature());

        return result;
    }

}
