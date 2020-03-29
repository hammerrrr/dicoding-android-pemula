package com.hammerrrr.dicodingpemula

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val actionBar = supportActionBar
        actionBar?.title = "About Me"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        var avatar: ImageView = findViewById(R.id.avatar)

        Glide.with(this)
            .load(R.drawable.avatar)
            .apply(RequestOptions())
            .into(avatar)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
