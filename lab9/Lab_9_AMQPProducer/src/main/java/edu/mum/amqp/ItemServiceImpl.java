package edu.mum.amqp;

import edu.mum.domain.Item;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class ItemServiceImpl implements ItemService {
    @Override
    public void publish(RabbitTemplate rabbitTemplate) {
        // TODO Auto-generated method stub
        Item item1 = new Item("Kazoo", "No idea what is it...");
        Item item2 = new Item("Hammer", "Don't hurt me");

        rabbitTemplate.convertAndSend(item1);
        rabbitTemplate.convertAndSend(item2);
    }

}
