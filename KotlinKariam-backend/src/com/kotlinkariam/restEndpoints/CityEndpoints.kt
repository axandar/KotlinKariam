package com.kotlinkariam.restEndpoints

import com.kotlinkariam.model.Building
import com.kotlinkariam.model.City
import com.kotlinkariam.worldState
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post
import io.ktor.routing.route

fun Route.create() {
    route("/create") {
        post() {
            var buildings = mutableListOf<Building>()
            var city = City("MyCity", buildings)
            worldState.islandList[0].cities.add(city)
            call.respond(HttpStatusCode.Created)
        }
    }
}