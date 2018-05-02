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
        userDao.insert(user);

        vehicle = vehicleDao.findByVehicleNo("TEM0001");

        System.out.println();
        System.out.println("        *********  VEHICLE **********");
        System.out.println("Vehicle No: " + vehicle.getVehicleNo());
        System.out.println("Color: " + vehicle.getColor());
        System.out.println("Wheel: " + vehicle.getWheel());
        System.out.println("Seat: " + vehicle.getSeat());

    }

}