package com.route.islami.ui.home.hadethDetails

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.route.islami.databinding.ActivityHadethDetailsBinding
import com.route.islami.ui.home.Constant
import com.route.islami.ui.home.model.Hadeth

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var viewBiniding: ActivityHadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBiniding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(viewBiniding.root)
        initViews()
        initprams()
        bindHadeth()
    }

    private fun initViews() {
        setSupportActionBar(viewBiniding.toolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        supportActionBar?.title = ""
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun bindHadeth() {
        viewBiniding.titleTv.text = hadeth?.title
        viewBiniding.content.content.text = hadeth?.content
    }

    var hadeth: Hadeth? = null
    private fun initprams() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeth = intent.getParcelableExtra(Constant.EXTRA_HADETH, Hadeth::class.java)!!
        } else {
            hadeth = intent.getParcelableExtra(Constant.EXTRA_HADETH) as Hadeth?
        }
    }

}