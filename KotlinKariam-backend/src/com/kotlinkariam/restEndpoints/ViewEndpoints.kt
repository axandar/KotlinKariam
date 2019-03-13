package com.kotlinkariam.restEndpoints

import com.kotlinkariam.model.City
import com.kotlinkariam.model.Island
import com.kotlinkariam.model.World
import com.kotlinkariam.serverMemory
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.post


fun Route.worldView() {
    route("/createWorld/{worldName}"){
        post{
            val worldName: String = call.parameters["worldName"] ?: return@post
            serverMemory.createWorld(worldName)
        }
    }

    route("/{worldID}"){
        get {
            val worldID: String = call.parameters["worldID"] ?: return@get
            val world: World? = serverMemory.getWorldByID(worldID.toLong())

            if(world == null){
                call.respondText("World with id $worldID has not been found")
            }else {
                call.respond(world)
            }
        }

        route("/createIsland/{islandName}"){
            post{
                val worldID: String = call.parameters["worldID"] ?: return@post
                val islandName: String = call.parameters["islandName"] ?: return@post
                serverMemory.createIslandInWorld(islandName, worldID.toLong())
            }
        }
    }
}

fun Route.islandView() {
    route("/{worldID}/{islandID}"){
        get {
            val worldID: String = call.parameters["worldID"] ?: return@get
            val islandID: String = call.parameters["islandID"] ?: return@get

            val island: Island? = serverMemory.getIslandByID(islandID.toInt(), worldID.toLong())

            if(island == null){
                call.respondText("Island with world id $worldID and island id $islandID " +
                        "has not been found")
            }else {
                call.respond(island)
            }
        }

        route("/createCity/{cityName}"){
            post{
                val worldID: String = call.parameters["worldID"] ?: return@post
                val islandID: String = call.parameters["islandID"] ?: return@post
                val cityName: String = call.parameters["cityName"] ?: return@post
                serverMemory.createCityInIsland(cityName, worldID.toLong(), islandID.toInt())
            }
        }
    }
}

fun Route.cityView() {
    route("/{worldID}/{islandID}/{cityID}"){
        get {
            val worldID: String = call.parameters["worldID"] ?: return@get
            val islandID: String = call.parameters["islandID"] ?: return@get
            val cityID: String = call.parameters["cityID"] ?: return@get

            val city: City? = serverMemory.getCityByID(cityID.toInt(), islandID.toInt(),
                worldID.toLong())

            if(city == null){
                call.respondText("Island with world id $worldID and island id $islandID " +
                        " and cityID $cityID has not been found")
            }else {
                call.respond(city)
            }
        }
    }
}