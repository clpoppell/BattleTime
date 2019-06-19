package engine

const val DEFAULT_PLAYER_NAME= "Lee"

class PlayerCharacter(
		override var name: String= DEFAULT_PLAYER_NAME,
		override var maximumHP: Int,
		currentHP: Int= maximumHP,
		override var strength: Int,
		override var stamina: Int
	): Creature(name, maximumHP, currentHP, strength, stamina){

	/**
	 *
	 */
	override fun calculateAttackPower()= strength * 5 //TODO make actual calculation

	override fun calculateDefenseValue()= stamina * 5 //TODO make actual calculation
}