package com.arincatlamaz.countryinfo.model

import com.google.gson.annotations.SerializedName

data class Country (
    @SerializedName(value = "name") val countryName : String?,
    @SerializedName(value = "region") val countryRegion : String?,
    @SerializedName(value = "capital") val countryCapital : String?,
    @SerializedName(value = "currency") val countryCurrency : String?,
    @SerializedName(value = "language") val countryLanguage : String?,
    @SerializedName(value = "flag") val imageUrl : String?)