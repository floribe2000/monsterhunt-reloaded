package de.geistlande.monsterhunt.config

import kotlinx.serialization.Serializable
import kotlin.math.roundToInt

@Serializable
data class MobSettings(
    val onlyCountMobsSpawnedOutside: Boolean = false,
    val outsideHeightCheck: Int = 0,
    val mobPoints: Map<String, MobPoints> = mapOf(),
)

@Serializable
data class MobPoints(
    val regular: Int,
    val projectile: Int = regular / 2,
    val snowball: Int = (regular * 1.5).roundToInt(),
    val wolf: Int = (regular * 0.75).roundToInt(),
    val goldenSword: Int = regular * 2,
    val hands: Int = (regular * 1.3).roundToInt(),
)
