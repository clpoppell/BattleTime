package engine

/** Default name for player characters, to be used if name is not provided. */
const val DEFAULT_PLAYER_NAME= "Lee"

/**
 * Defines player character objects.
 *
 * @constructor Creates a player character using the specified values.
 *
 * @param [currentHP] the current hit points value for this creature. If no value provided, uses [maximumHP].
 */
class PlayerCharacter(
		override var name: String= DEFAULT_PLAYER_NAME,
		override var maximumHP: Int,
		currentHP: Int= maximumHP,
		override var strength: Int,
		override var stamina: Int
	): Creature(name, maximumHP, currentHP, strength, stamina){


	override fun calculateAttackPower()= strength * 5 //TODO make actual calculation


	override fun calculateDefenseValue()= stamina * 5 //TODO make actual calculation
}