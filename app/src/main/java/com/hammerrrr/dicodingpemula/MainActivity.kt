package com.hammerrrr.dicodingpemula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvNovel: RecyclerView
    private var list: ArrayList<Novel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar?.title = "Daftar Novel"

        rvNovel = findViewById(R.id.rv_novel)
        rvNovel.setHasFixedSize(true)

        list.addAll(NovelData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvNovel.layoutManager = LinearLayoutManager(this)
        val listNovelAdapter = ListNovelAdapter(list)
        rvNovel.adapter = listNovelAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when(selectedMode) {
            R.id.abou_menu -> {
                val aboutActivity = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutActivity)
            }
        }
    }
}
