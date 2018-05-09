package edu.mum.dao.impl;

 

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;


@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super.setDaoType(User.class );
		}

 	public List<User> findAllJoinFetch() {
		  Query query =  entityManager.createQuery("SELECT u FROM User AS u JOIN FETCH u.boughtItems AS i");
		  return (List<User>) query.getResultList();

	}
 	
	public List<User> findAllBatch() {
		List<User> users =  (List<User>)this.findAll();
 		// hydrate since LAZY load - need to access ALL since we don't know batch Size
       	for (User user : users)
       		if (!user.getBoughtItems().isEmpty()) user.getBoughtItems().get(0);
			           
        return users;

}


 }