package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class JpaDemoApplication {

	

	public static void main(String[] args) {
	ApplicationContext context=	SpringApplication.run(JpaDemoApplication.class, args);
UserRepository userRepository=	context.getBean(UserRepository.class);


User user =userRepository.findByUsername("virat");


System.out.println("---------------------find by username----------------------");
System.out.println("---------------"+user+"-------------------------------");
System.out.println("----------------------------------------------------------");


User user1 =userRepository.findByPassword("123456");


System.out.println("-------------------find by  password-------------------------");
System.out.println("---------------"+user1+"-------------------------------");
System.out.println("----------------------------------------------------------");

User user2 =userRepository.findByUsernameAndPassword("mahendra", "cooler");


System.out.println("-----------find by username and password--------------------");
System.out.println("---------------"+user2+"-------------------------------");
System.out.println("----------------------------------------------------------");


User user3 =userRepository.findByUsernameOrPassword("mahendraa", "cooler");


System.out.println("-----------find by username and password--------------------");
System.out.println("---------------"+user3+"-------------------------------");
System.out.println("----------------------------------------------------------");
	
	
	List<User> users =userRepository.findByUsernameStartingWith("ma");


	System.out.println("-----------find by starting with--------------------");
	System.out.println("---------------"+users+"-------------------------------");
	System.out.println("----------------------------------------------------------");
	
	List<User> users1 =userRepository.getAll();


	System.out.println("-----------jpql qeury @Query-------------------");
	System.out.println("---------------"+users1+"-------------------------------");
	System.out.println("----------------------------------------------------------");
	
	User user4 =userRepository.getById("nilesh");


	System.out.println("--------------jpql qeury @Query--------find by username----------------------");
	System.out.println("---------------"+user4+"-------------------------------");
	System.out.println("----------------------------------------------------------");

	List<User> users2 =userRepository.getAll();


	System.out.println("-----------native query @Query---nativeQuery=true----------------");
	System.out.println("---------------"+users2+"-------------------------------");
	System.out.println("----------------------------------------------------------");
	
	
Pageable pageable=	PageRequest.of(1, 3);

Page<User> users3 =  userRepository.findAll(pageable);


System.out.println("-----------Pageable----------------");
System.out.println("---------------"+users3+"-------------------------------");
System.out.println("----------------------------------------------------------");

	}
}
