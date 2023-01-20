package com.arincatlamaz.countryinfo.service

import com.arincatlamaz.countryinfo.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryAPI {
    @GET(value = "")
    fun getCountries() : Single<List<Country>>
}