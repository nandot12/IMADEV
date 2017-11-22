package id.co.imastudio.libawaydevsummit.Helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by imastudio on 2/9/16.
 */
public class SessionManager {
	private static final String KEY_TOKEN = "tokenLogin";
	private static final String KEY_LOGIN = "isLogin";
	SharedPreferences pref;
	SharedPreferences.Editor editor;

	int PRIVATE_MODE =0;    Context c;

	//0 agar cuma bsa dibaca hp itu sendiri
	String PREF_NAME="GojegClonePref";

	//konstruktor
	public SessionManager(Context c){
		this.c = c;
		pref = c.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
		editor = pref.edit();
	}
	//membuat session login
	public void createLoginSession(String token){
		editor.putString(KEY_TOKEN, token);
		editor.putBoolean(KEY_LOGIN, true);
		editor.commit();
		//commit digunakan untuk menyimpan perubahan
	}
	//mendapatkan token
	public String getToken(){
		return pref.getString(KEY_TOKEN, "");
	}
	//cek login
	public boolean isLoggedIn(){
		return pref.getBoolean(KEY_LOGIN, false);
	}
	//logout user
	public void logout(){
		editor.clear();
		editor.commit();
	}
	public String getIdLevel() {
		return pref.getString("idLevel", "");
	}

	public void setIdLevel(String v) {
		editor.putString("idLevel", v);
		editor.commit();
	}

	public void setNama(String nama){
		editor.putString("nama", nama);
		editor.commit();
	}
	public String getNama(){
		return pref.getString("nama", "");
	}
	public void setEmail(String email){
		editor.putString("email", email);
		editor.commit();
	}
	public String getEmail(){
		return pref.getString("email", "");
	}
	public void setHp(String phone){
		editor.putString("phone", phone);
		editor.commit();
	}
	public String getHp(){
		return pref.getString("phone", "");
	}
	public void setIDUser(String id_user){
		editor.putString("id_user", id_user);
		editor.commit();
	}
	public String getIDUser(){
		return pref.getString("id_user", "");
	}
	public String getAvatar() {
		return pref.getString("avatar", "");
	}

	public void setAvatar(String v) {
		editor.putString("avatar", v);
		editor.commit();
	}

	public void setIRestoran(String restoran){
		editor.putString("id_restoran", restoran);
		editor.commit();
	}
	public String getIRestoran(){
		return pref.getString("id_restoran", "");
	}
	public void setTopUp(String topUp){
		editor.putString("topup", topUp);
		editor.commit();
	}
	public String getTopUp(){
		return pref.getString("topup", "");
	}


}
