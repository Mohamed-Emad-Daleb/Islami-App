package com.route.islami.ui.home.taps.radio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami.databinding.FragmentRadioBinding

class RadioFragement : Fragment() {
    lateinit var viewBinding: FragmentRadioBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentRadioBinding.inflate(inflater, container, false)
        return viewBinding.root
    }
}