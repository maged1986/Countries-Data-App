package com.magednan.countriesdataapp.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.magednan.countriesdataapp.data.dtos.Flags
import com.magednan.countriesdataapp.data.dtos.Maps
import com.magednan.countriesdataapp.data.dtos.Name


class CountriesTypeConverts {
    @TypeConverter
    fun fromListToString(list: String): List<String>? {
        val listType = object :
            TypeToken<List<String>?>() {}.type
        return Gson().fromJson<List<String>>(list, listType)
    }

    @TypeConverter
    fun fromStringToList(list: List<String>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }


    @TypeConverter
    fun fromStringToLatLang(list: String): List<Double>? {
        val listType = object :
            TypeToken<List<Double>?>() {}.type
        return Gson().fromJson<List<Double>>(list, listType)
    }

    @TypeConverter
    fun fromLatLangToString(list: List<Double>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromStringToFlags(flagsStr: String): Flags {
        val flags = object : TypeToken<Flags>() {}.type
        return Gson().fromJson<Flags>(flagsStr, flags)
    }

    @TypeConverter
    fun fromFlagsToString(flags: Flags): String {
        return Gson().toJson(flags)
    }

    @TypeConverter
    fun fromStringToMaps(mapsStr: String): Maps {
        val maps = object : TypeToken<Maps>() {}.type
        return Gson().fromJson(mapsStr, maps)
    }

    @TypeConverter
    fun fromMapsToString(maps: Maps): String {
        return Gson().toJson(maps)
    }

    @TypeConverter
    fun fromStringToName(nameStr: String): Name {
        val name = object : TypeToken<Name>() {}.type
        return Gson().fromJson(nameStr, name)
    }

    @TypeConverter
    fun fromNameToString(name: Name): String {
        return Gson().toJson(name)
    }
}



