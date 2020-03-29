package com.hammerrrr.dicodingpemula

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val getTitle        = intent.getStringExtra("TITLE")
        val getAuthor       = intent.getStringExtra("AUTHOR")
        val getRates        = intent.getStringExtra("RATES")
        val getPhoto           = intent.getIntExtra("PHOTO", 0)
        val getSynopsis     = intent.getStringExtra("SYNOPSIS")

        setContentView(R.layout.novel_detail)
        val actionBar = supportActionBar
        actionBar?.title = getTitle
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val dtPhoto: ImageView  = findViewById(R.id.dt_photo)
        val dtTitle: TextView   = findViewById(R.id.dt_title)
        val dtAuthor: TextView  = findViewById(R.id.dt_author)
        val dtRates: TextView   = findViewById(R.id.dt_rates)
        val dtSynopsis: TextView= findViewById(R.id.dt_synopsis)

        Glide.with(this)
            .load(getPhoto)
            .apply(RequestOptions())
            .into(dtPhoto)
        dtTitle.text    = getTitle
        dtAuthor.text   = getAuthor
        dtRates.text    = getRates
        dtSynopsis.text = getSynopsis
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}