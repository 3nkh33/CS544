package edu.mum.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.UserCredentials;
import edu.mum.rest.RestHttpHeader;
import edu.mum.rest.service.UserCredentialsRestService;

@Component
public class UserCredentialsRestServiceImpl implements UserCredentialsRestService {

	@Autowired
	RestHttpHeader restHelper;

	String baseUrl = "http://localhost:8080/User/userCredentials/";
	String baseUrlExtended = baseUrl + "/";

	public List<UserCredentials> findAll() {
		
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<UserCredentials[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, UserCredentials[].class);	
 		List<UserCredentials> userList = Arrays.asList(responseEntity.getBody());
		return userList;
	}

	public UserCredentials findByUserName(String userName) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
		ResponseEntity<UserCredentials> responseEntity = restTemplate.exchange(baseUrlExtended + userName, HttpMethod.GET, httpEntity, UserCredentials.class);
		UserCredentials userCredentials = responseEntity.getBody();
 		return userCredentials;
	}

	public void save(UserCredentials userCredentials) {
		RestTemplate restTemplate = restHelper.getRestTemplate();
		HttpEntity<UserCredentials> httpEntity = new HttpEntity<UserCredentials>(userCredentials, restHelper.getHttpHeaders());
		userCredentials = restTemplate.postForObject(baseUrl, httpEntity, UserCredentials.class);
	}

}
