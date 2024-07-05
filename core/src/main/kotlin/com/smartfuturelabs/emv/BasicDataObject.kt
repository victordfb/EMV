package com.smartfuturelabs.emv

open class BasicDataObject(
    private val id: String,
    private val value: String,
) : DataObject() {
    override fun getId() = this.id
    override fun getSize() = String.format("%0${2}d", this.getContent().length)
    override fun getContent() = value
}
