package com.arincatlamaz.countryinfo.service

import com.arincatlamaz.countryinfo.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryAPI {
    @GET(value = "arincatlamaz/API-Dataset/master/countrydataset.json")
    fun getCountries() : Single<List<Country>>
}