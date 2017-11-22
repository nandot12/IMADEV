package id.co.imastudio.libawaydevsummit.PenjualLimbah.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import id.co.imastudio.libawaydevsummit.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimelineFragment extends Fragment {


    @BindView(R.id.listLimbahKu)
    RecyclerView listLimbahKu;
    Unbinder unbinder;
    String[] data = {"Limbah kayu jati", "Botol Plastik bekas aQua", "Potongan pohon Arbisa", "Platik bekas kemasan Minuman", "Daun lontar kering"};
    public TimelineFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timeline, container, false);
        unbinder = ButterKnife.bind(this, view);
        // set layout manager
        LinearLayoutManager linear = new LinearLayoutManager(getActivity());
        listLimbahKu.setLayoutManager(linear);
        listLimbahKu.setAdapter(new ListLimbahkuAdapter(getActivity(), data));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
