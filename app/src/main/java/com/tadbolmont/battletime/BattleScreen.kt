package com.tadbolmont.battletime

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import engine.Enemy
import engine.PlayerCharacter

class BattleScreen: Activity(){
    private val pc= PlayerCharacter(name= "Hank", maximumHP= 20, strength= 5, stamina= 5)
    private val enemy= Enemy(name= "Eidolon", maximumHitPoints= 10, strength= 5, stamina= 5, desc= "Basic enemy", rewardExperiencePoints= 5, rewardGold= 5)

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battle_screen)
    }

    fun fight(@Suppress("UNUSED_PARAMETER") view: View){
		enemy.changeCurrentHP(-pc.calculateAttackPower())
        displayBattleInfo()
    }

    fun attack(@Suppress("UNUSED_PARAMETER")view: View){
		displayBattleInfo()
    }

    fun accessInventory(@Suppress("UNUSED_PARAMETER") view: View){
		displayBattleInfo()
    }

    private fun displayBattleInfo(){
        val infoBox= findViewById<TextView>(R.id.battle_result_box)
        infoBox.text= """$pc
			             |
			             |$enemy""".trimMargin()
    }
}
