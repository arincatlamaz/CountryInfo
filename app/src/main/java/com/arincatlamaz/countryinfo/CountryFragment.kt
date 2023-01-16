package com.arincatlamaz.countryinfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arincatlamaz.countryinfo.databinding.FragmentCountryBinding
import com.arincatlamaz.countryinfo.databinding.FragmentCountryBindingImpl

private var countryUuid = 0
private lateinit var binding: FragmentCountryBinding
class CountryFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCountryBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments.let {

        }

        super.onViewCreated(view, savedInstanceState)
    }
}