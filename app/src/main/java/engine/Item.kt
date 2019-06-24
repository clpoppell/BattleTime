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
 * @property salePrice the sale price value for this item.
 */
abstract class BaseItem(
		val name: String= DEFAULT_ITEM_NAME,
		val namePlural: String= DEFAULT_ITEM_NAME,
		val desc: String= "",
		val price: Int= 0,
		val salePrice: Int= (price * DEFAULT_SALE_PRICE_MULT).toInt())

/** Super class for all items that can be equipped to enhance the player character. */
abstract class EquipableItem(
		name: String= DEFAULT_ITEM_NAME,
		namePlural: String= DEFAULT_ITEM_NAME,
		desc: String= "",
		price: Int= 0,
		salePrice: Int= (price * DEFAULT_SALE_PRICE_MULT).toInt()
	): BaseItem(name, namePlural, desc, price, salePrice)

/**
 * Used for equipable items that modify the attack power attribute of the player character.
 * @see [PlayerCharacter.calculateAttackPower]
 *
 * @property damageMod the multiplier for damage calculation.
 */
class Weapon(
		name: String= DEFAULT_ITEM_NAME,
		namePlural: String= DEFAULT_ITEM_NAME,
		desc: String= "",
		price: Int= 0,
		salePrice: Int= (price * DEFAULT_SALE_PRICE_MULT).toInt(),
		val damageMod: Double= 1.0
	): EquipableItem(name, namePlural, desc, price, salePrice)

/**
 * Used for equipable items that modify the player character's defense value.
 * @see [PlayerCharacter.calculateDefenseValue]
 *
 * @property armorMod the multiplier for defense calculation.
 */
class Armor(
		name: String= DEFAULT_ITEM_NAME,
		namePlural: String= DEFAULT_ITEM_NAME,
		desc: String= "",
		price: Int= 0,
		salePrice: Int= (price * DEFAULT_SALE_PRICE_MULT).toInt(),
		val armorMod: Double= 1.0
	): EquipableItem(name, namePlural, desc, price, salePrice)

