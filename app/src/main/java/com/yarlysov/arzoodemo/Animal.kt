package com.yarlysov.arzoodemo

data class Animal(val name:String, val animalId: String, var modell: String) {
    public fun getId(): String {
        return this.animalId
    }
    public fun getModel(): String {
        return this.modell
    }
}


