// Generated code from Butter Knife. Do not modify!
package id.co.imastudio.libawaydevsummit.Adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.co.imastudio.libawaydevsummit.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NavAdapter$ViewHolder_ViewBinding implements Unbinder {
  private NavAdapter.ViewHolder target;

  @UiThread
  public NavAdapter$ViewHolder_ViewBinding(NavAdapter.ViewHolder target, View source) {
    this.target = target;

    target.gambarmenu = Utils.findRequiredViewAsType(source, R.id.gambarmenu, "field 'gambarmenu'", ImageView.class);
    target.textmenu = Utils.findRequiredViewAsType(source, R.id.textmenu, "field 'textmenu'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    NavAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.gambarmenu = null;
    target.textmenu = null;
  }
}
