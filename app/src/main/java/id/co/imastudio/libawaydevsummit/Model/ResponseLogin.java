package id.co.imastudio.libawaydevsummit.Model;

import com.google.gson.annotations.SerializedName;


public class ResponseLogin{

	@SerializedName("result")
	private String result;

	@SerializedName("msg")
	private String msg;

	@SerializedName("idUser")
	private String idUser;

	@SerializedName("data")
	private Data data;

	public void setResult(String result){
		this.result = result;
	}

	public String getResult(){
		return result;
	}

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"ResponseLogin{" + 
			"result = '" + result + '\'' + 
			",msg = '" + msg + '\'' + 
			",idUser = '" + idUser + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}