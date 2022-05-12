package com.inexture.Beans;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * User Bean stores the all of the information filled by user
 * @author Yash
 *
 */
@Entity
@Table(name = "users")
@Component
@Scope("prototype")
public class UserBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Store user id from user database table
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;
	
	/**
	 * Stores first name of user
	 */
	@Column(name="firstname")
	@NotEmpty(message = "Firstname is required.")
//	@Pattern(regexp = "[a-zA-Z]+",message = "Firstname should not contain numbers.")
	private String fname;
	
	/**
	 * Stores last name of user
	 */
	@Column(name="lastname")
	@NotEmpty(message = "Lastname is required.")
//	@Pattern(regexp = "[a-zA-Z]+",message = "Lastname should not contain numbers.")
	private String lname;
	
	/**
	 * Stores email of user
	 */
	@NotEmpty(message = "Email is required.")
	@Email(message = "Email is not valid.")
	private String email;
	
	/**
	 * Stores phone number of user
	 */
//	@NotEmpty(message = "Phone is required.")
	private long phone;
	
	/**
	 * Stores password of user
	 */
	private String password;
	
	/**
	 * Stores gender of user
	 */
	@NotEmpty(message = "Gender is required.")
	private String gender;
	
	/**
	 * Stores birthdate of user
	 */
	@NotEmpty(message = "Birthdate is required.")
	private String birthdate;
	
	/**
	 * Stores hobbies of user 
	 */
	@NotEmpty(message = "Hobby is required.")
	private String hobby;
	
	/**
	 * Stores security question1's answer of user
	 */
	@Column(name="ans1")
	@NotEmpty(message = "Ans1 is required.")
	private String que1;
	
	/**
	 * Stores security question2's answer of user
	 */
	@Column(name="ans2")
	@NotEmpty(message = "Ans2 is required.")
	private String que2;
	
	/**
	 * Stores security question3's answer of user
	 */
	@Column(name="ans3")
	@NotEmpty(message = "Ans3 is required.")
	private String que3;
	
	/**
	 * Stores all addresses of user in arraylist
	 */
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Valid
	private List<AddressBean> address;
	
	/**
	 * Stores image's byte array for storing in table
	 */
	@Lob
	private byte[] image;
	
	/**
	 * Stores profile pic's inputstream of user
	 */
	@Transient
	private InputStream inputStream;
	
	/**
	 * Stores base64image of profile pic
	 */
	@Transient
	private String base64Image;
	
	/**
	 * Stores type of user. Exa. user, admin.
	 */
	private String type;
	
	/**
	 * Default Constructor of User bean
	 */
	public UserBean() {}
	
	/**
	 * Constructor of User bean
	 * @param fname - Stores first name of user
	 * @param lname - Stores last name of user
	 * @param email - Stores email of user
	 * @param phone - Stores phone number of user
	 * @param password - Stores password of user
	 * @param gender - Stores gender of user
	 * @param birthdate - Stores birthdate of user
	 * @param hobby - Stores hobbies of user 
	 * @param que1 - Stores security question1's answer of user
	 * @param que2 - Stores security question2's answer of user
	 * @param que3 - Stores security question3's answer of user
	 * @param address - Stores all addresses of user in arraylist
	 * @param inputStream - Stores profile pic's inputstream of user
	 */
	public UserBean(String fname,String lname,String email,long phone,String password,String gender,String birthdate,String hobby,String que1,String que2,String que3,List<AddressBean> address,InputStream inputStream){
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.gender = gender;
		this.birthdate = birthdate;
		this.hobby = hobby;
		this.que1 = que1;
		this.que2 = que2;
		this.que3 = que3;
		this.address = new ArrayList<AddressBean>(address);
		this.inputStream = inputStream;
	}
	
	/**
	 * Constructor of User bean
	 * @param email - Stores email of user
	 */
	public UserBean(String email) {
		this.email = email;
	}
	
	/**
	 * Constructor of User bean
	 * @param email - Stores email of user
	 * @param password - Stores password of user
	 */
	public UserBean(String email,String password) {
		this.email = email;
		this.password = password;
	}
	
	/**
	 * Constructor of User bean
	 * @param uid - Store user id from user database table
	 * @param fname - Stores first name of user
	 * @param lname - Stores last name of user
	 * @param email - Stores email of user
	 * @param phone - Stores phone number of user
	 * @param gender - Stores gender of user
	 * @param birthdate - Stores birthdate of user
	 * @param hobby - Stores hobbies of user 
	 */
	public UserBean(int uid,String fname,String lname,String email,long phone,String gender,String birthdate,String hobby){
		this.uid = uid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.birthdate = birthdate;
		this.hobby = hobby;
	}
	
	/**
	 * Constructor of User bean
	 * @param email - Stores email of user
	 * @param birthdate - Stores birthdate of user
	 * @param que1 - Stores security question1's answer of user
	 * @param que2 - Stores security question2's answer of user
	 * @param que3 - Stores security question3's answer of user
	 */
	public UserBean(String email,String birthdate,String que1,String que2,String que3) {
		this.email = email;
		this.birthdate = birthdate;
		this.que1 = que1;
		this.que2 = que2;
		this.que3 = que3;
	}
	
	/** 
	 * Setter method of user id of user bean
	 * @param uid - Store user id from user database table
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	/**
	 * Setter method of first name of user bean
	 * @param fname - Stores first name of user
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	/**
	 * Setter method of first name of user bean
	 * @param lname - Stores last name of user
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	/**
	 * Setter method of email of user bean
	 * @param email - Stores email of user
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Setter method of phone of user bean
	 * @param phone - Stores phone number of user
	 */
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	/**
	 * Setter method of password of user bean
	 * @param password - Stores password of user
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Setter method of gender of user bean
	 * @param gender - Stores gender of user
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * Setter method of birthdate of user bean
	 * @param birthdate - Stores birthdate of user
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	/**
	 * Setter method of hobby of user bean
	 * @param hobby - Stores hobbies of user 
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	/**
	 * Setter method of security answer1 of user bean
	 * @param que1 - Stores security question1's answer of user
	 */
	public void setQue1(String que1) {
		this.que1 = que1;
	}
	
	/**
	 * Setter method of security answer2 of user bean
	 * @param que2 - Stores security question2's answer of user
	 */
	public void setQue2(String que2) {
		this.que2 = que2;
	}
	
	/**
	 * Setter method of security answer3 of user bean
	 * @param que3 - Stores security question3's answer of user
	 */
	public void setQue3(String que3) {
		this.que3 = que3;
	}
	
	/**
	 * Setter method of address list of user bean
	 * @param address - Stores all addresses of user in arraylist
	 */
	public void setAddress(List<AddressBean> address) {
		this.address = new ArrayList<AddressBean>(address);
	}
	
	/**
	 * Setter method of profile pic's input stream of user bean
	 * @param inputStream - Stores profile pic's inputstream of user
	 */
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	/**
	 * Setter method of base64image of profile pic of user bean
	 * @param base64Image - Stores base64image of profile pic
	 */
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	
	/**
	 * Setter method of type of user in user bean
	 * @param type - Stores type of user. Exa. user, admin.
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
	/**
	 * Getter method of user id of user bean
	 * @return uid - Store user id from user database table
	 */
	public int getUid() {
		return this.uid;
	}
	
	/**
	 * Getter method of first name of user bean
	 * @return fname - Stores first name of user
	 */
	public String getFname() {
		return this.fname;
	}
	
	/**
	 * Getter method of last name of user bean
	 * @return lname - Stores last name of user
	 */
	public String getLname() {
		return this.lname;
	}
	
	/**
	 * Getter method of email of user bean
	 * @return email - Stores email of user
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Getter method of phone of user bean
	 * @return phone - Stores phone number of user
	 */
	public long getPhone() {
		return this.phone;
	}
	
	/**
	 * Getter method of password of user bean
	 * @return password - Stores password of user
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Getter method of gender of user bean
	 * @return gender - Stores gender of user
	 */
	public String getGender() {
		return this.gender;
	}
	
	/**
	 * Getter method of birthdate of user bean
	 * @return birthdate - Stores birthdate of user
	 */
	public String getBirthdate() {
		return this.birthdate;
	}
	
	/**
	 * Getter method of hobby of user bean
	 * @return hobby - Stores hobbies of user 
	 */
	public String getHobby() {
		return this.hobby ;
	}
	
	/**
	 * Getter method of security answer1 of user bean
	 * @return que1 - Stores security question1's answer of user
	 */
	public String getQue1() {
		return this.que1;
	}
	
	/**
	 * Getter method of security answer2 of user bean
	 * @return que2 - Stores security question2's answer of user
	 */
	public String getQue2() {
		return this.que2;
	}
	
	/**
	 * Getter method of security answer3 of user bean
	 * @return que3 - Stores security question3's answer of user
	 */
	public String getQue3() {
		return this.que3;
	}
	
	/**
	 * Getter method of address list of user bean
	 * @return address - Stores all addresses of user in arraylist
	 */
	public List<AddressBean> getAddress() {
		return this.address;
	}
	
	/**
	 * Getter method of profile pic's input stream of user bean
	 * @return inputStream - Stores profile pic's inputstream of user
	 */
	public InputStream getInputStream() {
		return this.inputStream;
	}
	
	/**
	 * Getter method of profile pic's base64image in user bean
	 * @return base64Image - Stores base64image of profile pic
	 */
	public String getBase64Image() {
		return this.base64Image;
	}
	
	/**
	 * Getter method of type of user in user bean
	 * @return type - Stores type of user. Exa. user, admin.
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Getter method of image of user in user bean
	 * @return image - Stores image's byte array for storing in table
	 */
	public byte[] getImage() {
		return image;
	}
	
	/**
	 * Setter method of image of user in user bean
	 * @param image - Stores image's byte array for storing in table
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}
	
}
