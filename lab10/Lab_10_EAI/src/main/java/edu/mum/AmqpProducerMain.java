package edu.mum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.amqp.ItemService;
import edu.mum.amqp.ItemServiceImpl;

public class AmqpProducerMain {
	private final static String[] configFilesGatewayDemo = {
			"/META-INF/spring/rabbit-auction-app-context.xml",
	 		"/META-INF/spring/jms-bid-app-context.xml",
			"/META-INF/spring/auctionGateway.xml"
		};
	
    public static void main(String[] args) {
    	ApplicationContext context = new ClassPathXmlApplicationContext(configFilesGatewayDemo, AmqpProducerMain.class);
	    //applicationContext.getBean(AmqpProducerMain.class).mainInternal(applicationContext);
    	
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("**********************************::   ");
        System.out.println("Type 'quit' to quit");
        System.out.println("**********************************::   ");
        System.out.println("Hit 'Enter' to send another >>> ");
        String input;
        try {
        	while(!(input = in.readLine()).equalsIgnoreCase("quit")) {
        		
				//Publish item
		        RabbitTemplate itemTemplate = context.getBean("itemTemplate", RabbitTemplate.class);
		        ItemService itemService = new ItemServiceImpl();
		        itemService.publish(itemTemplate);
		        System.out.println("Hit 'Enter' to send another >>> ");
        	}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
//    private void mainInternal(ApplicationContext applicationContext) {
//		// Wait for Messages
//    }
}
