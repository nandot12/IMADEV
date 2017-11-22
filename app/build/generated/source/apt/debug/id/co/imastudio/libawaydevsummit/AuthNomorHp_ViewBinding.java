// Generated code from Butter Knife. Do not modify!
package id.co.imastudio.libawaydevsummit;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AuthNomorHp_ViewBinding implements Unbinder {
  private AuthNomorHp target;

  private View view2131296305;

  @UiThread
  public AuthNomorHp_ViewBinding(AuthNomorHp target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AuthNomorHp_ViewBinding(final AuthNomorHp target, View source) {
    this.target = target;

    View view;
    target.authName = Utils.findRequiredViewAsType(source, R.id.authName, "field 'authName'", EditText.class);
    target.authEmail = Utils.findRequiredViewAsType(source, R.id.authEmail, "field 'authEmail'", EditText.class);
    target.authHp = Utils.findRequiredViewAsType(source, R.id.authHp, "field 'authHp'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btnVerify, "field 'btnVerify' and method 'onViewClicked'");
    target.btnVerify = Utils.castView(view, R.id.btnVerify, "field 'btnVerify'", Button.class);
    view2131296305 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    AuthNomorHp target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.authName = null;
    target.authEmail = null;
    target.authHp = null;
    target.btnVerify = null;

    view2131296305.setOnClickListener(null);
    view2131296305 = null;
  }
}
