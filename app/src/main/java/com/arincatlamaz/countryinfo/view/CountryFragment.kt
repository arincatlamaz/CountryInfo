package com.arincatlamaz.countryinfo.view

import android.icu.text.MessagePattern.ArgType
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.DEFAULT_ARGS_KEY
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.Navigation
import androidx.navigation.navArgument
import com.arincatlamaz.countryinfo.databinding.FragmentCountryBinding
import com.arincatlamaz.countryinfo.util.downloadFromUrl
import com.arincatlamaz.countryinfo.util.placeholderProgressBar
import com.arincatlamaz.countryinfo.viewmodel.CountryViewModel
import com.arincatlamaz.countryinfo.viewmodel.FeedViewModel

class CountryFragment : Fragment() {

    private lateinit var viewModel: CountryViewModel
    private var countryUuid = 0
    private lateinit var binding: FragmentCountryBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCountryBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            countryUuid = CountryFragmentArgs.fromBundle(it).countryUuid
        }

        viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)
        viewModel.getDataFromRoom(countryUuid)

        observeLiveData()
    }

    private fun observeLiveData(){
        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer { country ->
            country?.let {

                binding.selectedCountry = country

            }
        })
    }
}