package edu.mum.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import edu.mum.domain.Item;
import edu.mum.rest.service.ItemRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.rest.RestHttpHeader;

@Component
public class ItemRestServiceImpl implements ItemRestService {

	@Autowired
	RestHttpHeader restHelper;

	String baseUrl = "http://localhost:8080/ItemRest/items";
	String baseUrlExtended = baseUrl + "/";

	public List<Item> findAll() {
		
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<Item[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, Item[].class);
 		List<Item> itemList = Arrays.asList(responseEntity.getBody());
		return itemList;
	}

	public Item findOne(Long id) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<Item> responseEntity = restTemplate.exchange(baseUrlExtended + id, HttpMethod.GET, httpEntity, Item.class);
		Item item = responseEntity.getBody();
 		return item;
	}

	public void save(Item member) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity<Item> httpEntity = new HttpEntity<Item>(member, restHelper.getHttpHeaders());
		member = restTemplate.postForObject(baseUrl, httpEntity, Item.class);
	}

}
