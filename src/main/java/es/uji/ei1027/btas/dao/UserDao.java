package es.uji.ei1027.btas.dao;

import java.util.Collection;

import es.uji.ei1027.btas.model.UserDetails;

public interface UserDao {
	UserDetails loadUserByUsername(String username, String password);
 	Collection<UserDetails> listAllUsers();
}

