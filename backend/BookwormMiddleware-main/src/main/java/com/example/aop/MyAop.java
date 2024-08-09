package com.example.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAop {
	
	@Pointcut("execution(* com.example.controllers.ProductTypeMasterController.*(..) )")
	public void getproduct() {}
       
	@Before("getproduct()")
	public void beforeproducttype()
	{
		System.out.println("before");
	}
	
}