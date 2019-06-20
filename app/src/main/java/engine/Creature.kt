package engine

/**
 * Super class for all in-game entities that can enter into battles.
 * <p> Allows all such entities to be stored in the same objects. </p>
 *
 * @property [name] the name of the creature.
 * @property [maximumHP] the maximum hit points value for this creature.
 * @property [currentHP] the current hit points value for this creature.
 * @property [strength] the physical attack value for this creature.
 * @property [stamina] the physical defense value for this creature.
 * @property [status] the condition applied to this creature.
 */
abstract class Creature(
		open val name: String,
		open val maximumHP: Int,
		var currentHP: Int,
		open val strength: Int,
		open val stamina: Int,
		var status: Status= Status.NORMAL){

	/** Changes [currentHP] by [value], keeping it between 0 and [maximumHP]. */
	fun changeCurrentHP(value: Int){
		currentHP += value
		if(currentHP < 0){ currentHP= 0 }
		else if(currentHP > maximumHP){ currentHP= maximumHP }
	}

	/** Returns calculated attack power. */
	open fun calculateAttackPower()= strength

	/** Returns calculated defense value. */
	open fun calculateDefenseValue()= stamina

	/** @suppress */
	override fun toString()= """Name: $name
							   |Max HP: $maximumHP
							   |Current HP: $currentHP
							   |Status: ${status.statusTitle}
							   |Strength: $strength
							   |Atk Power: ${calculateAttackPower()}
							   |Stamina: $stamina
							   |Defense: ${calculateDefenseValue()}""".trimMargin()
}

/**
 * Status conditions to apply in battle.
 * @property [statusTitle] display name for associated status.
 */
enum class Status(val statusTitle: String){
	NORMAL("Normal"), POISONED("Poisoned"), PARALYZED("Paralyzed")
}