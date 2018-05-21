package edu.mum.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.Item;
import edu.mum.rest.RemoteApi;

@Component
public class ItemRestService {

	@Autowired
	RemoteApi restHelper;
	
	public List<Item> findAll() {
		
		RestTemplate restTemplate = restHelper.getRestTemplate();
		return Arrays.asList(restTemplate.exchange("http://localhost:8080/JerseyRestSecurity/rest/products/", HttpMethod.GET, restHelper.getHttpEntity(), Item[].class).getBody());
	}

	public Item findOne(Integer index) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		return (restTemplate.exchange("http://localhost:8080/JerseyRestSecurity/rest/products/"+ index, HttpMethod.GET, restHelper.getHttpEntity(), Item.class).getBody());
	}

	public void save(Item item) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity<Member> httpEntity = new HttpEntity<Member>(item, restHelper.getHttpHeaders());
		ResponseEntity<Item> result = restTemplate.exchange("http://localhost:8080/JerseyRest/rest/products/", HttpMethod.POST, httpEntity, Item.class);
		return result.getBody();
	}

}
