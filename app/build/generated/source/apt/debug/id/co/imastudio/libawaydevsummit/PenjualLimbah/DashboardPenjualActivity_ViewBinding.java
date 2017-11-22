// Generated code from Butter Knife. Do not modify!
package id.co.imastudio.libawaydevsummit.PenjualLimbah;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.co.imastudio.libawaydevsummit.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DashboardPenjualActivity_ViewBinding implements Unbinder {
  private DashboardPenjualActivity target;

  @UiThread
  public DashboardPenjualActivity_ViewBinding(DashboardPenjualActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DashboardPenjualActivity_ViewBinding(DashboardPenjualActivity target, View source) {
    this.target = target;

    target.tablayout = Utils.findRequiredViewAsType(source, R.id.tablayout, "field 'tablayout'", TabLayout.class);
    target.pager = Utils.findRequiredViewAsType(source, R.id.pager, "field 'pager'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DashboardPenjualActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tablayout = null;
    target.pager = null;
  }
}
