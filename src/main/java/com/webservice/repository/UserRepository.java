package com.webservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.webservice.model.User;

public interface UserRepository extends CrudRepository<User,Integer>{

}
