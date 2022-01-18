package com.example.fruitsappbabcom.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fruitsappbabcom.databinding.FragmentDescriptionBinding


class DescriptionFragment : Fragment() {
   private var _binding : FragmentDescriptionBinding? = null
    private  val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDescriptionBinding.inflate(inflater,container,false)
        return binding.root
    }

}