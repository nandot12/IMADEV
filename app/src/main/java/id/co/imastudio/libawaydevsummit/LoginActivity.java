package id.co.imastudio.libawaydevsummit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseApp implements GoogleApiClient.OnConnectionFailedListener {

    private static final int RC_SIGN_IN = 1;
    private static final String TAG = "lOGIN";
    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.textLogo)
    ImageView textLogo;
    @BindView(R.id.loginUsername)
    EditText loginUsername;
    @BindView(R.id.loginPassword)
    EditText loginPassword;
    @BindView(R.id.btnSignGmail)
    Button btnSignGmail;
    @BindView(R.id.idnForgotPass)
    ImageView idnForgotPass;
    @BindView(R.id.btnSignInGoogle)
    Button btnSignInGoogle;

    @BindView(R.id.linkSignUp)
    ImageView linkSignUp;
    GoogleApiClient mGoogleSignInClient;
    @BindView(R.id.login_button)
    LoginButton loginButton;
    @BindView(R.id.btnSignFb)
    Button btnSignFb;


    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginButton.setReadPermissions("email", "public_profile");

        //AppEventsLogger.activateApp(this);

        callbackManager = CallbackManager.Factory.create();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
             GraphRequest request = GraphRequest.newMeRequest(
                loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {

                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                Log.v("Main", object.toString());
                                setProfileToView(object);
                            }
                        });

                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender, birthday");
                request.setParameters(parameters);
                request.executeAsync();


            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
                Log.d("Error facebook ", error.toString());

            }
        });

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = new GoogleApiClient.Builder(c)
                .enableAutoManage(LoginActivity.this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        // updateUI(account);
    }

    private void setProfileToView(JSONObject object) {

        try {

          String name =  object.getString("name");
          String email = object.getString("email");
          sesi.setEmail(email);
          sesi.setNama(name);
          startActivity(new Intent(c,AuthNomorHp.class));

          Log.d("name facebook : " , name);
          Log.d("email facebook : " , email);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("Error object : " , e.getMessage());
        }
    }

    private void result(Profile profile) {

        sesi.createLoginSession("12");
        sesi.setNama(profile.getName());
        sesi.setEmail(profile.getMiddleName());
        startActivity(new Intent(c, AuthNomorHp.class));

    }

    @OnClick({R.id.btnSignGmail, R.id.idnForgotPass, R.id.btnSignInGoogle, R.id.linkSignUp,R.id.btnSignFb})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnSignGmail:
                view.startAnimation(AnimationUtils.loadAnimation(c, R.anim.klik));

                break;
            case R.id.idnForgotPass:
                view.startAnimation(AnimationUtils.loadAnimation(c, R.anim.klik));

                break;
            case R.id.btnSignInGoogle:
                view.startAnimation(AnimationUtils.loadAnimation(c, R.anim.klik));

                signIn();
                //WinnerHelper.pesan(c,"hello");
                break;

            case R.id.btnSignFb :
                view.startAnimation(AnimationUtils.loadAnimation(c, R.anim.klik));

                loginButton.performClick();

                break;

            case R.id.linkSignUp:
                view.startAnimation(AnimationUtils.loadAnimation(c, R.anim.klik));

                startActivity(new Intent(c, RegisterActivity.class));
                break;
        }
    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleSignInClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        } else {
            callbackManager.onActivityResult(requestCode, resultCode, data);

            Log.d("data facebook : ",data.toString());

        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            // updateUI(null);
        }
    }

    private void updateUI(GoogleSignInAccount account) {


        sesi.createLoginSession("12");
        sesi.setEmail(account.getEmail());
        sesi.setNama(account.getDisplayName());
        startActivity(new Intent(c, AuthNomorHp.class));
        finish();


    }

    @Override
    public void onStart() {
        super.onStart();

        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleSignInClient);
        if (opr.isDone()) {
//
//            Log.d(TAG, "Got cached sign-in");
//            GoogleSignInResult result = opr.get();
//            handleSignInResult(result);
//        } else {
//
//           // showProgressDialog();
//            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
//                @Override
//                public void onResult(GoogleSignInResult googleSignInResult) {
//                    //hideProgressDialog();
//                    handleSignInResult(googleSignInResult);
//                }
//            });
//        }
        }


    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


}
