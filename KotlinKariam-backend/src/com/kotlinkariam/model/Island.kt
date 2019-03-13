package com.kotlinkariam.model

class Island(islandName: String, cityList: MutableList<City>){

    var islandName: String = islandName
        private set

    var cityList: MutableList<City> = cityList
        private set
}