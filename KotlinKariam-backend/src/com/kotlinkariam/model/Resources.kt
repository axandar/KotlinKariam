package com.kotlinkariam.model

class Resources(wood: Int, stone: Int, crystal: Int, sulfur: Int){
    var wood: Int = wood
        private set
    var stone: Int = stone
        private set
    var crystal: Int = crystal
        private set
    var sulfur: Int = sulfur
        private set

    fun addResources(resources: Resources){
        wood += resources.wood
        stone += resources.stone
        crystal += resources.crystal
        sulfur += resources.sulfur
    }

    fun removeResources(resources: Resources){
        wood -= resources.wood
        stone -= resources.stone
        crystal -= resources.crystal
        sulfur -= resources.sulfur
    }

    fun isResourcesLargeEnough(resources: Resources): Boolean{
        if(resources.wood > wood){
            return false
        }
        if(resources.stone > stone){
            return false
        }
        if(resources.crystal > crystal){
            return false
        }
        if(resources.sulfur > sulfur){
            return false
        }

        return true
    }

    override fun toString(): String {
        return "Resources(wood=$wood, stone=$stone, crystal=$crystal, sulfur=$sulfur)"
    }
}