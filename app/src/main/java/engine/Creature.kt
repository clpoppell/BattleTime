package engine

/**
 * Super class for all in-game entities that can enter into battles.
 * <p> Allows all such entities to be stored in the same objects. </p>
 */

@Suppress("RemoveEmptyClassBody")
abstract class Creature(open val name: String= "DEFAULT", open val maximumHitPoints: Int= 0, open val strength: Int= 0, open val stamina: Int= 0){
}