package edu.mum.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

 import edu.mum.domain.UserCredentials;

@Component
public interface UserCredentialsRestService {

	public void save(UserCredentials userCredentials);
	//public UserCredentials update(UserCredentials userCredentials);
	public List<UserCredentials> findAll();
	public UserCredentials findByUserName(String userName);

}
