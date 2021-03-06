package nl.workingtalentapp.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import nl.workingtalentapp.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingtalentapp.library.domein.User;

@Service
public class UserService {
	
	 private final UserRepository userRepository;
	 
	private static List<User> users = new ArrayList<>();
	private static long idCounter = 0;
	
	
	 @Autowired
	    public UserService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }
	
	 public List<User> findStaticUsers(){
		 return users;
	 }
	 
	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}
	
    public User updateUser(User user) {
        return userRepository.save(user);
    }
	
//	public User deleteById(long id) {
//		User user = findById(id);
//		
//		if(user==null) return null;
//		
//		if(users.remove(user)) {
//			return user;
//		}
//		
//		return null;
//	}
//	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public User findById(long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			return user;
		}
		else {
			return null;
		}
//		for(User user:users) {
//			System.out.println(id);
//			if(user.getId() == id) {
//				return user;
//			}
//		}
//		
//		return null;
	}
	
	public User findByUsername(String username) {
		for(User user:users) {
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		
		return null;
	}
	
	
}
