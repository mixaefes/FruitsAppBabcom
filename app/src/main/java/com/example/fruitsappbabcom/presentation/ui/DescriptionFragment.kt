package com.example.fruitsappbabcom.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.api.load
import com.example.fruitsappbabcom.databinding.FragmentDescriptionBinding
import com.example.fruitsappbabcom.presentation.viewModel.SharedViewModel


class DescriptionFragment : Fragment() {
   private var _binding : FragmentDescriptionBinding? = null
    private  val binding get() = _binding!!
    private val sharedViewModel : SharedViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDescriptionBinding.inflate(inflater,container,false)
        val selectedFruit = sharedViewModel.selectedItem.value
        binding.imageViewDescription.load(selectedFruit?.image)
        binding.textViewName.text = selectedFruit?.name
        binding.textViewDescription.text = selectedFruit?.description
        binding.textViewPrice.text = selectedFruit?.price.toString()
        return binding.root
    }

}