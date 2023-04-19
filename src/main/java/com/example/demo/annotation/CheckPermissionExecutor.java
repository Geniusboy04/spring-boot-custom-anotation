package com.example.demo.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.ws.rs.ForbiddenException;

@Component
@Aspect
public class CheckPermissionExecutor {

    @Before(value = "@annotation(checkPermission)")
    public void checkPermission(CheckPermission checkPermission) {
        if (checkPermission.hasPermission()){
            System.out.println("You have permission !!");
        }else{
            throw new ForbiddenException("No such permission");
        }
    }
}
