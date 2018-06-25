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
       
       UserDetails userCCD = new UserDetails(); 
       userCCD.setUsername("ccd"); 
       userCCD.setPassword(passwordEncryptor.encryptPassword("ccd")); 
       knownUsers.put("ccd", userCCD);
       
       UserDetails userEmpresa = new UserDetails(); 
       userEmpresa.setUsername("A207327737"); 
       userEmpresa.setPassword(passwordEncryptor.encryptPassword("A207327737")); 
       knownUsers.put("A207327737", userEmpresa);
       
       UserDetails userEmpresa2 = new UserDetails(); 
       userEmpresa2.setUsername("A11111111"); 
       userEmpresa2.setPassword(passwordEncryptor.encryptPassword("A11111111")); 
       knownUsers.put("A11111111", userEmpresa2);
       
       UserDetails userEmpresa3 = new UserDetails(); 
       userEmpresa3.setUsername("A22222222"); 
       userEmpresa3.setPassword(passwordEncryptor.encryptPassword("A22222222")); 
       knownUsers.put("A22222222", userEmpresa3);
       
       UserDetails userEmpresa4 = new UserDetails(); 
       userEmpresa4.setUsername("A33333333"); 
       userEmpresa4.setPassword(passwordEncryptor.encryptPassword("A33333333")); 
       knownUsers.put("A33333333", userEmpresa4);
       
       
       UserDetails userTutor = new UserDetails(); 
       userTutor.setUsername("5678"); 
       userTutor.setPassword(passwordEncryptor.encryptPassword("5678")); 
       knownUsers.put("5678", userTutor);
       
       UserDetails userTutor2 = new UserDetails(); 
       userTutor2.setUsername("12345678T"); 
       userTutor2.setPassword(passwordEncryptor.encryptPassword("12345678T")); 
       knownUsers.put("12345678T", userTutor2);
       
       UserDetails userTutor3 = new UserDetails(); 
       userTutor3.setUsername("12345676T"); 
       userTutor3.setPassword(passwordEncryptor.encryptPassword("12345676T")); 
       knownUsers.put("12345676T", userTutor3);
       
       UserDetails userTutor4 = new UserDetails(); 
       userTutor4.setUsername("22345676T"); 
       userTutor4.setPassword(passwordEncryptor.encryptPassword("22345676T")); 
       knownUsers.put("22345676T", userTutor4);
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
