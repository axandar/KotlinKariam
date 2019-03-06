package com.kotlinkariam.model

import com.kotlinkariam.Enums.BuildingTypes

class City (var name: String, var buildings: MutableList<Building>) {

    init {
        buildings.add(Building(BuildingTypes.CityHall))
    }

}