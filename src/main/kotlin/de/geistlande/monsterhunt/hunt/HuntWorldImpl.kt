package de.geistlande.monsterhunt.hunt

import de.geistlande.monsterhunt.config.WorldSettings
import org.bukkit.Server

class HuntWorldImpl(override val name: String, private val server: Server, private val worldSettings: WorldSettings) : HuntWorld {
    override var status: HuntStatus = HuntStatus.Inactive
        private set

    override fun shouldStartSignup(time: Long): Boolean {
        if (status != HuntStatus.Inactive) return false

        return time >= worldSettings.signupPeriodTime && time < worldSettings.startTime
    }

    override fun shouldStartHunt(time: Long): Boolean {
        if (status == HuntStatus.Active) return false

        return time >= worldSettings.startTime
    }

    override fun shouldStopHunt(time: Long): Boolean {
        if (status != HuntStatus.Active) return false

        return time >= worldSettings.endTime || time < worldSettings.startTime
    }
}
