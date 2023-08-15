package com.route.islami.ui.home.taps.taspeth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami.databinding.FragmentTasbethBinding

class TasbethFragement : Fragment() {
    lateinit var viewBinding: FragmentTasbethBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentTasbethBinding.inflate(inflater, container, false)
        return viewBinding.root
    }
}