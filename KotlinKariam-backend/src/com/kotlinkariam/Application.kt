package com.kotlinkariam

import com.fasterxml.jackson.core.util.DefaultIndenter
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.SerializationFeature
import com.kotlinkariam.restEndpoints.routes
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson
import io.ktor.server.engine.applicationEngineEnvironment
import io.ktor.server.engine.connector
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

var serverMemory = ServerMemory(ServerStateInitializer.generateWorlds())

fun main() {
    val env = applicationEngineEnvironment {
        module {
            install(ContentNegotiation) {
                jackson {
                    configure(SerializationFeature.INDENT_OUTPUT, true)
                    configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, true)
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