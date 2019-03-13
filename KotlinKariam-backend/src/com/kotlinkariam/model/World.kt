package com.kotlinkariam.model

class World(worldName: String, islandList: MutableList<Island>) {

    var worldName: String = worldName
        private set

    var islandList: MutableList<Island> = islandList
        private set
}

