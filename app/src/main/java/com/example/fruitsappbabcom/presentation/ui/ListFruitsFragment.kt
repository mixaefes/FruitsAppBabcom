package com.example.fruitsappbabcom.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.coroutineScope
import com.example.fruitsappbabcom.R
import com.example.fruitsappbabcom.databinding.FragmentListFruitsBinding
import com.example.fruitsappbabcom.presentation.adapter.FruitsListAdapter
import com.example.fruitsappbabcom.presentation.viewModel.ListViewModel
import kotlinx.coroutines.launch


class ListFruitsFragment : Fragment() {
    private var _binding: FragmentListFruitsBinding? = null
    private val binding get() = _binding!!
    private val viewModel : ListViewModel by viewModels()
    private var fruitsAdapter : FruitsListAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListFruitsBinding.inflate(inflater, container, false)
        fruitsAdapter = FruitsListAdapter()
        binding.recyclerViewFruits.adapter = fruitsAdapter
        lifecycle.coroutineScope.launch {
            viewModel.items.observe(viewLifecycleOwner, Observer {
                fruitsAdapter?.submitList(it.fruits)
            })
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}