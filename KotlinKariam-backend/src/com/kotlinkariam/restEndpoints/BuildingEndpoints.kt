package com.kotlinkariam.restEndpoints

import com.kotlinkariam.Enums.BuildingTypes
import com.kotlinkariam.model.Building
import com.kotlinkariam.worldState
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post
import io.ktor.routing.route

fun Route.createBuilding() {
    route("/building") {
        post {
            //w tym momencie ustawiam na sztywno magazyn jako ze nie obslugujemy jeszcze jsonów a magazynów moze byc ile chcesz
            var building = Building(BuildingTypes.Magazine)
            worldState.islandList[0].cities[0].buildings.add(building)
            call.respond(HttpStatusCode.Created)
        }
    }
}