package com.babylon.mesquita.interview.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Feature(
    @Expose
    @SerializedName("name")
    private var statusCode: String,

    @Expose
    @SerializedName("surname")
    private var message: String
)