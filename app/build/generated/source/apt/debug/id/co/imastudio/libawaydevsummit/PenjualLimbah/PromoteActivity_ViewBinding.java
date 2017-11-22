// Generated code from Butter Knife. Do not modify!
package id.co.imastudio.libawaydevsummit.PenjualLimbah;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.co.imastudio.libawaydevsummit.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PromoteActivity_ViewBinding implements Unbinder {
  private PromoteActivity target;

  @UiThread
  public PromoteActivity_ViewBinding(PromoteActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PromoteActivity_ViewBinding(PromoteActivity target, View source) {
    this.target = target;

    target.listProdusen = Utils.findRequiredViewAsType(source, R.id.listProdusen, "field 'listProdusen'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PromoteActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listProdusen = null;
  }
}
