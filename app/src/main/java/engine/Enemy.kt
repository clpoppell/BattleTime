package engine

/** Default name for enemies, to be used if name is not provided. */
const val DEFAULT_ENEMY_NAME= "???"

/**
 * Defines enemy objects used for battles.
 *
 * @property desc description of enemy.
 * @property rewardExperiencePoints amount of experience to be rewarded upon defeating enemy.
 * @property rewardGold amount of gold to be rewarded upon defeating enemy.
 * @constructor Creates an enemy using the specified values.
 */
class Enemy(name: String= DEFAULT_ENEMY_NAME,
			maximumHitPoints: Int,
			strength: Int,
			stamina: Int,
			status: Status= Status.NORMAL,
			val desc: String,
			val rewardExperiencePoints: Int,
			val rewardGold: Int
	): Creature(name, maximumHitPoints, maximumHitPoints, strength, stamina, status){

	/** @suppress */
	override fun toString(): String{
		return super.toString() + """|
									 |$desc
									 |Exp Rewarded: $rewardExperiencePoints
									 |Gold Rewarded: $rewardGold""".trimMargin()
	}
}