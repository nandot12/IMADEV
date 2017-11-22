package id.co.imastudio.libawaydevsummit.Adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import id.co.imastudio.libawaydevsummit.R;

/**
 * Created by nandoseptianhusni on 11/21/17.
 */

public class RecyclerItem extends RecyclerView.Adapter<RecyclerItem.MyHolder> {

    FragmentActivity c ;
    int[] gambar ;
    String[] jdl ;
    String[] harga ;
    String[] daerah ;
    String[] prov ;

    public RecyclerItem(FragmentActivity activity, int[] gambar, String[] jdl, String[] harga, String[] daerah, String[] prov) {
        c = activity;
        this.gambar = gambar ;
        this.jdl = jdl ;
        this.harga = harga ;
        this.daerah = daerah ;
        this.prov = prov;
    }


    @Override
    public RecyclerItem.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.item_menu,parent,false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerItem.MyHolder holder, int position) {
        holder.img.setImageResource(gambar[position]);
        holder.textDaerah.setText(daerah[position]);
        holder.textJdl.setText(jdl[position]);
        holder.textProv.setText(prov[position]);
        holder.textHarga.setText(harga[position]);


    }

    @Override
    public int getItemCount() {
        return gambar.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView img ;
         TextView textJdl,textHarga,textProv,textDaerah ;

        public MyHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageItem);
            textJdl = itemView.findViewById(R.id.textJdlItem);
            textHarga = itemView.findViewById(R.id.textHargaItem);
            textProv = itemView.findViewById(R.id.textProvItem);
            textDaerah = itemView.findViewById(R.id.textTempatItem);
        }
    }
}
