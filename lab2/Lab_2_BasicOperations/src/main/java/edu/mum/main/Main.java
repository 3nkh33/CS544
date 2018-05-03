package edu.mum.main;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");

        UserService userDao = (UserService) context.getBean("userServiceImpl");

        User user = new User();
        user.setFirstName("aaa");
        user.setLastName("bbbb");
        user.setEmail("ccc");
        userDao.save(user);

        user = userDao.findByEmail("ccc");

        System.out.println();
        System.out.println("        *********  User **********");
        System.out.println("User Name: " + user.getFirstName() + " " + user.getLastName());

    }

}