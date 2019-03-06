package com.kotlinkariam.restEndpoints

import com.kotlinkariam.EndpointDataModels.Building.CreateBuilding
import com.kotlinkariam.Enums.BuildingTypes
import com.kotlinkariam.model.Building
import com.kotlinkariam.worldState
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post
import io.ktor.routing.route

fun Route.createBuilding() {
    route("/building") {
        post {
            var createBuilding = call.receive<CreateBuilding>()
            var building = Building(createBuilding.type as BuildingTypes)
            worldState.islandList[0].cities[0].buildings.add(building)
            call.respond(HttpStatusCode.Created)
        }
    }
}