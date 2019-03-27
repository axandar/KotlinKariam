package com.kotlinkariam.model


class City(cityName: String){
    var cityName: String = cityName
        private set
    var buildings: MutableList<Building> = mutableListOf()
        private set
    var resources: Resources = Resources(0, 0, 0, 0)
        private set


}