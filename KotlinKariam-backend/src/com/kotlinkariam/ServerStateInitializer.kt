package com.kotlinkariam

import com.kotlinkariam.model.Building
import com.kotlinkariam.model.City
import com.kotlinkariam.model.Island
import com.kotlinkariam.model.World

class ServerStateInitializer{

    companion object {
        fun generateWorlds(): HashMap<Long, World> {
            val world = generateWorld()
            val map = hashMapOf<Long, World>()
            map[1000] = world
            return map
        }

        private fun generateWorld(): World {
            val city = City("test")
            val cities = mutableListOf(city)
            val island = Island("Kotlinhos", cities)
            val islands = mutableListOf<Island>()
            islands.add(island)

            return World(islands)
        }
    }
}