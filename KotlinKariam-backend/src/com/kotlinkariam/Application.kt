package com.kotlinkariam

import com.fasterxml.jackson.core.util.DefaultIndenter
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.databind.SerializationFeature
import com.kotlinkariam.model.World
import com.kotlinkariam.restEndpoints.view
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson
import io.ktor.routing.route
import io.ktor.routing.routing
import io.ktor.server.engine.applicationEngineEnvironment
import io.ktor.server.engine.connector
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

var worldState = World(emptyList())

fun main(args: Array<String>) {
    val env = applicationEngineEnvironment {
        module {
            install(ContentNegotiation) {
                jackson {
                    configure(SerializationFeature.INDENT_OUTPUT, true)
                    setDefaultPrettyPrinter(DefaultPrettyPrinter().apply {
                        indentArraysWith(DefaultPrettyPrinter.FixedSpaceIndenter.instance)
                        indentObjectsWith(DefaultIndenter("  ", "\n"))
                    })
                }
            }
            routes()
        }

        connector {
            host = "127.0.0.1"
            port = 8080
        }
    }

    embeddedServer(Netty, env).start(wait = true)
}

fun Application.routes(){
    routing {
        route("/playerHandler"){
            playerHandler()
        }

        route("/view"){
            view()
        }
    }
}
