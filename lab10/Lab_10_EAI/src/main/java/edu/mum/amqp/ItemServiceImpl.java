package edu.mum.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.mum.domain.Item;

public class ItemServiceImpl implements ItemService {

	private static long itemId = 1;

	@Override
	public void publish(RabbitTemplate rabbitTemplate) {
		// TODO Auto-generated method stub
		Item item = new Item("Cracking the coding interview",
				"If you want to be Google's software engineer buy this! No matter high price has...", 35);
		item.setId(itemId++);
		item.setVersion(1);

		Item item2 = new Item("Brief history of human being", "RIP Stephen Hawking, by his memories...", 10);
		item2.setId(itemId++);
		item2.setVersion(1);

		rabbitTemplate.convertAndSend(item);
		rabbitTemplate.convertAndSend(item2);
	}

}
