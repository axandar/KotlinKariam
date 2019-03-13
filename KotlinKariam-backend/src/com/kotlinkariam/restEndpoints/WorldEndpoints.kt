package com.kotlinkariam.restEndpoints

import com.kotlinkariam.model.World
import com.kotlinkariam.serverMemory
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route

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