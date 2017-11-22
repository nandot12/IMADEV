package id.co.imastudio.libawaydevsummit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import id.co.imastudio.libawaydevsummit.R;

/**
 * Created by root on 11/23/17.
 */

public class ProdusenAdapter extends BaseAdapter {
    LayoutInflater inflater;
    Context con;
    String[] items;
    public ProdusenAdapter(Context c, String[] items) {
        con = c;
        this.items = items;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.produsen_list, null);

        TextView nama = (TextView)vi.findViewById(R.id.produsenNama); // title
        final CheckBox terpilih = (CheckBox)vi.findViewById(R.id.produsenTerpilih); // artist name

        nama.setText(items[position]);

        nama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!terpilih.isChecked()){
                    terpilih.setChecked(true);
                }
            }
        });

        return vi;
    }
}
