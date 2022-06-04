package com.magednan.countriesdataapp.data.mapper

import com.magednan.countriesdataapp.data.dtos.CountryInfoResponseItem
import com.magednan.countriesdataapp.data.dtos.Flags
import com.magednan.countriesdataapp.data.dtos.Maps
import com.magednan.countriesdataapp.data.dtos.Name
import com.magednan.countriesdataapp.domain.models.DomainFlags
import com.magednan.countriesdataapp.domain.models.DomainItem
import com.magednan.countriesdataapp.domain.models.DomainMaps
import com.magednan.countriesdataapp.domain.models.DomainName


fun CountryInfoResponseItem.toDomainItem(): DomainItem {
    return DomainItem(
        area = area,
        borders = borders,
        capital = capital,
        continents = continents,
        fifa = fifa,
        flag = flag,
        flags = flags?.toDomainFlags(),
        independent = independent,
        landlocked = landlocked,
        latlng = latlng,
        maps = maps?.toDomainMaps(),
        name = name?.toDomainName(),
        population = population,
        region = region,
        startOfWeek = startOfWeek,
        status = status,
        subregion = subregion,
        timezones = timezones,
        tld = tld,
        unMember = unMember
    )
}

fun DomainItem.toCountryInfoResponseItem(): CountryInfoResponseItem {
    return CountryInfoResponseItem(
        0, area = area,
        borders = borders,
        capital = capital,
        continents = continents,
        fifa = fifa,
        flag = flag,
        flags = flags?.toFlags(),
        independent = independent,
        landlocked = landlocked,
        latlng = latlng,
        maps = maps?.toMaps(),
        name = name?.toName(),
        population = population,
        region = region,
        startOfWeek = startOfWeek,
        status = status,
        subregion = subregion,
        timezones = timezones,
        tld = tld,
        unMember = unMember
    )
}

fun Maps.toDomainMaps(): DomainMaps {
    return DomainMaps(
        googleMaps = googleMaps,
        openStreetMaps = openStreetMaps
    )
}

fun DomainMaps.toMaps(): Maps {
    return Maps(googleMaps = googleMaps,
        openStreetMaps = openStreetMaps)
}

fun Name.toDomainName(): DomainName {
    return DomainName(common = common,
        official = official,
        symbol = symbol)
}

fun DomainName.toName(): Name {
    return Name(
        common = common,
        official = official,
        symbol = symbol
    )
}

fun Flags.toDomainFlags(): DomainFlags {
    return DomainFlags(
        png = png,
        svg = svg
    )
}

fun DomainFlags.toFlags(): Flags {
    return Flags(
        png = png,
        svg = svg
    )
}