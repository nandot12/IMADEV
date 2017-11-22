package id.co.imastudio.libawaydevsummit;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AnimationUtils;

import id.co.imastudio.libawaydevsummit.Helper.SessionManager;

public class BaseApp extends AppCompatActivity {

    protected Context c ;
    protected SessionManager sesi ;
   protected AnimationUtils animationUtils = new AnimationUtils();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        c = this ;
        sesi = new SessionManager(c);



    }
}
