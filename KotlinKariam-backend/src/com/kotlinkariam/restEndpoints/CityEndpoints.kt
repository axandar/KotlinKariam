package com.kotlinkariam.restEndpoints

import com.kotlinkariam.model.City
import com.kotlinkariam.model.Resources
import com.kotlinkariam.serverMemory
import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route

fun Route.cityView() {
    route("/{worldID}/{islandID}/{cityID}"){
        fun ApplicationCall.getCity(): City?{
            val worldID: String = this.parameters["worldID"] ?: return null
            val islandID: String = this.parameters["islandID"] ?: return null
            val cityID: String = this.parameters["cityID"] ?: return null

            return serverMemory.getCityByID(cityID.toInt(), islandID.toInt(), worldID.toLong())
        }

        get {
            val city = call.getCity()
            if(city == null){
                call.respondText("City has not been found with parameter " +
                        "${call.parameters}")
            }else{
                call.respond(city)
            }
        }

        route("/resources"){
            fun ApplicationCall.getResources(): Resources{
                val queryParameters = this.request.queryParameters
                val wood: Int = queryParameters["wood"]?.toInt() ?: 0
                val stone: Int = queryParameters["stone"]?.toInt() ?: 0
                val crystal: Int = queryParameters["crystal"]?.toInt() ?: 0
                val sulfur: Int = queryParameters["sulfur"]?.toInt() ?: 0

                return Resources(wood, stone, crystal, sulfur)
            }

            post("/add"){
                val city = call.getCity()
                if(city == null){
                    call.respondText("City has not been found with parameter " +
                            "${call.parameters}")
                    return@post
                }

                val resources = call.getResources()
                city.resources.addResources(resources)
            }

            post("/remove"){
                val city = call.getCity()
                if(city == null){
                    call.respondText("City has not been found with parameter " +
                            "${call.parameters}")
                    return@post
                }

                val resources = call.getResources()
                val cityResources = city.resources
                if(cityResources.isResourcesLargeEnough(resources)){
                    cityResources.removeResources(resources)
                }else{
                    call.respondText("City resources: $cityResources are not large enough: " +
                            "$resources")
                }
            }
        }
    }
}