/*package com.pma.org.logging;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class ApplicationLoggerAspect {
     
    private static Logger LOGGER=LoggerFactory.getLogger(ApplicationLoggerAspect.class);
	@Pointcut("within(com.pma.org.controllers..*)")
	public void definePackagePointCut()
	{
		
	}
	@Around("definePackagePointCut()")
	public Object logJoinPoint(ProceedingJoinPoint joinPoint)
	{
		LOGGER.debug(" \n \n \n ");
		LOGGER.debug("Before method: {}.{} () with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
        joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
		LOGGER.debug("--------------------------");
		Object o=null;
		try {
			 o=joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			LOGGER.error("Error exists: {} in {}.{} ()",Arrays.toString(joinPoint.getArgs()),joinPoint.getSignature()
					.getDeclaringTypeName(),joinPoint.getSignature().getName());
		}
		
		LOGGER.debug("After method: {}.{} () with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
		        joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
				LOGGER.debug("--------------------------");
		return o;
	}
}
*/