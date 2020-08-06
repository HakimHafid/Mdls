package id.kim.mabdalandsharia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import id.kim.vraksesjalan.prosestampilaksesjalan
import id.kim.vrdepanruko.prosestampildepanruko
import id.kim.vrjalanporos.prosestampiljalanporos
import id.kim.vrjalanutama.prosestampilhalutama
import id.kim.vrkantorpemasaran.prosestampilkantorpemasaran

class virtualalfath : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_virtualalfath)

        val akses_jalan: Button = findViewById(R.id.btn_aksesjalan)
        akses_jalan.setOnClickListener(this)

        val depan_ruko: Button = findViewById(R.id.btn_depanriko)
        depan_ruko.setOnClickListener(this)

        val jalanan: Button = findViewById(R.id.btn_jalanan)
        jalanan.setOnClickListener(this)

        val jalan_utama: Button = findViewById(R.id.btn_jalanutama)
        jalan_utama.setOnClickListener(this)

        val kantor: Button = findViewById(R.id.btn_kantor)
        kantor.setOnClickListener(this)


        //actiobar
        val actionbar = supportActionBar
        //set tittle actionbar
        actionbar!!.title= "Virtual Al Fath City"
        //set actionbarbutton back
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClick(v: View) {
        when (v.id) {

            R.id.btn_jalanan -> {
                val pindahkejalanan =
                    Intent(this@virtualalfath, prosestampiljalanporos::class.java)
                startActivity(pindahkejalanan)}

            R.id.btn_aksesjalan -> {
                val pindahkeaksesjalan =
                    Intent(this@virtualalfath, prosestampilaksesjalan::class.java)
                startActivity(pindahkeaksesjalan)}

            R.id.btn_jalanutama -> {
                val pindahkeajalanutama =
                    Intent(this@virtualalfath, prosestampilhalutama::class.java)
                startActivity(pindahkeajalanutama)}

            R.id.btn_depanriko -> {
                val pindahkedepanruko =
                    Intent(this@virtualalfath, prosestampildepanruko::class.java)
                startActivity(pindahkedepanruko)}

            R.id.btn_kantor -> {
                val pindahkekantor =
                    Intent(this@virtualalfath, prosestampilkantorpemasaran::class.java)
                startActivity(pindahkekantor)
            }
        }



    }
    }

