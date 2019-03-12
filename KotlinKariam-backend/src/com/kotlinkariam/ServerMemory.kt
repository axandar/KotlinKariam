package com.kotlinkariam

import com.kotlinkariam.model.City
import com.kotlinkariam.model.Island
import com.kotlinkariam.model.World

class ServerMemory constructor(var worlds: HashMap<Long, World>){
    fun getWorldByID(worldID:Long): World? {
        return worlds[worldID]
    }

    fun getIslandByID(islandID: Int, worldID: Long): Island? {
        return worlds[worldID]?.islandList?.get(islandID)
    }

    fun getCityByID(cityID: Int, islandID: Int, worldID: Long): City? {
        return worlds[worldID]?.islandList?.get(islandID)?.cities?.get(cityID)
    }
}