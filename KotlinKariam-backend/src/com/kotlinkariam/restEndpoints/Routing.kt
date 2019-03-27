package com.kotlinkariam.restEndpoints

import io.ktor.application.Application
import io.ktor.routing.route
import io.ktor.routing.routing

fun Application.routes(){
    routing {
        route("/world"){
            worldView()
        }

        route("/island"){
            islandView()
        }

        route("/city"){
            cityView()
        }

        route("/city"){
            buildingView()
        }
    }
}