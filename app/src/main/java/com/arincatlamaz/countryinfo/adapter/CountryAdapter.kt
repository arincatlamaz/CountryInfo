package com.arincatlamaz.countryinfo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.arincatlamaz.countryinfo.R
import com.arincatlamaz.countryinfo.databinding.ItemCountryBinding
import com.arincatlamaz.countryinfo.model.Country
import com.arincatlamaz.countryinfo.util.downloadFromUrl
import com.arincatlamaz.countryinfo.util.placeholderProgressBar
import com.arincatlamaz.countryinfo.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(val countryList : ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(), CountryClickListener {

    class CountryViewHolder(val view : ItemCountryBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val binding = ItemCountryBinding.inflate(inflater,parent,false)

        val view = DataBindingUtil.inflate<ItemCountryBinding>(inflater, R.layout.item_country,parent,false)

        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.view.country = countryList[position]
        holder.view.listener = this

        /*holder.binding.name.text = countryList[position].countryName
        holder.binding.region.text = countryList[position].countryRegion
        holder.itemView.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(countryList[position].uuid)
            Navigation.findNavController(it).navigate(action)
        }
        holder.binding.imageView.downloadFromUrl(countryList[position].imageUrl,
            placeholderProgressBar(holder.binding.root.context)
        )*/
    }

    fun updateCountryList(newCountryList: List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

    override fun onCountryClicked(v: View) {

        val uuid = v.countryUuidText.text.toString().toInt()
        val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(uuid)
        Navigation.findNavController(v).navigate(action)

    }


}