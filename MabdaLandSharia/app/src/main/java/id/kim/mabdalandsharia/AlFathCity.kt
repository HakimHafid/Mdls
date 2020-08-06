package id.kim.mabdalandsharia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AlFathCity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_al_fath_city)

        //actiobar
        val actionbar = supportActionBar
        //set tittle actionbar
        actionbar!!.title= "About Project"
        //set actionbarbutton back
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true


        }
    }

