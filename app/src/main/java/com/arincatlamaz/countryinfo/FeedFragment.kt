package com.arincatlamaz.countryinfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.arincatlamaz.countryinfo.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    private lateinit var binding : FragmentFeedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFeedBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_feedFragment_to_countryFragment)
        }
        super.onViewCreated(view, savedInstanceState)
    }


}