package id.co.imastudio.libawaydevsummit.Http;

import id.co.imastudio.libawaydevsummit.ApiService.ApiService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nandoseptianhusni on 11/20/17.
 */

public class InstHttp {

    public static Retrofit getInstance(){

        return new Retrofit.Builder().baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static ApiService getInstanceRetrofit(){
        return getInstance().create(ApiService.class);

    }

}
