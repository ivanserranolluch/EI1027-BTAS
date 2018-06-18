package es.uji.ei1027.btas.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.jasypt.util.password.BasicPasswordEncryptor; 

import es.uji.ei1027.btas.model.UserDetails;

@Repository
public class FakeUserProvider implements UserDao {
  final Map<String, UserDetails> knownUsers = new HashMap<String, UserDetails>();

  public FakeUserProvider() {
	BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor(); 
	UserDetails userAlice = new UserDetails(); 
	userAlice.setUsername("alice"); 
	userAlice.setPassword(passwordEncryptor.encryptPassword("alice")); 
	knownUsers.put("alice", userAlice);
	  
       UserDetails userBob = new UserDetails(); 
       userBob.setUsername("53728161T"); 
       userBob.setPassword(passwordEncryptor.encryptPassword("53728161T")); 
       knownUsers.put("53728161T", userBob);
       
       UserDetails userCCT = new UserDetails(); 
       userCCT.setUsername("cct"); 
       userCCT.setPassword(passwordEncryptor.encryptPassword("cct")); 
       knownUsers.put("cct", userCCT);
  }

  @Override
  public UserDetails loadUserByUsername(String username, String password) { 
	  UserDetails user = knownUsers.get(username.trim());
	  if (user == null) {
		  System.out.println("cact");
		  return null;} // Usuari no trobat
	  // Contrasenya
	 BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor(); 
	 if (passwordEncryptor.checkPassword(password, user.getPassword())) {
	 // Es deuria esborrar de manera segura el camp password abans de tornar-lo
		 return user; 
        } 
	 else {
		 return null; // bad login!
	 }
  }

  @Override 
  public Collection<UserDetails> listAllUsers() {
	 return knownUsers.values();
  }
}
