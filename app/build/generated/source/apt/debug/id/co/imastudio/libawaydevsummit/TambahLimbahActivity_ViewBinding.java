// Generated code from Butter Knife. Do not modify!
package id.co.imastudio.libawaydevsummit;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TambahLimbahActivity_ViewBinding implements Unbinder {
  private TambahLimbahActivity target;

  private View view2131296304;

  private View view2131296301;

  @UiThread
  public TambahLimbahActivity_ViewBinding(TambahLimbahActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TambahLimbahActivity_ViewBinding(final TambahLimbahActivity target, View source) {
    this.target = target;

    View view;
    target.etNamaLimbah = Utils.findRequiredViewAsType(source, R.id.etNamaLimbah, "field 'etNamaLimbah'", TextInputLayout.class);
    target.etHargaLimbah = Utils.findRequiredViewAsType(source, R.id.etHargaLimbah, "field 'etHargaLimbah'", TextInputLayout.class);
    target.etDeskLimbah = Utils.findRequiredViewAsType(source, R.id.etDeskLimbah, "field 'etDeskLimbah'", TextInputLayout.class);
    target.addPhotoIcon = Utils.findRequiredViewAsType(source, R.id.addPhotoIcon, "field 'addPhotoIcon'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.btnTambahFoto, "field 'btnTambahFoto' and method 'onBtnTambahFotoClicked'");
    target.btnTambahFoto = Utils.castView(view, R.id.btnTambahFoto, "field 'btnTambahFoto'", CardView.class);
    view2131296304 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBtnTambahFotoClicked();
      }
    });
    view = Utils.findRequiredView(source, R.id.btnSignGmail, "field 'btnSignGmail' and method 'onBtnSignGmailClicked'");
    target.btnSignGmail = Utils.castView(view, R.id.btnSignGmail, "field 'btnSignGmail'", Button.class);
    view2131296301 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBtnSignGmailClicked();
      }
    });
    target.tampilFoto = Utils.findRequiredViewAsType(source, R.id.tampilFoto, "field 'tampilFoto'", ImageView.class);
    target.imgLimbahPrev = Utils.findRequiredViewAsType(source, R.id.imgLimbahPrev, "field 'imgLimbahPrev'", ImageView.class);
    target.cardPrevLimbah = Utils.findRequiredViewAsType(source, R.id.cardPrevLimbah, "field 'cardPrevLimbah'", CardView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TambahLimbahActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etNamaLimbah = null;
    target.etHargaLimbah = null;
    target.etDeskLimbah = null;
    target.addPhotoIcon = null;
    target.btnTambahFoto = null;
    target.btnSignGmail = null;
    target.tampilFoto = null;
    target.imgLimbahPrev = null;
    target.cardPrevLimbah = null;

    view2131296304.setOnClickListener(null);
    view2131296304 = null;
    view2131296301.setOnClickListener(null);
    view2131296301 = null;
  }
}
