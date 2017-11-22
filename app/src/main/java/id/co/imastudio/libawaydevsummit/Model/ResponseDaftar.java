package id.co.imastudio.libawaydevsummit.Model;

import com.google.gson.annotations.SerializedName;


public class ResponseDaftar{

	@SerializedName("result")
	private String result;

	@SerializedName("msg")
	private String msg;

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

	@Override
 	public String toString(){
		return 
			"ResponseDaftar{" + 
			"result = '" + result + '\'' + 
			",msg = '" + msg + '\'' + 
			"}";
		}
}