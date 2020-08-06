package id.kim.mabdalandsharia

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_main.*

class OurProject : AppCompatActivity(), View.OnClickListener {

    var carouselView: CarouselView? = null
    var sampleImages = intArrayOf(
        R.drawable.slide_one,
        R.drawable.slide_two,
        R.drawable.slide_three,
        R.drawable.slide_four,
        R.drawable.slide_five
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_our_project)



        //intent degam tombol
        val btnLihatSelengkapnya: ImageButton = findViewById(R.id.btn_pindahkeaaavirtual)
        btnLihatSelengkapnya.setOnClickListener(this)

        val alfath: ImageButton = findViewById(R.id.btn_pindahkealfath)
        alfath.setOnClickListener(this)

        val btnwhatsapp: ImageButton = findViewById(R.id.btn_pindahkewhatsapp)
        btnwhatsapp.setOnClickListener(this)

        val btnfacebook: ImageButton = findViewById(R.id.btn_pindahkefacebook)
        btnfacebook.setOnClickListener(this)

        val btninstagram: ImageButton = findViewById(R.id.btn_pindahkeinstagram)
        btninstagram.setOnClickListener(this)

        val btnyoutube: ImageButton = findViewById(R.id.btn_pindahkeyoutube)
        btnyoutube.setOnClickListener(this)

        carouselView = findViewById<View>(R.id.op_carousel) as CarouselView
        carouselView!!.pageCount = sampleImages.size
        carouselView!!.setImageListener(imageListener)

        //actiobar
        val actionbar = supportActionBar
        //set tittle actionbar
        actionbar!!.title= "Project Al Fath City"
        //set actionbarbutton back
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }

    var imageListener = ImageListener { position, imageView ->
        imageView.setImageResource(
            sampleImages[position]
        )
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_pindahkeaaavirtual -> {
                val pindahkealfathactivity = Intent(this@OurProject, virtualalfath::class.java)
                startActivity(pindahkealfathactivity)
            }

            R.id.btn_pindahkealfath -> {
                val pindahkealfathactivity = Intent(this@OurProject, AlFathCity::class.java)
                startActivity(pindahkealfathactivity)
            }

            R.id.btn_pindahkewhatsapp -> {
                val whatsapp = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://api.whatsapp.com/send?phone='+6282293045981")
                )
                startActivity(whatsapp)
            }

            R.id.btn_pindahkefacebook -> {
                val facebook = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://web.facebook.com/Alfathcitymoncongloe")
                )
                startActivity(facebook)
            }

            R.id.btn_pindahkeinstagram -> {
                val instagram = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://instagram.com/_u/alfathcitymoncongloe")
                )
                startActivity(instagram)
            }

            R.id.btn_pindahkeyoutube -> {
                val youtube = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/channel/UCKoSW765Ol2kbfF_2TBg9eg")
                )
                startActivity(youtube)
            }

        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.pilihanmenu_ourproject, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.homeku -> {
                val pindahkehomeku = Intent(this@OurProject, MainActivity::class.java)
                startActivity(pindahkehomeku)
            }

            R.id.projectku-> {
                val pindahkeprojectku = Intent(this@OurProject, virtualalfath::class.java)
                startActivity(pindahkeprojectku)
            }

            R.id.aboutku-> {
                val pindahkeaboutku= Intent(this@OurProject, virtualalfath::class.java)
                startActivity(pindahkeaboutku)
            }
        }

        setActionBarTitle(title as String)
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }
}










//https://web.facebook.com/Alfathcitymoncongloe
//https://web.facebook.com/mabdalandsharia
//http://api.whatsapp.com/send?phone='+6282293045981

