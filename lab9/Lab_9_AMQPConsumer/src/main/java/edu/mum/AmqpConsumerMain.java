package edu.mum;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AmqpConsumerMain {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        new GenericXmlApplicationContext("classpath:META-INF/spring/item-app-context.xml");
    }
}
