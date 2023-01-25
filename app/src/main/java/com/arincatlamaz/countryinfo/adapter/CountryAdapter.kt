package com.arincatlamaz.countryinfo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.arincatlamaz.countryinfo.databinding.ItemCountryBinding
import com.arincatlamaz.countryinfo.model.Country
import com.arincatlamaz.countryinfo.util.downloadFromUrl
import com.arincatlamaz.countryinfo.util.placeholderProgressBar
import com.arincatlamaz.countryinfo.view.FeedFragmentDirections

class CountryAdapter(val countryList : ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(val binding : ItemCountryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCountryBinding.inflate(layoutInflater,parent,false)

        return CountryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.binding.name.text = countryList[position].countryName
        holder.binding.region.text = countryList[position].countryRegion
        holder.itemView.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(countryList[position].uuid)
            Navigation.findNavController(it).navigate(action)
        }
        holder.binding.imageView.downloadFromUrl(countryList[position].imageUrl,
            placeholderProgressBar(holder.binding.root.context)
        )
    }

    fun updateCountryList(newCountryList: List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }


}