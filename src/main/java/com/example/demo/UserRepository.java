package com.example.demo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsername(String username);
	
	public User findByPassword(String password);
	
	public User findByUsernameAndPassword(String username,String password);
	
	public User findByUsernameOrPassword(String username,String password);
	
	public List<User> findByUsernameStartingWith(String preffix);
	
	@Query("select u from User u")
	public List<User> getAll();
	
	@Query("select u from User u where u.username=:n")
	public User getById(@Param("n")String username);
	
	@Query(value="select * from user" ,nativeQuery = true)
	public List<User> getAllUser();
	//--------------------------------------------------------
	
	
	public Page<User> findAll(Pageable  pageable);
	
	
	
	
	
	
}

