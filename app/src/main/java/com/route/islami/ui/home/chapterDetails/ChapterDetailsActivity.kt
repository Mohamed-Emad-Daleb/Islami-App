package com.route.islami.ui.home.chapterDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.islami.databinding.ActivityChapterDetailsBinding
import com.route.islami.ui.home.Constant

class ChapterDetailsActivity : AppCompatActivity() {
    lateinit var viewBiniding: ActivityChapterDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBiniding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(viewBiniding.root)
        initPramter()
        initViews()
        loadChapterFile()
    }

    private fun initViews() {
        setSupportActionBar(viewBiniding.toolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        viewBiniding.titleTv.text = chapterName
        supportActionBar?.title = ""
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun loadChapterFile() {
        val fileContent = assets.open("$chapterIndex.txt").bufferedReader().use { it.readText() }
        val lines = fileContent.trim().split("\n")
        bindVerses(lines)
    }

    lateinit var adapter: VersesAdapter
    private fun bindVerses(verses: List<String>) {
        adapter = VersesAdapter(verses)
        viewBiniding.content.versesRecyclerView.adapter = adapter
    }

    lateinit var chapterName: String
    var chapterIndex: Int = 0
    private fun initPramter() {
        chapterName = intent.getStringExtra(Constant.VAL_CHAPTER_NAME) ?: ""
        chapterIndex = intent.getIntExtra(Constant.VAL_CHAPTER_INDEX, 0)
    }
}