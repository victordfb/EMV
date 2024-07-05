package com.smartfuturelabs.emv

open class ComposedDataObject(
    private val id: String
) : DataObject() {

    private val dataObjects = mutableListOf<DataObject>()

    fun add(dataObject: DataObject) {
        this.dataObjects.add(dataObject)
    }

    override fun getId(): String {
        return this.id
    }

    override fun getSize(): String {
        return String.format("%0${2}d", this.getContent().length)
    }

    override fun getContent(): String {
        return this.dataObjects.joinToString(separator = "") { it.generateCode() }
    }
}
