package com.kotlinkariam.restEndpoints

import com.kotlinkariam.worldState
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import io.ktor.application.call
import io.ktor.response.respond


fun Route.worldView() {
    route("/world"){
        get {
            call.respond(worldState)
        }
    }
}

fun Route.islandView() {
    route("/island"){
        get {
            call.respond(worldState.islandList[0])
        }
    }
}

fun Route.cityView() {
    route("/city"){
        get {
            call.respond(worldState.islandList[0].cities[0])
        }
    }
}