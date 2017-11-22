// Generated code from Butter Knife. Do not modify!
package id.co.imastudio.libawaydevsummit;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.facebook.login.widget.LoginButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view2131296301;

  private View view2131296370;

  private View view2131296302;

  private View view2131296390;

  private View view2131296300;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    target.logo = Utils.findRequiredViewAsType(source, R.id.logo, "field 'logo'", ImageView.class);
    target.textLogo = Utils.findRequiredViewAsType(source, R.id.textLogo, "field 'textLogo'", ImageView.class);
    target.loginUsername = Utils.findRequiredViewAsType(source, R.id.loginUsername, "field 'loginUsername'", EditText.class);
    target.loginPassword = Utils.findRequiredViewAsType(source, R.id.loginPassword, "field 'loginPassword'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btnSignGmail, "field 'btnSignGmail' and method 'onViewClicked'");
    target.btnSignGmail = Utils.castView(view, R.id.btnSignGmail, "field 'btnSignGmail'", Button.class);
    view2131296301 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.idnForgotPass, "field 'idnForgotPass' and method 'onViewClicked'");
    target.idnForgotPass = Utils.castView(view, R.id.idnForgotPass, "field 'idnForgotPass'", ImageView.class);
    view2131296370 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btnSignInGoogle, "field 'btnSignInGoogle' and method 'onViewClicked'");
    target.btnSignInGoogle = Utils.castView(view, R.id.btnSignInGoogle, "field 'btnSignInGoogle'", Button.class);
    view2131296302 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.linkSignUp, "field 'linkSignUp' and method 'onViewClicked'");
    target.linkSignUp = Utils.castView(view, R.id.linkSignUp, "field 'linkSignUp'", ImageView.class);
    view2131296390 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.loginButton = Utils.findRequiredViewAsType(source, R.id.login_button, "field 'loginButton'", LoginButton.class);
    view = Utils.findRequiredView(source, R.id.btnSignFb, "field 'btnSignFb' and method 'onViewClicked'");
    target.btnSignFb = Utils.castView(view, R.id.btnSignFb, "field 'btnSignFb'", Button.class);
    view2131296300 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.logo = null;
    target.textLogo = null;
    target.loginUsername = null;
    target.loginPassword = null;
    target.btnSignGmail = null;
    target.idnForgotPass = null;
    target.btnSignInGoogle = null;
    target.linkSignUp = null;
    target.loginButton = null;
    target.btnSignFb = null;

    view2131296301.setOnClickListener(null);
    view2131296301 = null;
    view2131296370.setOnClickListener(null);
    view2131296370 = null;
    view2131296302.setOnClickListener(null);
    view2131296302 = null;
    view2131296390.setOnClickListener(null);
    view2131296390 = null;
    view2131296300.setOnClickListener(null);
    view2131296300 = null;
  }
}
