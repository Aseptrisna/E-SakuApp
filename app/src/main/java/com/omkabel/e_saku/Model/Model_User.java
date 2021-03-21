package com.omkabel.e_saku.Model;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

//@Generated("com.robohorse.robopojogenerator")
public class Model_User implements Serializable {

	@SerializedName("id")
	private String id;

	@SerializedName("email")
	private String email;

	@SerializedName("nama")
	private String nama;

	@SerializedName("telpon")
	private String telpon;

	@SerializedName("password")
	private String password;

	@SerializedName("latitude")
	private String latitude;

	@SerializedName("longitude")
	private String longitude;

	@SerializedName("level")
	private String level;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setTelpon(String telpon){
		this.telpon = telpon;
	}

	public String getTelpon(){
		return telpon;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setLatitude(String latitude){
		this.latitude = latitude;
	}

	public String getLatitude(){
		return latitude;
	}

	public void setLongitude(String longitude){
		this.longitude = longitude;
	}

	public String getLongitude(){
		return longitude;
	}

	public void setLevel(String level){
		this.level = level;
	}

	public String getLevel(){
		return level;
	}

	@Override
 	public String toString(){
		return 
			"Model_User{" + 
			"id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			",nama = '" + nama + '\'' + 
			",telpon = '" + telpon + '\'' + 
			",password = '" + password + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",longitude = '" + longitude + '\'' + 
			",level = '" + level + '\'' + 
			"}";
		}
}