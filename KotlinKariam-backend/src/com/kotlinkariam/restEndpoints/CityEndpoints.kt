package com.kotlinkariam.restEndpoints

import com.kotlinkariam.EndpointDataModels.City.CreateCity
import com.kotlinkariam.model.Building
import com.kotlinkariam.model.City
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post
import io.ktor.routing.route

fun Route.create() {
    route("/create") {
        post() {
            /*var createCity = call.receive<CreateCity>()
            var city = City(createCity.name)
            worldState.islandList[0].cities.add(city)*/
            call.respond(HttpStatusCode.Created)
        }
    }
}