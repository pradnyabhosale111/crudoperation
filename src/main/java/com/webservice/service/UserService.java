package com.webservice.service;



import com.webservice.model.User;


public interface UserService {
	
	public User saveUserInfo(User u);

	public Iterable<User> getAllData();

	public int updateData(User userdata, Integer uid);

}
