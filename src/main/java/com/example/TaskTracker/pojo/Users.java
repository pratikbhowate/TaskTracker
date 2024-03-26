package com.example.TaskTracker.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Users {
	
	@Document(collection = "TodoUsers")
	public class User {
	    @Id
	    private String id;
	    private String username;
	    private String password;
		
	    public User() {
			
		}
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

		public static Object withDefaultPasswordEncoder() {
			// TODO Auto-generated method stub
			return null;
		}
	    
	}

}
