package id.co.imastudio.libawaydevsummit.Adapter;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.imastudio.libawaydevsummit.R;


/**
 * Created by ima5 on 10/8/17.
 */

public class NavAdapter extends BaseAdapter {
    FragmentActivity mainActivity;
    int[] nav_menu;
    String[] nav_title;

    public NavAdapter(FragmentActivity mainActivity, int[] nav_menu, String[] nav_title) {
        this.mainActivity = mainActivity;
        this.nav_menu = nav_menu;
        this.nav_title = nav_title;
    }

    @Override
    public int getCount() {
        return nav_menu.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
      convertView = LayoutInflater.from(mainActivity).inflate(R.layout.navigation_item, parent, false);


        ViewHolder holder = new ViewHolder(convertView);


        holder.textmenu.setText(nav_title[position]);
      holder.gambarmenu.setImageResource(nav_menu[position]);



        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.gambarmenu)
        ImageView gambarmenu;
        @BindView(R.id.textmenu)
        TextView textmenu;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
