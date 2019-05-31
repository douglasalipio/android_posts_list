package com.babylon.mesquita.interview.data.local

import androidx.room.TypeConverter
import com.babylon.mesquita.interview.data.remote.*
import com.google.gson.Gson

class ResultConvert {
    @TypeConverter
    fun appToString(app: Result): String = Gson().toJson(app)

    @TypeConverter
    fun stringToApp(string: String): Result = Gson().fromJson(string, Result::class.java)
}

class CompanyConvert {
    @TypeConverter
    fun appToString(app: Company): String = Gson().toJson(app)

    @TypeConverter
    fun stringToApp(string: String): Company = Gson().fromJson(string, Company::class.java)
}

class GeoConvert {
    @TypeConverter
    fun appToString(app: Geo): String = Gson().toJson(app)

    @TypeConverter
    fun stringToApp(string: String): Geo = Gson().fromJson(string, Geo::class.java)
}

class AddressConvert {
    @TypeConverter
    fun appToString(app: Company): String = Gson().toJson(app)

    @TypeConverter
    fun stringToApp(string: String): Address = Gson().fromJson(string, Address::class.java)
}

class PictureConvert {
    @TypeConverter
    fun appToString(app: Company): String = Gson().toJson(app)

    @TypeConverter
    fun stringToApp(string: String): Picture = Gson().fromJson(string, Picture::class.java)
}
