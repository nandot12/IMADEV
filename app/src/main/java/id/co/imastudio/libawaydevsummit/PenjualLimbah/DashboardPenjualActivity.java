package id.co.imastudio.libawaydevsummit.PenjualLimbah;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.imastudio.libawaydevsummit.Adapter.CustomPagerPenjual;
import id.co.imastudio.libawaydevsummit.R;
import id.co.imastudio.libawaydevsummit.TambahLimbahActivity;

public class DashboardPenjualActivity extends AppCompatActivity {

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.pager)
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_penjual);
        ButterKnife.bind(this);

        // membuat nama tab
        tablayout.addTab(tablayout.newTab().setText("Limbahku"));
        tablayout.addTab(tablayout.newTab().setText("Terjual"));

        PagerAdapter adapter = new CustomPagerPenjual(getSupportFragmentManager());

        pager.setAdapter(adapter);

        //kalau
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void tambahLimbah(View view) {
        startActivity(new Intent(this, TambahLimbahActivity.class));
    }
}
