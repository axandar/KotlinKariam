package com.kotlinkariam.model

import com.kotlinkariam.Enums.BuildingTypes

class City (val name: String) {

    lateinit var buildings: MutableList<Building>

    init {
        buildings.add(Building(BuildingTypes.CityHall))
    }

}