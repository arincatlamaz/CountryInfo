package com.arincatlamaz.countryinfo.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arincatlamaz.countryinfo.R
import com.arincatlamaz.countryinfo.adapter.CountryAdapter
import com.arincatlamaz.countryinfo.databinding.FragmentFeedBinding
import com.arincatlamaz.countryinfo.model.Country
import com.arincatlamaz.countryinfo.viewmodel.FeedViewModel
import com.bumptech.glide.load.model.Model

class FeedFragment : Fragment() {

    private lateinit var viewModel: FeedViewModel
    private val countryAdapter = CountryAdapter(arrayListOf())

    private lateinit var binding : FragmentFeedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFeedBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        viewModel.refreshData()


        binding.countryList.layoutManager = LinearLayoutManager(context)
        binding.countryList.adapter = countryAdapter



        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.countryList.visibility = View.GONE
            binding.countryError.visibility = View.GONE
            binding.countryLoading.visibility = View.VISIBLE
            binding.swipeRefreshLayout.isRefreshing = false
            viewModel.refreshData()
        }

        observeLiveData()

    }

    private fun observeLiveData(){

        viewModel.countries.observe(viewLifecycleOwner, Observer {countries ->
            binding.countryList.visibility = View.VISIBLE
            countryAdapter.updateCountryList(countries)
        })


        viewModel.countryError.observe(viewLifecycleOwner, Observer { error ->

            error?.let {
                if (!it){

                    binding.countryError.visibility = View.GONE
                }
                else{
                    binding.countryError.visibility = View.VISIBLE
                }
            }
        })

        viewModel.countryLoading.observe(viewLifecycleOwner, Observer { loading ->

            loading?.let {
                if (!it){
                    binding.countryLoading.visibility = View.GONE
                }
                else{
                    binding.countryLoading.visibility = View.VISIBLE
                    binding.countryError.visibility = View.GONE
                    binding.countryList.visibility = View.GONE
                }
            }
        })

    }











}