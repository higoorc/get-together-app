package com.gt.gettogether.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.gt.gettogether.R
import com.gt.gettogether.databinding.ChatLayoutBinding

class ChatFragment : Fragment() {

    private lateinit var binding: ChatLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.chat_layout,
            container,
            false
        )

        return binding.root
    }

}