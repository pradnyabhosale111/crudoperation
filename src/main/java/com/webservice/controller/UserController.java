package com.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.model.User;
import com.webservice.response.BaseResponse;
import com.webservice.service.UserService;

@CrossOrigin("*")
@RestController
public class UserController {
	
	@Autowired
	UserService us;
	
	@PostMapping("/CreateUser")
	public ResponseEntity<BaseResponse<User>> saveUserData(@RequestBody User u)
	{
		User userinfo = us.saveUserInfo(u);
		
		BaseResponse base=new BaseResponse<User>(201,"User Info Saved", userinfo);
		
		return new ResponseEntity<BaseResponse<User>>(base, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/GetAllData")
	public ResponseEntity<BaseResponse<Iterable<User>>> getAllInfo()
	{
		Iterable<User> userlist= us.getAllData();
		
		BaseResponse base= new BaseResponse<Iterable<User>>(200,"This Is All user data", userlist); 
		
		return new ResponseEntity<BaseResponse<Iterable<User>>>(base, HttpStatus.OK); 
	}
	
	@PutMapping("/updateData/{id}")
	public String updateInfo(@RequestBody User userdata, @PathVariable("id") Integer uid)
	{
	int num= us.updateData(userdata,uid);
	if(num==1) {
		return "data updated";
	}
	else
	{
		return "Invalid id for user";
	}
		
		//BaseResponse base=new BaseResponse<Iterable<User>>(201,"Data Is successfully updated", userinfo);
		//return new ResponseEntity<BaseResponse<User>>(base, HttpStatus.CREATED);
		
		
	}

	
}
