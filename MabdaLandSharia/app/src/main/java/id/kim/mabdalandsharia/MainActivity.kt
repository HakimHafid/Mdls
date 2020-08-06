package id.kim.mabdalandsharia

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //variabel untuk actionbar
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //intent
        var keourproject: ImageButton = findViewById(R.id.btn_am_panahkanan)
        keourproject.setOnClickListener(this)

        toggle = ActionBarDrawerToggle(this, drawlayout, R.string.open, R.string.close)
        drawlayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navview.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    val pindahkehome = Intent(this@MainActivity, MainActivity::class.java)
                    startActivity(pindahkehome)
                }
                R.id.project -> {
                    val pindahkeourproject = Intent(this@MainActivity, OurProject::class.java)
                    startActivity(pindahkeourproject)
                }
                R.id.aabout -> {
                    val pindahkeourproject = Intent(this@MainActivity, AboutApp::class.java)
                    startActivity(pindahkeourproject)
                }

            }
            true
        }


    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setIcon(R.drawable.logomabda)
            .setTitle(R.string.app_name)
            .setMessage("Yakin Mau Keluar?")
            .setPositiveButton(
                "Ya"
            ) { dialog, which -> finish() }
            .setNegativeButton(
                "Tidak"
            ) { dialog, which -> dialog.cancel() }
            .show()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_am_panahkanan -> {
                val pindahkepurroject = Intent(this@MainActivity, OurProject::class.java)
                startActivity(pindahkepurroject)
            }
        }

    }
}


    /* exit
    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Exit From Mabda Land Apps ?")
        builder.setCancelable(true)
        builder.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
        dialogInterface.cancel()
        })

        builder.setPositiveButton("Yes", DialogInterface.OnClickListener{dialogInteface, i ->
            finish()
        })

        val alertDialog = builder.create()
        alertDialog.show()
    }
}*/