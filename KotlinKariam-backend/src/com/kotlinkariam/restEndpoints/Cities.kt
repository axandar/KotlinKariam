package com.kotlinkariam.restEndpoints

import com.kotlinkariam.model.Building
import com.kotlinkariam.model.City
import com.kotlinkariam.worldState
import io.ktor.routing.Route
import io.ktor.routing.post
import io.ktor.routing.route

fun Route.create() {
    route("/create") {
        post() {
            val buildings = mutableListOf<Building>()
            var city = City("MyCity", buildings)
            worldState.
        }
    }
}