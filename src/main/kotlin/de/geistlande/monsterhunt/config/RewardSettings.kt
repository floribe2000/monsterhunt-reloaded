package de.geistlande.monsterhunt.config

import kotlinx.serialization.Serializable
import org.bukkit.Material

@Serializable
data class RewardSettings(
    val enabled: Boolean = true,
    val enableRewardEveryonePermission: Boolean = false,
    val rewardEveryone: Boolean = false,
    val numberOfWinners: Int = 3,
    val rewardParametersEveryone: String = "3 1-1",
    val minimumPointsEveryone: Int = 1,
    val minimumPointsPlace: List<Int> = listOf(1, 1, 1),
    val rewardParametersPlace: String = "",
    val availableRewards: List<RewardGroup> = listOf(),
)

@Serializable
data class RewardGroup(
    val name: String,
    val items: List<RewardElement>,
)

/**
 * Defines the interface of a single reward element.
 * A reward element defines a possible reward a player can receive for winning the monster hunt.
 */
@Serializable
sealed interface RewardElement {
    /**
     * The stochastic weight of the element.
     */
    val stochasticWeight: Int

    /**
     * A list of ranks this reward is available for.
     */
    val availableForRanks: List<Int>

    /**
     * Defines a multiplier for the reward reduction per rank.
     * The effective reward amount is calculated as *rewardAmount * (reductionFactor ^ rankIndex)*
     * with rankIndex being the zero-based index of the player's rank (index for the winner, rank 1, is 0).
     */
    val reductionFactor: Double
}

@Serializable
data class MoneyReward(
    override val stochasticWeight: Int = 1,
    override val availableForRanks: List<Int> = listOf(),
    override val reductionFactor: Double = 0.75,
    val amount: Double = 10.0,
) : RewardElement

@Serializable
data class MaterialReward(
    override val stochasticWeight: Int = 1,
    override val availableForRanks: List<Int> = listOf(),
    override val reductionFactor: Double = 0.7,
    val material: Material,
    val amount: Int,
) : RewardElement
