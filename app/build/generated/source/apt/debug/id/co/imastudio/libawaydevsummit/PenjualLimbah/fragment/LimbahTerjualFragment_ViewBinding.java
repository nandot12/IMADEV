// Generated code from Butter Knife. Do not modify!
package id.co.imastudio.libawaydevsummit.PenjualLimbah.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.co.imastudio.libawaydevsummit.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LimbahTerjualFragment_ViewBinding implements Unbinder {
  private LimbahTerjualFragment target;

  @UiThread
  public LimbahTerjualFragment_ViewBinding(LimbahTerjualFragment target, View source) {
    this.target = target;

    target.listLimbahKu = Utils.findRequiredViewAsType(source, R.id.listLimbahKu, "field 'listLimbahKu'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LimbahTerjualFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listLimbahKu = null;
  }
}
