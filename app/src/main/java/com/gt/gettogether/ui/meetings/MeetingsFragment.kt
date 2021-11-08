package com.gt.gettogether.ui.meetings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.gt.gettogether.R
import com.gt.gettogether.databinding.MeetingsLayoutBinding

class MeetingsFragment : Fragment() {

    private val viewModel: MeetingsViewModel by activityViewModels()
    private lateinit var binding: MeetingsLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.meetings_layout,
            container,
            false
        )

        return binding.root
    }
}