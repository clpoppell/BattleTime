package engine

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class XMLParserHandler{
	private var item: BaseItem?= null
	private var text: String?= null

	fun parseItemList(inputStream: InputStream): HashMap<String, BaseItem>{
		val items= HashMap<String, BaseItem>()

		try{
			val factory= XmlPullParserFactory.newInstance()
			factory.isNamespaceAware= true
			val parser= factory.newPullParser()

			parser.setInput(inputStream, null)
			var eventType= parser.eventType
			while(eventType != XmlPullParser.END_DOCUMENT){
				val tagname= parser.name
				when(eventType){
					XmlPullParser.START_TAG -> if(tagname.equals("Item", ignoreCase= true)){
						val type= parser.getAttributeValue(null, "type")
						if(type.equals("weapon", ignoreCase= true)){ item= Weapon() }
						if(type.equals("armor", ignoreCase= true)){ item= Armor() }
					}
					XmlPullParser.TEXT -> text= parser.text
					XmlPullParser.END_TAG -> if(tagname.equals("Item", ignoreCase= true)){
						item?.let{ items.put(it.name, it) }
					} else if(tagname.equals("Name", ignoreCase= true)){
						item!!.name= text!!
					} else if(tagname.equals("Plural", ignoreCase= true)){
						item!!.namePlural= text!!
					} else if(tagname.equals("Price", ignoreCase= true)){
						item!!.price= text!!.toInt()
					} else if(tagname.equals("SalePriceMultiplier", ignoreCase= true)){
						item!!.salePriceMultiplier= text!!.toDouble()
					} else if(tagname.equals("Description", ignoreCase= true)){
						item!!.desc= text!!
					} else if(tagname.equals("DamageMod", ignoreCase= true)){
						(item!! as Weapon).damageMod= text!!.toDouble()
					} else if(tagname.equals("ArmorMod", ignoreCase= true)){
						(item!! as Armor).armorMod= text!!.toDouble()
					}
				}
				eventType= parser.next()
			}
		} catch (e: XmlPullParserException){
			e.printStackTrace()
		} catch (e: IOException){
			e.printStackTrace()
		}
		return items
	}
}