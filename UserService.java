package com.cg.ofr.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.User;
import com.cg.ofr.exception.UserNotFoundException;
import com.cg.ofr.repository.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	private IUserRepository iuserRepository;
	
	public String addUser(User user) {
		iuserRepository.save(user);
		return "User added";	
		
	}
	
	public List<User> updateUser(Integer userId,String name) throws UserNotFoundException{
		if(!iuserRepository.existsById(userId)){
			throw new UserNotFoundException();
		}
		User user = iuserRepository.findById(userId).get();
	
		user.setUserName(name);
		iuserRepository.flush();
		return iuserRepository.findAll();
	}
	
	public List<User> updatePassword(Integer userId,String newpass) throws UserNotFoundException{
		if(!iuserRepository.existsById(userId)){
			throw new UserNotFoundException();
		}
		User user = iuserRepository.findById(userId).get();
	
		user.setPassword(newpass);
		iuserRepository.flush();
		return iuserRepository.findAll();
	}
	
	public User viewUser(int userId) throws UserNotFoundException{
		if(!iuserRepository.existsById(userId)) {
			throw new UserNotFoundException();
		}
		return iuserRepository.findById(userId).get();
		}

	public List<User> viewAllUser(){
		return iuserRepository.findAll();
	}
	
	public List<User> validateUser(String userName,String password) throws UserNotFoundException{
		if(!iuserRepository.equals(userName)) {
			throw new UserNotFoundException();
		}
		return iuserRepository.findAll();
	}
	
	
	  public List<User> removeUser(Integer userId) {
	  iuserRepository.deleteById(userId);
	  	return iuserRepository.findAll();
	  }
	 
	
	
	
}
	

/*
 * public User viewUser(int id) throws UserNotFoundException; public List<User>
 * viewAllUser(); public User validateUser(String username,String password)
 * throws UserNotFoundException; public User addUser(User user); public User
 * updateUser(User user); public User updatePassword(User user,String newpass);
 * public User removeUser(User user);
 */