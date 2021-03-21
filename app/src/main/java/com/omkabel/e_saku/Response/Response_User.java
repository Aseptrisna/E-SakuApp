package com.omkabel.e_saku.Response;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.omkabel.e_saku.Model.Model_User;

import java.io.Serializable;

//@Generated("com.robohorse.robopojogenerator")
public class Response_User implements Serializable {

	@SerializedName("status")
	private boolean status;

	@SerializedName("user")
	private List<Model_User> user;

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	public void setUser(List<Model_User> user){
		this.user = user;
	}

	public List<Model_User> getUser(){
		return user;
	}

	@Override
 	public String toString(){
		return 
			"Response_User{" + 
			"status = '" + status + '\'' + 
			",user = '" + user + '\'' + 
			"}";
		}
}