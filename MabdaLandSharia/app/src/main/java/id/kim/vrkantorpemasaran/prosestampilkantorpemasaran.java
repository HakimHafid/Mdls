package id.kim.vrkantorpemasaran;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import id.kim.aboutpict.tentang_kantorpemasaran;
import id.kim.mabdalandsharia.R;
import id.kim.mabdalandsharia.virtualalfath;
import id.kim.vraksesjalan.prosestampilaksesjalan;
import id.kim.vrdepanruko.prosestampildepanruko;
import id.kim.vrjalanporos.prosestampiljalanporos;
import id.kim.vrjalanutama.prosestampilhalutama;


public class prosestampilkantorpemasaran extends AppCompatActivity {

    private VrPanoramaView panoWidgetView;
    private tampilkantorpemasaran backgroundkantorpemasaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilkantorpemasaran);
        panoWidgetView = (VrPanoramaView) findViewById(R.id.kantor_pemasaran);
        loadPanoImage();
    }

    private synchronized void loadPanoImage() {
        tampilkantorpemasaran task = backgroundkantorpemasaran;
        if (task != null && !task.isCancelled()) {
            task.cancel(true);
        }

        //tombolbackdong
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }


        VrPanoramaView.Options ViewOptions = new VrPanoramaView.Options();
        ViewOptions.inputType = VrPanoramaView.Options.TYPE_MONO;


        String panoImageName = "kantorpemasaran.jpg";

        task = new tampilkantorpemasaran(panoWidgetView, ViewOptions, panoImageName);
        task.execute(this.getAssets());
        backgroundkantorpemasaran = task;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pilihanmenu_backfromvr, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_back) {
            Intent intent = new Intent(prosestampilkantorpemasaran.this, tentang_kantorpemasaran.class);
            startActivity(intent);
            return true;

        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}


/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.pilihanmenu_gambarvr, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_aksesjalan) {
            Intent intent = new Intent(prosestampilkantorpemasaran.this, prosestampilaksesjalan.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.menu_depanruko) {
            Intent intent = new Intent(prosestampilkantorpemasaran.this, prosestampildepanruko.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.menu_jalanporos) {
            Intent intent = new Intent(prosestampilkantorpemasaran.this, prosestampiljalanporos.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.menu_jalanutama) {
            Intent intent = new Intent(prosestampilkantorpemasaran.this, prosestampilhalutama.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.menu_kantorpemasaran) {
            Intent intent = new Intent(prosestampilkantorpemasaran.this, prosestampilkantorpemasaran.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.menu_listgambar) {
            Intent intent = new Intent(prosestampilkantorpemasaran.this, virtualalfath.class);
            startActivity(intent);
            return true;

        }
        return super.onOptionsItemSelected(item);

    }*/


