package engine

/**
 * Super class for all in-game entities that can enter into battles.
 * <p> Allows all such entities to be stored in the same objects. </p>
 * @property
 */
abstract class Creature(
		open val name: String,
		open val maximumHP: Int,
		var currentHP: Int,
		open val strength: Int,
		open val stamina: Int,
		var status: Status= Status.Normal){

	/**
	 * Applies a change to [currentHP]. Keeps [currentHP] between 0 and [maximumHP].
	 * @param [value] amount to add to or subtract from [currentHP]
	 */
	fun changeCurrentHP(value: Int){
		currentHP += value
		if(currentHP < 0){ currentHP= 0 }
		else if(currentHP > maximumHP){ currentHP= maximumHP }
	}

	/** @return calculated attack power */
	open fun calculateAttackPower()= strength

	/** @return calculated defense value */
	open fun calculateDefenseValue()= stamina

	override fun toString()= """Name: $name
							   |Max HP: $maximumHP
							   |Current HP: $currentHP
							   |Status: $status
							   |Strength: $strength
							   |Atk Power: ${calculateAttackPower()}
							   |Stamina: $stamina
							   |Defense: ${calculateDefenseValue()}""".trimMargin()
}

enum class Status{
	Normal, Poisoned, Paralyzed
}