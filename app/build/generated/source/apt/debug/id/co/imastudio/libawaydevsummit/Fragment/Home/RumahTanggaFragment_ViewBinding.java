// Generated code from Butter Knife. Do not modify!
package id.co.imastudio.libawaydevsummit.Fragment.Home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.co.imastudio.libawaydevsummit.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RumahTanggaFragment_ViewBinding implements Unbinder {
  private RumahTanggaFragment target;

  @UiThread
  public RumahTanggaFragment_ViewBinding(RumahTanggaFragment target, View source) {
    this.target = target;

    target.recyclerview = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'recyclerview'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RumahTanggaFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerview = null;
  }
}
