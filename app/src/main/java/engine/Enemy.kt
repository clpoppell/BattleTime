package engine

const val DEFAULT_ENEMY_NAME= "???"

class Enemy(name: String= DEFAULT_ENEMY_NAME,
			maximumHitPoints: Int,
			strength: Int,
			stamina: Int,
			status: Status= Status.Normal,
			val desc: String,
			val rewardExperiencePoints: Int,
			val rewardGold: Int
	): Creature(name, maximumHitPoints, maximumHitPoints, strength, stamina, status){

	override fun toString(): String{
		return super.toString() + """|
									 |$desc
									 |Exp Rewarded: $rewardExperiencePoints
									 |Gold Rewarded: $rewardGold""".trimMargin()
	}
}