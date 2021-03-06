package com.inexture.UserFinalTaskBoot.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inexture.UserFinalTaskBoot.Beans.UserBean;


/**
 * User Dao Interface. Stores the methods list related to create, update, read, delete user's data from database table.
 * @author Yash
 *
 */
public interface DaoInterface extends JpaRepository<UserBean, Integer>{
	
	
	List<UserBean> findByType(String type);
	
	List<UserBean> findByEmail(String email);
	
	/**
	 * It returns user id from the table related to the email given, if no user found then returns 0.
	 * @param email - Stores email of user
	 * @return uid - User id from user database table<br>
	 * 		   0 - If no user is found with the given email
	 */
	@Query("select uid from UserBean where email=?1")
	Integer getUid(String email);
	
	/**
	 * This method checks if user is present in database table or not based on given email, password. 
	 * If User is present then it returns user bean object filled with all the details of user.
	 * Else it returns null.
	 * @param email - email of user
	 * @param password - encrypted password of user
	 * @return u - User bean object
	 * 		   null - if no user found in table
	 */
	@Query("from UserBean where email=?1 and password=?2")
	UserBean authUser(String email,String password);
	
	/**
	 * This method finds user based on given email, birthdate and security answers in forgot password.
	 * @param email - email address of user
	 * @param birthdate - birthdate of user
	 * @param ans1 - ans1 of user
	 * @param ans2 - ans2 of user
	 * @param ans3 - ans3 of user
	 * @return false - If user found in database table.<br>
	 * 		   true - If no user found with given information in database table.
	 */
	@Query("select uid from UserBean where email=?1 and birthdate=?2 and ans1=?3 and ans2=?4 and ans3=?5")
	Integer findUser(String email, String birthdate, String ans1, String ans2, String ans3);
	
}
