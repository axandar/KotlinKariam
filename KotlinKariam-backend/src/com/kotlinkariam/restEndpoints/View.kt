package com.kotlinkariam.restEndpoints

import com.kotlinkariam.worldState
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import io.ktor.application.call
import io.ktor.response.respond


fun Route.view(){
    route("/world"){
        get{
            call.respond(worldState)
        }
    }
}