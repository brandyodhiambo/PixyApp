package com.odhiambodevelopers.pixyapp.ui.main.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.odhiambodevelopers.pixyapp.R
import com.odhiambodevelopers.pixyapp.databinding.FragmentPixDetailsBinding
import com.odhiambodevelopers.pixyapp.ui.main.viewmodel.PixyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PixDetailsFragment : Fragment() {

    private lateinit var binding: FragmentPixDetailsBinding
    private val pixyViewModel:PixyViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPixDetailsBinding.inflate(inflater,container,false)

        pixyViewModel.pictureDetails.observe(viewLifecycleOwner) { details ->
            Glide.with(binding.imageView)
                .load(details?.webformatURL)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.imageView)

            binding.textViewLikes.text = details?.likes.toString()
            binding.textViewViews.text = details?.views.toString()
            binding.textViewDownloads.text = details?.downloads.toString()
            binding.textViewComments.text = details?.comments.toString()
            binding.textViewUserName.text = details?.user.toString()

            Glide.with(binding.imageViewUser)
                .load(details?.userImageURL)
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.imageViewUser)
        }

        return binding.root
    }


}