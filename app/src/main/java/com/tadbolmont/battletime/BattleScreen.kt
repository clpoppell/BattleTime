package com.tadbolmont.battletime

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import engine.CharacterClass
import engine.Enemy
import engine.PlayerCharacter

const val TIMING: Long= 500 //TODO Decide on timing

class BattleScreen: Activity(){
    private val pc= PlayerCharacter(name= "Hank", charClass= CharacterClass("Jock", "A musclebound sports junkie"), maximumHP= 20, strength= 5, stamina= 5)
    private val enemy= Enemy(name= "Eidolon", maximumHitPoints= 10, strength= 5, stamina= 5, desc= "Basic enemy", rewardExperiencePoints= 5, rewardGold= 5)

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battle_screen)
    }

    /** Initiates a standard attack */
    fun attack(@Suppress("UNUSED_PARAMETER")view: View){
		displayBattleInfo()
    }

    /** Opens inventory view */
    fun accessInventory(@Suppress("UNUSED_PARAMETER") view: View){
        //TODO Create inventory view
    }

    /** Displays player character and enemy information. Is ran after updates to in-battle objects. */
    private fun displayBattleInfo(){
        val infoBox= findViewById<TextView>(R.id.battle_result_box)
        infoBox.text= """$pc"""

        Handler().postDelayed({
            infoBox.text= """
				|$pc
				|$enemy""".trimMargin()
        }, TIMING)
    }

    /** @suppress For development purposes only */
    fun fight(@Suppress("UNUSED_PARAMETER") view: View){
        enemy.changeCurrentHP(-pc.calculateAttackPower())
        displayBattleInfo()
    }
}