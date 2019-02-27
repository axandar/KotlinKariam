import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.post
import io.ktor.routing.route

fun Route.playerHandler(){
    route("/playerHandler"){
        post("/buildOnPlayerInTown/{playerId}/{townId}/{buildableId}"){
            val playerId = call.parameters["playerId"]
            val buildableId = call.parameters["buildableId"]
            val townId = call.parameters["townId"]

            call.respondText("Player bit found")
        }
    }
}