package id.kim.vrdepanruko;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import id.kim.aboutpict.tentang_depanruko;
import id.kim.mabdalandsharia.R;
import id.kim.mabdalandsharia.virtualalfath;
import id.kim.vraksesjalan.prosestampilaksesjalan;
import id.kim.vrjalanporos.prosestampiljalanporos;
import id.kim.vrjalanutama.prosestampilhalutama;
import id.kim.vrkantorpemasaran.prosestampilkantorpemasaran;

public class prosestampildepanruko extends AppCompatActivity {

    private VrPanoramaView panoWidgetView;
    private tampildepanruko backgrounddepanruko;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampildepanruko);
        panoWidgetView = (VrPanoramaView) findViewById(R.id.depan_ruko);
        loadPanoImage();
    }

    private synchronized void loadPanoImage() {
        tampildepanruko task = backgrounddepanruko;
        if (task != null && !task.isCancelled()) {
            task.cancel(true);
        }

        //tombolbackdong
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        VrPanoramaView.Options ViewOptions = new VrPanoramaView.Options();
        ViewOptions.inputType = VrPanoramaView.Options.TYPE_MONO;


        String panoImageName = "rancanganruko.jpg";

        task = new tampildepanruko(panoWidgetView, ViewOptions, panoImageName);
        task.execute(this.getAssets());
        backgrounddepanruko = task;

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
            Intent intent = new Intent(prosestampildepanruko.this, tentang_depanruko.class);
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
            Intent intent = new Intent(prosestampildepanruko.this, prosestampilaksesjalan.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.menu_depanruko) {
            Intent intent = new Intent(prosestampildepanruko.this, prosestampildepanruko.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.menu_jalanporos) {
            Intent intent = new Intent(prosestampildepanruko.this, prosestampiljalanporos.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.menu_jalanutama) {
            Intent intent = new Intent(prosestampildepanruko.this, prosestampilhalutama.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.menu_kantorpemasaran) {
            Intent intent = new Intent(prosestampildepanruko.this, prosestampilkantorpemasaran.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.menu_listgambar) {
            Intent intent = new Intent(prosestampildepanruko.this, virtualalfath.class);
            startActivity(intent);
            return true;

        }
        return super.onOptionsItemSelected(item);

    }

}
*/