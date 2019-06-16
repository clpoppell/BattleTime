package com.tadbolmont.battletime

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class BattleScreen: Activity(){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battle_screen)
    }

    @SuppressLint("SetTextI18n")
    fun fight(view: View){
        val infoBox= findViewById<TextView>(R.id.battle_result_box)
        infoBox.text= "You hit for 6 damage."
    }
}
