package com.route.islami.ui.home.chapterDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.islami.databinding.ActivityChapterDetailsBinding
import com.route.islami.ui.home.Constant

class ChapterDetailsActivity : AppCompatActivity() {
    lateinit var vievBiniding: ActivityChapterDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vievBiniding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(vievBiniding.root)
        initprams()
        initViews()
        loadChapterFile()
    }

    private fun initViews() {
        setSupportActionBar(vievBiniding.toolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        vievBiniding.titleTv.text = chapterName
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
        vievBiniding.content.versesRecyclerview.adapter = adapter
    }

    lateinit var chapterName: String
    var chapterIndex: Int = 0
    private fun initprams() {
        chapterName = intent.getStringExtra(Constant.EXTRA_CHAPTER_NAME) ?: ""
        chapterIndex = intent.getIntExtra(Constant.EXTRA_CHAPTER_INDEX, 0)
    }
}