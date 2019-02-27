package com.kotlinkariam

import com.kotlinkariam.model.Building
import com.kotlinkariam.model.City
import com.kotlinkariam.model.Island
import com.kotlinkariam.model.World

class ServerStateInitializer{

    companion object {
        fun generateWorld(): World {
            val buildings = mutableListOf<Building>()

            val city = City("test", buildings)
            val cities = mutableListOf<City>()
            cities.add(city)

            val island = Island(cities)
            val islands = mutableListOf<Island>()
            islands.add(island)

            return World(islands)
        }
    }
}