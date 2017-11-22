package id.co.imastudio.libawaydevsummit;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.co.imastudio.libawaydevsummit.ApiService.ApiService;
import id.co.imastudio.libawaydevsummit.Http.InstHttp;

public class AuthNomorHp extends BaseApp{

    @BindView(R.id.authName)
    EditText authName;
    @BindView(R.id.authEmail)
    EditText authEmail;
    @BindView(R.id.authHp)
    EditText authHp;
    @BindView(R.id.btnVerify)
    Button btnVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_nomor_hp);
        ButterKnife.bind(this);


        actionLogin();

        authName.setText(sesi.getNama());
        authEmail.setText(sesi.getEmail());



    }

    private void actionLogin() {

        ApiService api = InstHttp.getInstanceRetrofit();
       // retrofit2.Call<ResponseLogin> call = api.action_login(sesi.get)

    }

    @OnClick(R.id.btnVerify)
    public void onViewClicked() {




    }
}
