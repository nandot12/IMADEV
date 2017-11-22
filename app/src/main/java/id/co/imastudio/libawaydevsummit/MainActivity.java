package id.co.imastudio.libawaydevsummit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.imastudio.libawaydevsummit.Adapter.NavAdapter;
import id.co.imastudio.libawaydevsummit.Adapter.ViewPagerAdapter;
import id.co.imastudio.libawaydevsummit.Fragment.FavoritFragment;
import id.co.imastudio.libawaydevsummit.Fragment.Home.KeranjangFragment;
import id.co.imastudio.libawaydevsummit.Fragment.HomeFragment;
import id.co.imastudio.libawaydevsummit.Fragment.ProfilFragment;
import id.co.imastudio.libawaydevsummit.Fragment.TransaksiFragment;

public class MainActivity extends BaseApp {

    @BindView(R.id.menu)
    ImageView buttonNavigation;
   // @BindView(R.id.pager)
    ViewPager pager;
   // @BindView(R.id.tabUtama)
    TabLayout tabUtama;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    TextView textViewlogout ;
    ListView listdrawer ;
    int nav_menu[] = {R.drawable.ic_point,R.drawable.ic_video_streaming,R.drawable.ic_about};
    String nav_title[] = {"Point","Tutorial","About"};


    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


         pager = (ViewPager) findViewById(R.id.pager);
        createViewPager(pager);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageView img =  toolbar.findViewById(R.id.menu);

        listdrawer = findViewById(R.id.listdrawer);


        textViewlogout = (TextView) findViewById(R.id.textlogout);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.END);


            }
        });
        NavAdapter adapter = new NavAdapter(this, nav_menu, nav_title);
        listdrawer.setAdapter(adapter);

        textViewlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //session.logout();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));

                finish();
            }
        });
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,

                R.string.drawer_open,
                R.string.drawer_close
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                //getActivity().getActionBar().setTitle(mTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

//
//                listdrawer.bringToFront();
//                mDrawerLayout.requestLayout();
                // getActivity().getActionBar().setTitle(mDrawerTitle);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);


        mDrawerToggle.syncState();




        tabUtama= (TabLayout) findViewById(R.id.tabUtama);
        tabUtama.setupWithViewPager(pager);
        ///tabUtama.setTabMode(TabLayout.MODE_SCROLLABLE);
        getCustomTabs();


    }

    private void createViewPager(ViewPager pager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeFragment(), "");
        adapter.addFrag(new FavoritFragment(), "");
        adapter.addFrag(new KeranjangFragment(), "");
        adapter.addFrag(new TransaksiFragment(), "");
        adapter.addFrag(new ProfilFragment(), "");
        pager.setAdapter(adapter);
    }

    private void getCustomTabs() {


        View tabOne = LayoutInflater.from(c).inflate(R.layout.custom_tab, null);
        // tabOne.setImageResource(R.drawable.iconnotouchhome);
        ImageView img = tabOne.findViewById(R.id.imageTabs);
        TextView text = tabOne.findViewById(R.id.textTabs);
        img.setImageResource(R.drawable.iconnotouchhome2);
        text.setText("Home");
        // tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.analytics, 0, 0);
        tabUtama.getTabAt(0).setCustomView(tabOne);
        View tab2 = LayoutInflater.from(c).inflate(R.layout.custom_tab, null);
        // tabOne.setImageResource(R.drawable.iconnotouchhome);
        ImageView img1 = tab2.findViewById(R.id.imageTabs);
        TextView text1 = tab2.findViewById(R.id.textTabs);
        img1.setImageResource(R.drawable.iconnotouchfavorite2);
        text1.setText("Favorite");
        // tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.analytics, 0, 0);
        tabUtama.getTabAt(1).setCustomView(tab2);

        View tab3 = LayoutInflater.from(c).inflate(R.layout.custom_tab, null);
        // tabOne.setImageResource(R.drawable.iconnotouchhome);
        ImageView img2 = tab3.findViewById(R.id.imageTabs);
        TextView text2 = tab3.findViewById(R.id.textTabs);
        img2.setImageResource(R.drawable.iconnotouchbasket2);
        text2.setText("Basket");
        // tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.analytics, 0, 0);
        tabUtama.getTabAt(2).setCustomView(tab3);

        View tab4 = LayoutInflater.from(c).inflate(R.layout.custom_tab, null);
        // tabOne.setImageResource(R.drawable.iconnotouchhome);
        ImageView img3 = tab4.findViewById(R.id.imageTabs);
        TextView text3 = tab4.findViewById(R.id.textTabs);
        img3.setImageResource(R.drawable.iconnotouchtransaction2);
        text3.setText("Transaction");
        // tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.analytics, 0, 0);
        tabUtama.getTabAt(3).setCustomView(tab4);
//
        View tab5 = LayoutInflater.from(c).inflate(R.layout.custom_tab, null);
        // tabOne.setImageResource(R.drawable.iconnotouchhome);
        ImageView img4 = tab5.findViewById(R.id.imageTabs);
        TextView text4 = tab5.findViewById(R.id.textTabs);
        img4.setImageResource(R.drawable.iconnotouchacnt2png);
        text4.setText("Account");
        // tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.analytics, 0, 0);
        tabUtama.getTabAt(4).setCustomView(tab5);

//
//    }
    }

}
