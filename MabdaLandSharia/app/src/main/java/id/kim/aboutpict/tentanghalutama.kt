package id.kim.aboutpict

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.kim.mabdalandsharia.R

class tentanghalutama : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tentanghalutama)

        //actiobar
        val actionbar = supportActionBar
        //set tittle actionbar
        actionbar!!.title= "Tentang Jalan Utama"
        //set actionbarbutton back
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }
}