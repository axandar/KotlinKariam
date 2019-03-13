package com.kotlinkariam

import com.kotlinkariam.model.City
import com.kotlinkariam.model.Island
import com.kotlinkariam.model.World

class ServerMemory constructor(var worlds: HashMap<Long, World>){
    fun getWorldByID(worldID: Long): World? {
        return worlds[worldID]
    }

    fun getIslandByID(islandID: Int, worldID: Long): Island? {
        return worlds[worldID]?.islandList?.get(islandID)
    }

    fun getCityByID(cityID: Int, islandID: Int, worldID: Long): City? {
        return worlds[worldID]?.islandList?.get(islandID)?.cityList?.get(cityID)
    }

    fun createWorld(worldName:String){
        val id: Long = worlds.size.toLong()
        val newWorld = World(worldName, mutableListOf())
        worlds.put(id, newWorld)
    }
    //todo metody tworzace z parametrami gotowych obiektow? (aby nie wywolywac funkcji get*ByID)
    fun createIslandInWorld(islandName: String, worldID: Long){
        val actualIslands = getWorldByID(worldID)?.islandList ?: return //todo throw exception?
        val id = actualIslands.size
        actualIslands.add(id, Island(islandName, mutableListOf()))
    }

    fun createCityInIsland(cityName: String, worldID: Long, islandID: Int){
        val actualCities = getIslandByID(islandID, worldID)?.cityList ?: return //todo throw exception?
        val id = actualCities.size
        actualCities.add(id, City(cityName))
    }
}