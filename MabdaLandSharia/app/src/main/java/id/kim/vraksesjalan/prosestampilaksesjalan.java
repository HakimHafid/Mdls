package id.kim.vraksesjalan;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import id.kim.aboutpict.tentang_aksesjalan;
import id.kim.mabdalandsharia.R;
import id.kim.mabdalandsharia.virtualalfath;

public class prosestampilaksesjalan extends AppCompatActivity {

    private VrPanoramaView panoWidgetView;
    private tampilaksesjalan backgroundaksesjalan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilaksesjalan);


        panoWidgetView = (VrPanoramaView) findViewById(R.id.akses_jalan);
        loadPanoImage();


    }


    private synchronized void loadPanoImage() {
        tampilaksesjalan task = backgroundaksesjalan;
        if (task != null && !task.isCancelled()) {
            task.cancel(true);
        }

        //tombolbackdong
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        VrPanoramaView.Options ViewOptions = new VrPanoramaView.Options();
        ViewOptions.inputType = VrPanoramaView.Options.TYPE_MONO;


        String panoImageName = "aksesjalan.jpg";

        task = new tampilaksesjalan(panoWidgetView, ViewOptions, panoImageName);
        task.execute(this.getAssets());
        backgroundaksesjalan = task;

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
            Intent intent = new Intent(prosestampilaksesjalan.this, tentang_aksesjalan.class);
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
            Intent intent = new Intent(prosestampilaksesjalan.this, prosestampilaksesjalan.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.menu_depanruko) {
            Intent intent = new Intent(prosestampilaksesjalan.this, prosestampildepanruko.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.menu_jalanporos) {
            Intent intent = new Intent(prosestampilaksesjalan.this, prosestampiljalanporos.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.menu_jalanutama) {
            Intent intent = new Intent(prosestampilaksesjalan.this, prosestampilhalutama.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.menu_kantorpemasaran) {
            Intent intent = new Intent(prosestampilaksesjalan.this, prosestampilkantorpemasaran.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.menu_listgambar) {
            Intent intent = new Intent(prosestampilaksesjalan.this, virtualalfath.class);
            startActivity(intent);
            return true;

        }
        return super.onOptionsItemSelected(item);

    }
} */