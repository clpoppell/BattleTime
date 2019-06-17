package com.tadbolmont.battletime

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import engine.PlayerCharacter

class BattleScreen: Activity(){
    var pc= PlayerCharacter("Hank", 20, 5, 5)

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battle_screen)
    }

    fun fight(view: View){
        pc= PlayerCharacter("Hank", 20, 5, 5)
        displayPCInfo()
    }

    fun attack(view: View){
        pc.changeCurrentHP(-6)
        displayPCInfo()
    }

    fun displayPCInfo(){
        val infoBox= findViewById<TextView>(R.id.battle_result_box)
        infoBox.text= pc.toString()
    }
}
