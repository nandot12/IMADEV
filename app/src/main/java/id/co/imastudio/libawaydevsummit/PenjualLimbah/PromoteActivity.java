package id.co.imastudio.libawaydevsummit.PenjualLimbah;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.imastudio.libawaydevsummit.Adapter.ProdusenAdapter;
import id.co.imastudio.libawaydevsummit.R;

public class PromoteActivity extends AppCompatActivity {

    @BindView(R.id.listProdusen)
    ListView listProdusen;

    String[] items = {"Rumah kreatif", "PT Qlapa Indonesia", "Kravi Bandung", "Rotan Jeh", "HJ Aupud", "Rumah kreatif", "PT Qlapa Indonesia", "Kravi Bandung", "Rotan Jeh", "HJ Aupud", "Rumah kreatif", "PT Qlapa Indonesia", "Kravi Bandung", "Rotan Jeh", "HJ Aupud"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promote);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("Pilih Produsen");

        ProdusenAdapter itemsAdapter = new ProdusenAdapter(this, items);
        listProdusen.setAdapter(itemsAdapter);

//        listProdusen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                parent.get
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pilih_produsen, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.finish:
                Intent intent = new Intent(this, DashboardPenjualActivity.class);
                startActivity(intent);
                Toast.makeText(this, "Prodak Anda telah dipromosikan", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
