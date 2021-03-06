package edu.mum.main;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("context/applicationContext.xml");

        UserService userService = (UserService) ctx.getBean("userServiceImpl");

        List<User> list = userService.findAll();
        System.out.println("User count: " + list.size());

        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john@yahoo.com");
        userService.save(user);
        System.out.println("User inserted!");

        list = userService.findAll();
        System.out.println("User count: " + list.size());

        User readUser = userService.findByEmail("john@yahoo.com");

        System.out.println();
        System.out.println("        *********  User **********");

        System.out.println("User Name: " + readUser.getFirstName() + " " + readUser.getLastName());

    }

}