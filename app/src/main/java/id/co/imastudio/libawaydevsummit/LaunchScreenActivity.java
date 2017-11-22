package id.co.imastudio.libawaydevsummit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LaunchScreenActivity extends BaseApp {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(c,LoginActivity.class));

                finish();
            }
        },5000);

    }
}
