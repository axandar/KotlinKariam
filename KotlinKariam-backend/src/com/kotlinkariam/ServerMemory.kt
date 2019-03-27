package com.kotlinkariam

import com.kotlinkariam.Enums.BuildingTypes
import com.kotlinkariam.model.Building
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

    fun createBuilding(type: BuildingTypes, cityID: Int, islandID: Int, worldID: Long){
        val actualBuildings = getCityByID(cityID, islandID, worldID)?.buildings ?:return //todo throw exception
        val id = actualBuildings?.size
        actualBuildings.add(id, Building(type))
    }
}