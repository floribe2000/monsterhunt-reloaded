package de.geistlande.monsterhunt.config

import kotlinx.serialization.Serializable

@Serializable
data class WorldSettings(
    val enabled: Boolean = true,
    val startTime: Int = 13000,
    val endTime: Int = 23600,
    val tellTime: Boolean = true,
    val deathPenalty: Int = 30,
    val enableSignup: Boolean = true,
    val announceSignup: Boolean = true,
    val announceLead: Boolean = true,
    val minimumPlayers: Int = 2,
    val startChance: Int = 100,
    val skipDays: Int = 0,
    val skipToIfFailsToStart: Int = -1,
    val signupPeriodTime: Int = 5,
    val allowSignupAfterStart: Boolean = false,
    val huntZoneMode: Boolean = false,
    val mobSettings: MobSettings = MobSettings(),
    val rewardSettings: RewardSettings = RewardSettings(),
)
