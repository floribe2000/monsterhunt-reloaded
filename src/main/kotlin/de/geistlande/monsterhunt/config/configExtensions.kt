package de.geistlande.monsterhunt.config

import de.geistlande.monsterhunt.data.MobKillCause

fun WorldSettings.findMobPoints(mobName: String, cause: MobKillCause = MobKillCause.Regular): Int {
    return mobSettings.mobPoints[mobName.lowercase()]?.let {
        when (cause) {
            MobKillCause.Regular -> it.regular
            MobKillCause.Projectile -> it.projectile
            MobKillCause.Snowball -> it.snowball
            MobKillCause.Wolf -> it.wolf
            MobKillCause.GoldenSword -> it.goldenSword
            MobKillCause.Hands -> it.hands
        }
    } ?: 0
}

fun RewardSettings.findMinPointsForPlace(place: Int): Int {
    return if (place > minimumPointsPlace.lastIndex) {
        minimumPointsPlace.last()
    } else {
        minimumPointsPlace[place]
    }
}
