package de.geistlande.monsterhunt.hunt

interface HuntWorld {
    val name: String
    val status: HuntStatus

    fun shouldStartSignup(time: Long): Boolean

    fun shouldStartHunt(time: Long): Boolean

    fun shouldStopHunt(time: Long): Boolean
}
