package main

import main.Filter
import main.Source

public class Channel{
    private var source : Source? = null
    public var name : String = ""
    private var filter : Filter = Filter()

    fun setSource(s : Source){
        source?.deleteSource()?: println("Tried to delete a null source")
        source = s
    }
}