package com.example.fruitsappbabcom.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import com.example.fruitsappbabcom.R
import com.example.fruitsappbabcom.databinding.FragmentListFruitsBinding
import com.example.fruitsappbabcom.presentation.adapter.FruitsListAdapter
import com.example.fruitsappbabcom.presentation.adapter.OnItemClickListener
import com.example.fruitsappbabcom.presentation.viewModel.ListViewModel
import com.example.fruitsappbabcom.presentation.viewModel.SharedViewModel
import kotlinx.coroutines.launch


class ListFruitsFragment : Fragment(),OnItemClickListener {
    private var _binding: FragmentListFruitsBinding? = null
    private val binding get() = _binding!!
    private val viewModel : ListViewModel by viewModels()
    private val sharedViewModel : SharedViewModel by activityViewModels()
    private var fruitsAdapter : FruitsListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListFruitsBinding.inflate(inflater, container, false)
        fruitsAdapter = FruitsListAdapter(this)
        binding.recyclerViewFruits.adapter = fruitsAdapter
        lifecycle.coroutineScope.launch {
            viewModel.items.observe(viewLifecycleOwner, {
                fruitsAdapter?.submitList(it.fruits)
            })
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int) {
        fruitsAdapter?.currentList?.get(position)?.let {
            sharedViewModel.select(it)
        }
        findNavController().navigate(R.id.action_listFruitsFragment_to_descriptionFragment)
    }
}