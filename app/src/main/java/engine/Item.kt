package engine

/** Sale price value used for items which cannot be sold to shops. */
const val UNSELLABLE_ITEM_PRICE= -1
/** Default sale price multiplier, to be used if sale price value is provided. */
const val DEFAULT_SALE_PRICE_MULT= 0.5
/** Default name for enemies, to be used if name is not provided. */
const val DEFAULT_ITEM_NAME= "???"

/**
 * Super class for all item classes.
 *
 * @property name the item name.
 * @property namePlural the plural form of the item name.
 * @property desc the description of this item.
 * @property price the price value for this item.
 * @property salePriceMultiplier the sale price multiplier for this item.
 */
abstract class BaseItem(
		var name: String= DEFAULT_ITEM_NAME,
		var namePlural: String= DEFAULT_ITEM_NAME,
		var desc: String= "",
		var price: Int= 0,
		var salePriceMultiplier: Double= DEFAULT_SALE_PRICE_MULT)

/** Super class for all items that can be equipped to enhance the player character. */
abstract class EquipableItem: BaseItem()

/**
 * Used for equipable items that modify the attack power attribute of the player character.
 * @see [PlayerCharacter.calculateAttackPower]
 *
 * @property damageMod the multiplier for damage calculation.
 */
data class Weapon(var damageMod: Double= 1.0): EquipableItem()

/**
 * Used for equipable items that modify the player character's defense value.
 * @see [PlayerCharacter.calculateDefenseValue]
 *
 * @property armorMod the multiplier for defense calculation.
 */
data class Armor(var armorMod: Double= 1.0): EquipableItem()

