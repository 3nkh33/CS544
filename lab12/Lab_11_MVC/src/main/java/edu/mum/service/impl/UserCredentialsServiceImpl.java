package edu.mum.service.impl;

import java.util.List;

import edu.mum.rest.service.UserCredentialsRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.GenericDao;
import edu.mum.dao.UserCredentialsDao;
import edu.mum.domain.UserCredentials;
import edu.mum.domain.UserCredentials;

@Service
@Transactional
public class UserCredentialsServiceImpl implements edu.mum.service.UserCredentialsService {

    /*@Autowired
   private UserCredentialsDao userCredentialsDao;


    public void save( UserCredentials userCredentials) {
         userCredentialsDao.save(userCredentials);
    }


   public List<UserCredentials> findAll() {
       return (List<UserCredentials>)userCredentialsDao.findAll();
   }

   public UserCredentials findByUserName(String userName) {
       return userCredentialsDao.findByUserName(userName);
   }


   @Override
   public UserCredentials update(UserCredentials userCredentials) {
       return userCredentialsDao.update(userCredentials);

   }*/
    @Autowired
    private UserCredentialsRestService userCredentialsRestService;
    private UserCredentials userCredentials = new UserCredentials();

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }


    public void save(UserCredentials userCredentials) {
        userCredentialsRestService.save(userCredentials);
    }


    public List<UserCredentials> findAll() {
        return (List<UserCredentials>) userCredentialsRestService.findAll();
    }

    public UserCredentials findByUserName(String userName) {
        this.userCredentials = userCredentialsRestService.findByUserName(userName);
        return this.userCredentials;
    }

}
