package com.p1.service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p1.entity.User;
import com.p1.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo repo;
	
	// save one record
	
	public boolean userSave(String name,String email,String pwd) {
		
		User user = new User(name, email, pwd);
		
		User save = repo.save(user);
		
		if(save != null) {
			return true;
		}else {
			return false;
		}	
		
	}

	
	// save multipule record 
	
	public boolean AllUserSave() {
		
		User u1 = new User("dev", "dev@gmail.com", "dev@88900");
		User u2 = new User("nilu", "nilu@gmail.com", "nilu@88900");
		User u3 = new User("rahul", "rahul@gmail.com", "rahul@88900");
		User u4 = new User("aman", "aman@gmail.com", "aman@88900");
		User u5 = new User("som", "som@gmail.com", "som@88900");
		User u6 = new User("shahil", "shahil@gmail.com", "shahil@88900");
		User u7 = new User("sohan", "sohan@gmail.com", "sohan@88900");
		User u8 = new User("mahon", "mahon@gmail.com", "mohan@88900");
		
		List<User> asList = Arrays.asList(u1,u2,u3,u4,u5,u6,u7,u8);
		
		Iterable<User> saveAll = repo.saveAll(asList);
		
		if(saveAll != null) {
			System.out.println("save All User");
			return true;
		}else {
			System.out.println("not save All User record");
			return false;
		}	
	}


	// find By Id
	
	public Optional<User> findById(int id) {
		Optional<User> byId = repo.findById(id);
		return byId;
	}
	

	// find By id user
	
	public Iterable<User> findAllById(Integer ...id) {
		
	  List<Integer> asList = Arrays.asList(id);
		
		 Iterable<User> allById = repo.findAllById(asList);
		
	    	return allById;
	    }
	
	
	
	public Iterable<User> findAll() {
		Iterable<User> all = repo.findAll();
		return all;
	}

	
	public Long userCount() {
		long count = repo.count();
		return count;
	}


	
	public boolean userExistsById(int id) {
		boolean existsById = repo.existsById(id);
		return existsById;
	}


	
	public void userDeleteById(int id) {
		if(repo.existsById(id) == true) {
			repo.deleteById(id);
			System.out.println("id Delete..");
		}else {
			System.out.println("id not delete please curreact id");
		}
		
	}


	
	public String userDelete(Integer ...id) {
		
		 List<Integer> asList = Arrays.asList(id);
		
		 Iterator<Integer> iterator = asList.iterator();
		 
		 while(iterator.hasNext()) {
			 boolean existsById = repo.existsById(iterator.next());
			 if(existsById == false) {
				 return " Soory all id not match please entery curreact ids";
		 }}
		 
			repo.deleteAllById(asList);
			System.out.println("id Delete..");
		return " Delete All ids Data ";
		
	}


	
	public void AllUserDelete() {
		
		repo.deleteAll();	
	}

}
