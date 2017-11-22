package id.co.imastudio.libawaydevsummit.Fragment.Home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import id.co.imastudio.libawaydevsummit.Adapter.RecyclerItem;
import id.co.imastudio.libawaydevsummit.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RumahTanggaFragment extends Fragment {
    int gambar[] = {R.drawable.limbahplastik1, R.drawable.limbahplastik2, R.drawable.limbahplastik4};
    String jdl[] = {"Limbah bekas gelas plastik", "Limbah bekas gelas oli", "Limbah bekas ", "limbah potong bebek angsa"};
    String harga[] = {"Rp.10.000/Kg", "Rp.15.000/Kg", "Rp.4.000/kg"};
    String daerah[] = {"Pacitan", "Slipi,", "Lembang"};
    String prov[] = {"DKI.Jakarta", "Jawa Barat", "Jawa Timur"};
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    Unbinder unbinder;


    public RumahTanggaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rumah_tangga, container, false);
        unbinder = ButterKnife.bind(this, view);

        RecyclerItem adapter = new RecyclerItem(getActivity(),gambar,jdl,harga,daerah,prov);
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new GridLayoutManager(getActivity(),2));


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
