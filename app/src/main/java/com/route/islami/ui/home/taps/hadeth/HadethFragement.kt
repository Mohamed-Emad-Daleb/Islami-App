package com.route.islami.ui.home.taps.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami.databinding.FragmentHadethBinding
import com.route.islami.ui.home.Constant
import com.route.islami.ui.home.hadethDetails.HadethDetailsActivity
import com.route.islami.ui.home.model.Hadeth

class HadethFragement : Fragment() {
    lateinit var viewBinding: FragmentHadethBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHadethBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    lateinit var adapter: HadethRecyclerAdapter
    private fun initViews() {
        adapter = HadethRecyclerAdapter(null)
        adapter.onItemClickListener =
            HadethRecyclerAdapter.OnItemClickListener { position, hadeth ->
                showHadethDetails(hadeth)
            }
        viewBinding.recyclerView.adapter = adapter
    }

    private fun showHadethDetails(hadeth: Hadeth) {
        val intent = Intent(activity, HadethDetailsActivity::class.java)
        intent.putExtra(Constant.EXTRA_HADETH, hadeth)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        loadHadethFile()
        bindHadethList()
    }

    private fun bindHadethList() {
        adapter.bindItem(hadethList)
    }

    val hadethList = mutableListOf<Hadeth>()
    private fun loadHadethFile() {
        val fileContent =
            requireActivity().assets.open("hadeth.txt").bufferedReader().use { it.readText() }
        val singleHadethList = fileContent.trim().split("#")
        singleHadethList.forEach() { element ->
            val lines = element.trim().split("\n")
            val title = lines[0]
            val content = lines.joinToString("\n")
            val hadeth = Hadeth(title, content)
            hadethList.add(hadeth)
        }
    }
}