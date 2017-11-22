package id.co.imastudio.libawaydevsummit.Model;

import com.google.gson.annotations.SerializedName;


public class Data{

	@SerializedName("user_status")
	private String userStatus;

	@SerializedName("user_nama")
	private String userNama;

	@SerializedName("user_email")
	private String userEmail;

	@SerializedName("user_password")
	private String userPassword;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("user_hp")
	private String userHp;

	@SerializedName("user_level")
	private String userLevel;

	@SerializedName("user_kebutuhan")
	private String userKebutuhan;

	public void setUserStatus(String userStatus){
		this.userStatus = userStatus;
	}

	public String getUserStatus(){
		return userStatus;
	}

	public void setUserNama(String userNama){
		this.userNama = userNama;
	}

	public String getUserNama(){
		return userNama;
	}

	public void setUserEmail(String userEmail){
		this.userEmail = userEmail;
	}

	public String getUserEmail(){
		return userEmail;
	}

	public void setUserPassword(String userPassword){
		this.userPassword = userPassword;
	}

	public String getUserPassword(){
		return userPassword;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setUserHp(String userHp){
		this.userHp = userHp;
	}

	public String getUserHp(){
		return userHp;
	}

	public void setUserLevel(String userLevel){
		this.userLevel = userLevel;
	}

	public String getUserLevel(){
		return userLevel;
	}

	public void setUserKebutuhan(String userKebutuhan){
		this.userKebutuhan = userKebutuhan;
	}

	public String getUserKebutuhan(){
		return userKebutuhan;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"user_status = '" + userStatus + '\'' + 
			",user_nama = '" + userNama + '\'' + 
			",user_email = '" + userEmail + '\'' + 
			",user_password = '" + userPassword + '\'' + 
			",user_id = '" + userId + '\'' + 
			",user_hp = '" + userHp + '\'' + 
			",user_level = '" + userLevel + '\'' + 
			",user_kebutuhan = '" + userKebutuhan + '\'' + 
			"}";
		}
}