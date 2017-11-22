package id.co.imastudio.libawaydevsummit.ApiService;

import id.co.imastudio.libawaydevsummit.Model.ResponseDaftar;
import id.co.imastudio.libawaydevsummit.Model.ResponseLogin;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by nandoseptianhusni on 11/22/17.
 */

public interface ApiService {

    @POST("daftar")
    Call<ResponseDaftar> action_daftar(
            @Field("email") String email,
            @Field("password") String password,
            @Field("nama") String nama,
            @Field("phone") String hp,
            @Field("limbah") String limbah

    );

    @POST("login")
    Call<ResponseLogin> action_login(
            @Field("email") String email,
            @Field("password")String password
    );


}


