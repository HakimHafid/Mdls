package id.kim.vraksesjalan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

import id.kim.mabdalandsharia.R;

public class tampilaksesjalan extends AsyncTask<AssetManager, Void, Bitmap> {
    private static final String TAG = "akses_jalan";
    private final String assetName;
    private final WeakReference<VrPanoramaView> viewReference;
    private final VrPanoramaView.Options viewOptions;
    private static WeakReference<Bitmap> lastBitmap = new WeakReference<>(null);
    private static String lastName;

    @Override
    protected Bitmap doInBackground(AssetManager... params) {
        AssetManager assetManager = params[0];

        if (assetName.equals(lastName) && lastBitmap.get() != null) {
            return lastBitmap.get();
        }

        try(InputStream istr = assetManager.open(assetName)) {
            Bitmap b = BitmapFactory.decodeStream(istr);
            lastBitmap = new WeakReference<>(b);
            lastName = assetName;
            return b;
        } catch (IOException e) {
            Log.e(TAG, "Could not decode default bitmap: " + e);
            return null;
        }
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        final VrPanoramaView vw = viewReference.get();
        if (vw != null && bitmap != null) {
            vw.loadImageFromBitmap(bitmap, viewOptions);
        }
    }


    public tampilaksesjalan(VrPanoramaView view, VrPanoramaView.Options viewOptions, String assetName) {
        viewReference = new WeakReference<>(view);
        this.viewOptions = viewOptions;
        this.assetName = assetName;
    }
}