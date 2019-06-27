package engine

import android.app.Application

class App: Application(){
	init{ instance= this }

	companion object{
		private var instance: App?= null

		fun applicationContext(): App= instance as App
	}
}