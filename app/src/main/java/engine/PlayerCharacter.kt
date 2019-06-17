package engine

class PlayerCharacter(override var name: String, override var maximumHitPoints: Int, override var strength: Int, override var stamina: Int):
		Creature(name, maximumHitPoints, strength, stamina){
	var currentHP: Int= maximumHitPoints

	fun changeCurrentHP(value: Int){
		currentHP += value
		if(currentHP < 0){ currentHP= 0 }
	}

	override fun toString(): String {
		return """Name: $name
				 |Max HP: $maximumHitPoints
				 |Current HP: $currentHP
				 |Strength: $strength
				 |Stamina: $stamina""".trimMargin()
	}
}