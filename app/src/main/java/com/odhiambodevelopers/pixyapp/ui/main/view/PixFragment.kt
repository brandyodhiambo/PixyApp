package com.odhiambodevelopers.pixyapp.ui.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.odhiambodevelopers.pixyapp.databinding.FragmentPixBinding
import com.odhiambodevelopers.pixyapp.ui.main.adapter.PixyAdapter
import com.odhiambodevelopers.pixyapp.ui.main.viewmodel.PixyViewModel
import com.odhiambodevelopers.pixyapp.utils.Resource
import com.odhiambodevelopers.pixyapp.utils.hideKeyboard
import com.odhiambodevelopers.pixyapp.utils.showSnackbar
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class PixFragment : Fragment() {
    private lateinit var binding: FragmentPixBinding
    private val pixyViewModel:PixyViewModel by viewModels()
    private val pixyAdapter by lazy { PixyAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPixBinding.inflate(inflater,container,false)

        pixyViewModel.getAllPix("dog")
        pixyViewModel.pixResults.value?.let {
            subscribeToObserver(it.toString()) }
        //subscribeToObserver("dog")

        binding.searchImage.setEndIconOnClickListener {
            subscribeToObserver(binding.searchImage.editText?.text.toString())
            binding.picProgressBar.isVisible =true
            hideKeyboard()
        }


        return binding.root
    }

    private fun subscribeToObserver(searchPic:String){
        pixyViewModel.pixResults.observe(viewLifecycleOwner, Observer { pixyModel ->
            when(pixyModel){
                is Resource.Success ->{
                    binding.picProgressBar.isVisible =false
                    binding.recyclerView.isVisible = true
                    if (pixyModel.data?.isEmpty()!!){
                        showSnackbar("No Data Yet, Try Again")
                    } else{
                        pixyAdapter.submitList(pixyModel.data)
                        binding.recyclerView.adapter = pixyAdapter
                        binding.recyclerView.isVisible  = true

                        Timber.d("${pixyModel.data}")
                    }
                }
                is Resource.Loading ->{
                    binding.picProgressBar.isVisible =true
                    binding.recyclerView.isVisible = false
                }
                is Resource.Failure ->{
                    binding.picProgressBar.isVisible = false
                    showSnackbar("Error Occurred")
                }

            }

        })
    }
}