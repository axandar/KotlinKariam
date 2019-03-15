package com.kotlinkariam.restEndpoints

import com.kotlinkariam.model.Island
import com.kotlinkariam.serverMemory
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route

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