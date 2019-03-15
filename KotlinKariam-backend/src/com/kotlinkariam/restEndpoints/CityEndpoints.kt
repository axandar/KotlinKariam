package com.kotlinkariam.restEndpoints

import com.kotlinkariam.model.City
import com.kotlinkariam.serverMemory
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route

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