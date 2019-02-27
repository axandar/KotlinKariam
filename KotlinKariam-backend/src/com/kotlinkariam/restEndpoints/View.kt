package com.kotlinkariam.restEndpoints

import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route



fun Route.view(){
    route("/world"){
        get{

        }
    }
}