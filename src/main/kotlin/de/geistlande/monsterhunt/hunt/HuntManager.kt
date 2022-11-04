package de.geistlande.monsterhunt.hunt

interface HuntManager {

    fun findWorld(name: String): HuntWorld

    fun listWorlds(): Collection<HuntWorld>

    fun registerWorld(world: HuntWorld)

    fun startWorldTimer()

    fun stopWorldTimer()
}
