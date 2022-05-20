package com.example.testredis.testCurdRepository.intercep;

import com.alibaba.fastjson.JSON;
import com.example.testredis.testCurdRepository.pojo.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author erpang
 * @PackageName: com.example.testredis.testCurdRepository.intercep
 * @ClassName: MyCrudIntercepAspect
 * @Description:
 * @date 2022/4/28 14:20
 */
@Aspect
@Component
public class MyCrudIntercepAspect {

    @Pointcut("execution(* com.example.testredis.testCurdRepository.service.*.*(..))")
    public void anyMethod() {

    }

    @Around("execution(* com.example.testredis.testCurdRepository.service.impl.UserService.*(..))")
    public Object aroundAction(ProceedingJoinPoint jp) throws Throwable {

        System.out.println("开始执行环绕通知===MyCrudIntercepAspect======");

        //获得连接点的参数
        Object[] args = jp.getArgs();


        System.out.println("目标方法的参数为：" + JSON.toJSONString(args));

        Object target = jp.getTarget();
        System.out.println("目标对象为：：" + JSON.toJSONString(target));


        //允许执行目标方法,返回目标方法的返回结果
        Object result = jp.proceed();
        System.out.println("原方法" + JSON.toJSONString(result));

        User u = (User) args[0];
        u.setName("test");
        result = jp.proceed(new Object[]{u});

        System.out.println("目标方法的返回结果为：" + JSON.toJSONString(result));


        return result;
    }
}
