package id.co.imastudio.libawaydevsummit;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.co.imastudio.libawaydevsummit.PenjualLimbah.DashboardPenjualActivity;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class TambahLimbahActivity extends AppCompatActivity {

    private static final int RC_CAMERA_AND_LOCATION = 2;
    @BindView(R.id.etNamaLimbah)
    TextInputLayout etNamaLimbah;
    @BindView(R.id.etHargaLimbah)
    TextInputLayout etHargaLimbah;
    @BindView(R.id.etDeskLimbah)
    TextInputLayout etDeskLimbah;
    @BindView(R.id.addPhotoIcon)
    ImageView addPhotoIcon;
    @BindView(R.id.btnTambahFoto)
    CardView btnTambahFoto;
    @BindView(R.id.btnSignGmail)
    Button btnSignGmail;

    String mCurrentPhotoPath;

    // variabel penyimpan nomor request
    private static final int ambil_foto_request_code = 100;
    public static final int type_foto_code = 1;

    // nama folder penyimpanan
    private static final String folder_foto = "AplikasiKameraku";
    @BindView(R.id.tampilFoto)
    ImageView tampilFoto;
    @BindView(R.id.imgLimbahPrev)
    ImageView imgLimbahPrev;
    @BindView(R.id.cardPrevLimbah)
    CardView cardPrevLimbah;

    // komponen pengambil foto dari direktory
    private Uri fileUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_limbah);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnTambahFoto)
    public void onBtnTambahFotoClicked() {

        // Do not have permissions, request them now
        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};

        if (EasyPermissions.hasPermissions(this, perms)) {
            // Already have permission, do the thing
            ambilFoto();
            // ...
        } else {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(this, getString(R.string.rationale_camera),
                    RC_CAMERA_AND_LOCATION, perms);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @AfterPermissionGranted(RC_CAMERA_AND_LOCATION)
    private void methodRequiresTwoPermission() {
        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            // Already have permission, do the thing
            ambilFoto();
        } else {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(this, getString(R.string.rationale_camera),
                    RC_CAMERA_AND_LOCATION, perms);
        }
    }

    private void ambilFoto() {
        // tampilkan aplikasi yg memiliki fitur foto
        Intent inten = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // mengambil direktori enyimpanan foto dari metod pengaturan folder
        fileUri = ambilOutputMediaFileUri(type_foto_code);
        // kirim data penyimpanan ke aplikasi foto yg dipiih
        inten.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        // tampilkan pilihan aplikasi
        startActivityForResult(inten, ambil_foto_request_code);
    }

    private Uri ambilOutputMediaFileUri(int type_foto_code) {
        // mengambil alamat directory file
        // return Uri.fromFile(ambilOutputMediaFile(type_foto_code));
        return FileProvider.getUriForFile(this,
                BuildConfig.APPLICATION_ID + ".provider",
                ambilOutputMediaFile(type_foto_code));
    }

    private File ambilOutputMediaFile(int type_foto_code) {
        // atur alamat penyimpanan (SDCard/Pictures/folder_foto)
        File penyimpananMediaDir = new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                , folder_foto
        );
        Log.d("Directory Fileku", penyimpananMediaDir.getAbsolutePath());

        // cek keberadaan folder
        if (!penyimpananMediaDir.exists()) {
            // cek jika tidak bisa membuat folder baru
            if (!penyimpananMediaDir.mkdir()) {
                Toast.makeText(this, "Gagal membuat folder "
                        + folder_foto, Toast.LENGTH_SHORT).show();
                return null;
            }
        }

        // simpan format tanggal saat pengambilan foto
        String waktu = new SimpleDateFormat("yyyyMMdd_hhMss"
                , Locale.getDefault()).format(new Date());
        Log.d("Waktu Pengambilan", waktu);

        // variabel penampung nama file
        File mediaFile;
        // pasang nama foto dengan waktu
        if (type_foto_code == type_foto_code) {
            mediaFile = new File(penyimpananMediaDir.getPath() + File.separator
                    + "IMG" + waktu + ".jpg");
            Log.d("Nama FIle", mediaFile.getAbsolutePath());
        } else {
            return null;
        }
        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = "file:" + mediaFile.getAbsolutePath();
        Log.d("mCurrentPhotoPath : ", mCurrentPhotoPath);
        return mediaFile;
    }

    private boolean supportCamera() {
        // cek aplikasi pada perangkat yg memiliki fitur kamera
        if (getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            // proses kode selanjutnya
            return true;
        } else {
            // stop kode
            return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // jika permintaan adalah code mengambil foto
        if (requestCode == ambil_foto_request_code) {
            // tampilkan gambar ke ImageView
            tampilGambar();
        } else if (resultCode == RESULT_CANCELED) {
            // jika user membatalkan memilih aplikasi pengambil foto
            Toast.makeText(this, "Batal mengambil foto", Toast.LENGTH_SHORT).show();
        } else {
            // jika gagal menampilkan request
            Toast.makeText(this, "Gagal mengambil foto", Toast.LENGTH_SHORT).show();
        }
    }

    private void tampilGambar() {
        // tampilkan gambar
        //Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath);
        //imgfoto.setImageBitmap(bitmap);

        // ambil alamat
        Uri imageUri = Uri.parse(mCurrentPhotoPath);
        // ambil file
        File file = new File(imageUri.getPath());
        // cek keberadaan file
        if (file.exists()) {
            try {

                InputStream ims = new FileInputStream(file);
                imgLimbahPrev.setImageBitmap(BitmapFactory.decodeStream(ims));
                cardPrevLimbah.setVisibility(View.VISIBLE);
            } catch (FileNotFoundException e) {
                return;
            }
        } else {
            // jika file tidak ditemukan
            imgLimbahPrev.setImageResource(0);
            mCurrentPhotoPath = null;
            Toast.makeText(this, "Foto belum tersedia", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btnSignGmail)
    public void onBtnSignGmailClicked() {
        Intent intent = new Intent(this, DashboardPenjualActivity.class);
        startActivity(intent);
    }
}
