package id.co.imastudio.libawaydevsummit.PenjualLimbah.fragment;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.co.imastudio.libawaydevsummit.PenjualLimbah.PromoteActivity;
import id.co.imastudio.libawaydevsummit.R;

/**
 * Created by root on 11/22/17.
 */

class ListLimbahkuAdapter extends RecyclerView.Adapter<ListLimbahkuAdapter.MyHolder> {
    FragmentActivity c ;
    String[] data;
    public ListLimbahkuAdapter(FragmentActivity activity, String[] data) {
        c = activity;
        this.data = data;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.limbahku_item, parent, false);
        //View view = inflater.createView()
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.linkPromote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.startActivity(new Intent(c, PromoteActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView linkPromote;
        public MyHolder(View itemView) {
            super(itemView);
            linkPromote = (TextView) itemView.findViewById(R.id.linkPromote);
        }
    }
}
