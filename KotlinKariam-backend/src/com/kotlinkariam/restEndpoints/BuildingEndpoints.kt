package com.kotlinkariam.restEndpoints

import com.kotlinkariam.dataTransferObjects.BuildingModel
import com.kotlinkariam.serverMemory
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.routing.Route
import io.ktor.routing.post
import io.ktor.routing.route

fun Route.buildingView() {
    route("/{worldID}/{islandID}/{cityID}") {
        post {
            val worldID: String = call.parameters["worldID"] ?: return@post
            val islandID: String = call.parameters["islandID"] ?: return@post
            val cityID: String = call.parameters["cityID"] ?: return@post

            val buildingModel = call.receive<BuildingModel>()
            serverMemory.createBuilding(buildingModel.buildingType, worldID.toInt(), islandID.toInt(), cityID.toLong())
        }
    }
}