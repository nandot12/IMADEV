package id.co.imastudio.libawaydevsummit.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.ScrollView;

import id.co.imastudio.libawaydevsummit.PenjualLimbah.fragment.LimbahTerjualFragment;
import id.co.imastudio.libawaydevsummit.PenjualLimbah.fragment.TimelineFragment;

/**
 * Created by root on 11/22/17.
 */

public class CustomPagerPenjual extends FragmentStatePagerAdapter {
    public CustomPagerPenjual(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);

    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new TimelineFragment();
        }
        else if (position == 1){
            return new LimbahTerjualFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
        ((ViewPager)container).removeView((ScrollView)object);
    }
}
