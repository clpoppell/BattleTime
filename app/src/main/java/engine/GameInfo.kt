package engine

import java.io.IOException

val ITEM_LIST= populateItemList()

private fun populateItemList(): Map<String, BaseItem>{
	var itemMap= HashMap<String, BaseItem>()

	try{
		val parser= XMLParserHandler()
		val istream= App.applicationContext().assets.open("items.xml")
		itemMap= parser.parseItemList(istream)
	} catch(e: IOException){
		e.printStackTrace()
	}

	return itemMap
}

class GameInfo{}