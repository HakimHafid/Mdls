package id.kim.aboutpict

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.kim.mabdalandsharia.R

class tentang_kantorpemasaran : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tentang_kantorpemasaran)

        //actiobar
        val actionbar = supportActionBar
        //set tittle actionbar
        actionbar!!.title= "Tentang Kantor Pemasaran"
        //set actionbarbutton back
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }
}