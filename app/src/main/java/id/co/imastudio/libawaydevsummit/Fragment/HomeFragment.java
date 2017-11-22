package id.co.imastudio.libawaydevsummit.Fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.co.imastudio.libawaydevsummit.Adapter.ViewPagerAdapterHome;
import id.co.imastudio.libawaydevsummit.Fragment.Home.ElektronikFragment;
import id.co.imastudio.libawaydevsummit.Fragment.Home.KerajinanFragment;
import id.co.imastudio.libawaydevsummit.Fragment.Home.PabrikFragment;
import id.co.imastudio.libawaydevsummit.Fragment.Home.PlastikFragment;
import id.co.imastudio.libawaydevsummit.Fragment.Home.RumahTanggaFragment;
import id.co.imastudio.libawaydevsummit.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


   // @BindView(R.id.tabHome)
    TabLayout tabHome;
   // @BindView(R.id.pagerHome)
    ViewPager pagerHome;
    //Unbinder unbinder;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
       // unbinder = ButterKnife.bind(this, view);



        pagerHome =  view.findViewById(R.id.pagerHome);
        createViewPager(pagerHome);

        tabHome= (TabLayout) view.findViewById(R.id.tabHome);
        tabHome.setupWithViewPager(pagerHome);
        ///tabUtama.setTabMode(TabLayout.MODE_SCROLLABLE);
        getCustomTabs();

        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.htab_collapse_toolbar);

        try {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bgslide);
            Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                @SuppressWarnings("ResourceType")
                @Override
                public void onGenerated(Palette palette) {

                    int vibrantColor = palette.getVibrantColor(R.color.colorPrimary);
                    int vibrantDarkColor = palette.getDarkVibrantColor(R.color.colorPrimaryDark);
                    collapsingToolbarLayout.setContentScrimColor(vibrantColor);
                    collapsingToolbarLayout.setStatusBarScrimColor(vibrantDarkColor);
                }
            });

        } catch (Exception e) {
            // if Bitmap fetch fails, fallback to primary colors
           // Log.e(TAG, "onCreate: failed to create bitmap from background", e.fillInStackTrace());
            collapsingToolbarLayout.setContentScrimColor(
                    ContextCompat.getColor(getActivity(), R.color.colorAccent)
            );
            collapsingToolbarLayout.setStatusBarScrimColor(
                    ContextCompat.getColor(getActivity(), R.color.colorAccent)
            );
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //unbinder.unbind();
    }


    private void createViewPager(ViewPager pager) {
        ViewPagerAdapterHome adapter = new ViewPagerAdapterHome(getActivity().getSupportFragmentManager());
        adapter.addFrag(new RumahTanggaFragment(), "");
        adapter.addFrag(new PabrikFragment(), "");
        adapter.addFrag(new KerajinanFragment(), "");
        adapter.addFrag(new ElektronikFragment(), "");
        adapter.addFrag(new PlastikFragment(), "");
        pagerHome.setAdapter(adapter);
    }

    private void getCustomTabs() {

        TextView text = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tabhome,null);
        text.setText("Rumah Tangga");
        // tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.analytics, 0, 0);
        tabHome.getTabAt(0).setCustomView(text);


        TextView text2 = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tabhome,null);
        text2.setText("Pabrik");
        // tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.analytics, 0, 0);
        tabHome.getTabAt(1).setCustomView(text2);

        TextView text3 = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tabhome,null);
        text3.setText("Kerajinan");
        // tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.analytics, 0, 0);
        tabHome.getTabAt(2).setCustomView(text3);

        TextView text4 = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tabhome,null);
        text4.setText("Elektronik");
        // tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.analytics, 0, 0);
        tabHome.getTabAt(3).setCustomView(text4);

        TextView text5 = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tabhome,null);
        text5.setText("Plastik");
        // tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.analytics, 0, 0);
        tabHome.getTabAt(4).setCustomView(text5);
//
//    }
    }
}
