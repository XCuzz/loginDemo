package com.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;



import com.entities.User;




public interface UserRepository extends Repository<User, Integer> {
	
	
     @Query("select u FROM User u where u.loginName=:loginName")
	 User findByLoginName(@Param("loginName") String loginName) ;
	
	

}
