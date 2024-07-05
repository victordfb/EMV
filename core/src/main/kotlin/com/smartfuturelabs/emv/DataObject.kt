package com.smartfuturelabs.emv

abstract class DataObject {

    abstract fun getId(): String
    abstract fun getSize(): String
    abstract fun getContent(): String

    fun generateCode(): String {
        val id = this.getId()
        val size = this.getSize()
        val content = this.getContent()
        return "$id$size$content"
    }
}
