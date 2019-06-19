package com.tadbolmont.battletime

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class MainMenu : Activity(){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
    }

    fun newGame(@Suppress("UNUSED_PARAMETER")view: View){
        val intent= Intent(this, BattleScreen::class.java)
        startActivity(intent)
    }
}
