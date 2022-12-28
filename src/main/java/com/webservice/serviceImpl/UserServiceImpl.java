package com.webservice.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.model.User;
import com.webservice.repository.UserRepository;
import com.webservice.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository ur;
	
	@Override
	public User saveUserInfo(User u) {
		
		return ur.save(u);
	}

	@Override
	public Iterable<User> getAllData() {
		
		return ur.findAll();
	}

	@Override
	public int updateData(User userdata, Integer uid) {

		Optional<User> userinfo= ur.findById(uid);
		if(userinfo.isPresent())
		{
			userdata.setUid(userinfo.get().getUid());
			userdata.getContactdetails().setContactid(userinfo.get().getContactdetails().getContactid());
			ur.save(userdata);
			return 1;
		}
		else return 0;
		
		
	}

	
}
